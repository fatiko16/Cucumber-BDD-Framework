package com.fatiko.project_name.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /*Everything is static because we dont need any object of the class we just want to use one method from the class
    which is getProperty()

    To store properties file to an object*/
    private static Properties properties = new Properties();

    //TODO:Learn about Properties object and FileInputStream

    //We are dealing with loading and reading in a static initilization block since we need these to be ready when we call our
    //static getProperty method
    static{
        try{
            //To get information from configuration.properties file
            FileInputStream file = new FileInputStream("configuration.properties");
            //Loading the information to properties object
            properties.load(file);
            //Closing to stream to avoid any problems
            file.close();
        }catch (IOException e){
            System.out.println("Something went wrong while reading from configuration.properties " + e.getMessage());
            e.printStackTrace();
        }
    }
    //To reach the information from properties file from other classes our public getter method
    //It is good example for Encapsulation
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
