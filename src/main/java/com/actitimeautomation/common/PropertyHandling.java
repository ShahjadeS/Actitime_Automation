package com.actitimeautomation.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {
    Properties properties;
    public PropertyHandling() throws IOException {
        //Access config.properties file

        //1. Get the path of the project
        String filePath = System.getProperty("user.dir") + "/config.properties";

        //2. Access the config.properties file
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //3. Create an object of Properties class
        properties = new Properties();

        //4. Load the file into Properties class
        properties.load(fileInputStream);
    }

    public String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
