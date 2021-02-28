package com.fatiko.project_name.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //TODO: add all the drivers

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver ==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
            }
        }
        return driver;
    }

    public static void closeDriver(){

        if(driver!=null){
            driver.quit();
            driver = null;

        }
    }

}
