package com.elite.controller;

import com.elite.util.Decryptor;
import com.elite.util.Encryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private Encryptor encryptor;

    @Autowired
    private Decryptor decryptor;

    @Autowired
    private Environment environment;

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

}
