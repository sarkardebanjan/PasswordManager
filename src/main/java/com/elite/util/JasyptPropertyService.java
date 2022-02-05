package com.elite.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class JasyptPropertyService {

    @Autowired
    Environment environment;

    public String getProperty(String propertyKey) {
        return environment.getProperty(propertyKey);
    }
}
