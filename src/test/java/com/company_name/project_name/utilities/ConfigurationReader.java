package com.company_name.project_name.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    //TODO:Learn about Properties object and FileInputStream


    static{
        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("Something went wrong while reading from configuration.properties " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
