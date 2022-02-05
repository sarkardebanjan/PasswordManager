package com.elite.routes;

import com.elite.util.Decryptor;
import com.elite.util.Encryptor;
import com.elite.util.JasyptPropertyService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TimerRoute extends RouteBuilder {

    @Autowired
    private JasyptPropertyService jasyptPropertyService;

    @Autowired
    private Encryptor encryptor;

    @Autowired
    private Decryptor decryptor;

    @Autowired
    Environment environment;

    @Resource(name = "activeMqComponent")
    JmsComponent activeMqComponent;

    @Override
    public void configure() throws Exception {

        /*
        from("timer://simpleTimer?period=5000").process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String body = "Hello from timer at " + new Date();
                        exchange.getIn().setBody(body);
                    }
                })
                .to("seda:out1");

        from("seda:out1").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                System.out.println("Message read from seda: " + (exchange.getIn().getBody()).toString());
                System.out.println("Value of simple property: username.one=" + jasyptPropertyService.getProperty("username.one"));
                System.out.println("Value of simple property: username.three=" + jasyptPropertyService.getProperty("username.three"));
                System.out.println("Decrypted value of encrypted property: pass.one=" + jasyptPropertyService.getProperty("pass.one"));
                System.out.println("Decrypted value of encrypted property: pass.two=" + jasyptPropertyService.getProperty("pass.two"));
            }
        });
        */

        /*
        String fromActiveMqUri = "activeMqComponent:queue:" + environment.getProperty("jms.flow.test.q");
        from(fromActiveMqUri).process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                System.out.println("Read from active mq: " + (exchange.getIn().getBody()).toString());
            }
        });
        */

    }
}
