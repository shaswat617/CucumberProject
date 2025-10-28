package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    public static final String filePath = "src/test/resources/config/config.properties";

    public Properties initProperties()
    {
        properties = new Properties();
        try
        {
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return properties;
    }
}
