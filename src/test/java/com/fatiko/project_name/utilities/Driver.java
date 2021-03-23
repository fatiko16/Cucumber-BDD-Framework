package com.fatiko.project_name.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver(){}

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(driverPool.get() == null){
            synchronized (Driver.class){
                String browser = ConfigurationReader.getProperty("browser");
                switch (browser){
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                        driverPool.get().manage().window().maximize();
                        break;
                    default:
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
                }

            }
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }


























    /*This is the implementation of the Driver utility class when we dont need to execute parallel tests
    We can only get one instance from this class it applies lazy check
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

     */

}
