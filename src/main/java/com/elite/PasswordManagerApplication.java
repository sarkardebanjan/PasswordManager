package com.elite;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.security.Security;

@SpringBootApplication
@ComponentScan(basePackages = { "com.elite" })
@EnableEncryptableProperties
public class PasswordManagerApplication {


	static {
		Security.setProperty("crypto.policy", "unlimited");
		//Security.addProvider(new BouncyCastleProvider());
	}

	public static void main(String[] args) {
		//System.out.println("JCE Strength: " + javax.crypto.Cipher.getMaxAllowedKeyLength("AES"));
		SpringApplication.run(PasswordManagerApplication.class, args);
		//new SpringApplicationBuilder().sources(Main.class).run(args);
	}

}
