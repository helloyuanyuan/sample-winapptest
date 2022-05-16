package com.yzhang.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertyUtils {

    static PropertyUtils instance;
    Properties properties;

    public static PropertyUtils getInstance() {
        if (null == instance) {
            instance = new PropertyUtils();
        }
        return instance;
    }

    public PropertyUtils() {
        String propertiesFile = loadProperties("environment/env.properties").getProperty("env");
        propertiesFile = "environment/" + propertiesFile + ".properties";
        this.properties = loadProperties(propertiesFile);
    }

    synchronized public static Properties loadProperties(String propertiesFile) {
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = PropertyUtils.class.getClassLoader().getResourceAsStream(propertiesFile);
            properties.load(new InputStreamReader(in, "UTF-8"));
        } catch (FileNotFoundException e) {
            System.out.println(propertiesFile + "FILE NOT FOUND!");
        } catch (IOException e) {
            System.out.println(propertiesFile + "LOADING IOException!");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println(propertiesFile + "CLOSING IOException!");
            }
        }
        return properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getWindowsApplicationDriverUrl() {
        return this.getProperty("WindowsApplicationDriverUrl");
    }

    public String getNotepadPath() {
        return this.getProperty("notePadPath");
    }

    public String getCalculatorPath() {
        return this.getProperty("calculatorPath");
    }

}

