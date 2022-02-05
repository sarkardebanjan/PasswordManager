package com.elite.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.jms.JmsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;

@Configuration
@PropertySource("classpath:application.properties")
public class ActiveMqJmsConfig {

    @Autowired
    Environment environment;

    @Bean(name = "activeMqConnectionFactory")
    public ActiveMQConnectionFactory activeMqConnectionFactory() {
        ActiveMQConnectionFactory activeMqConnectionFactory = new ActiveMQConnectionFactory();
        activeMqConnectionFactory.setBrokerURL(environment.getProperty("activemq.broker.url"));
        return activeMqConnectionFactory;
    }

    @Bean(name = "activeMqCacheConnectionFactory")
    public CachingConnectionFactory activeMqCacheConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setTargetConnectionFactory(activeMqConnectionFactory());
        cachingConnectionFactory.setSessionCacheSize(Integer.parseInt(environment.getProperty("activemq.connection.cache.size")));
        return cachingConnectionFactory;
    }

    @Bean
    public JmsTransactionManager jmsTransactionManager() {
        JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
        jmsTransactionManager.setConnectionFactory(activeMqCacheConnectionFactory());
        return jmsTransactionManager;
    }

    @Bean(name = "activeMqJmsConfiguration")
    public JmsConfiguration activeMqJmsConfiguration() {
        JmsConfiguration jmsConfiguration = new JmsConfiguration();
        jmsConfiguration.setConnectionFactory(activeMqCacheConnectionFactory());
        jmsConfiguration.setTransacted(true);
        jmsConfiguration.setLazyCreateTransactionManager(false);
        jmsConfiguration.setDisableTimeToLive(true);
        //jmsConfiguration.setDisableTimeToLive(false);
        //jmsConfiguration.setTimeToLive(300000);
        jmsConfiguration.setTransactionManager(jmsTransactionManager());
        return jmsConfiguration;
    }

    @Bean(name = "activeMqComponent")
    public JmsComponent activeMqComponent() {
        JmsComponent jmsComponent = new JmsComponent();
        jmsComponent.setConfiguration(activeMqJmsConfiguration());
        return jmsComponent;
    }

}
