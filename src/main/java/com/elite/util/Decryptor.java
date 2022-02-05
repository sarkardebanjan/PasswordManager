package com.elite.util;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Decryptor {

    @Autowired
    StringEncryptor jasyptEncryptor;

    public String decrypt(String encryptedPass) {
        return jasyptEncryptor.decrypt(encryptedPass);
    }
}
