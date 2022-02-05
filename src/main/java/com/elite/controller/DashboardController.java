package com.elite.controller;

import com.elite.util.Decryptor;
import com.elite.util.Encryptor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class DashboardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private Encryptor encryptor;

    @Autowired
    private Decryptor decryptor;

    @Autowired
    private Environment environment;

    @Resource(name = "activeMqComponent")
    JmsComponent activeMqComponent;

    @Autowired
    ProducerTemplate producer;

    @GetMapping(path="/testEncryptionDecryption")
    public void testEncryptionDecryption() {
        String val = encryptor.encrypt("abcdefgh12345");
        String res = decryptor.decrypt(val);
        System.out.println("Encrypted: " + val);
        System.out.println("Decrypted: " + res);

        System.out.println("Value of simple property: username.one=" + environment.getProperty("username.one"));
        System.out.println("Value of simple property: username.three=" + environment.getProperty("username.three"));
        System.out.println("Decrypted value of encrypted property: pass.one=" + environment.getProperty("pass.one"));
        System.out.println("Decrypted value of encrypted property: pass.two=" + environment.getProperty("pass.two"));
    }

    @GetMapping(path = "/testJmsFlow")
    public void testJmsFlow() {
        String endpointUri = "activeMqComponent:queue:" + environment.getProperty("jms.flow.test.q");
        String body = "Hello. This msg was sent at " + new Date() + " to test jms TTL";
        producer.sendBody(endpointUri, body);
    }

}
