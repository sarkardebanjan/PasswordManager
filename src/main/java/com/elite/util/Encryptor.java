package com.elite.util;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Encryptor {

    @Autowired
    StringEncryptor jasyptEncryptor;

    public String encrypt(String clearPass) {
        return jasyptEncryptor.encrypt(clearPass);
    }
}
