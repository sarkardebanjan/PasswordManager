package com.elite.config;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:encrypted.properties")
public class JasyptConfig {

    @Bean(name = "jasyptEncryptor")
    public StringEncryptor jasyptEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(10);
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getenv("APP_ENCRYPTION_PWD"));
        config.setAlgorithm("PBEWITHMD5ANDDES");
        //Was facing an issue with better algorithms like PBEWITHHMACSHA512ANDAES_256 as encryption is happening but decryption is not working even on windows command line cli version of jasypt. JCE is unlimited strength already.
        //config.setProvider(new BouncyCastleProvider());
        //config.setKeyObtentionIterations("1000");
        //config.setPoolSize("1");
        //config.setProviderName("SunJCE");
        //config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        //config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

}
