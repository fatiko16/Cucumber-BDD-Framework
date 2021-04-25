package com.company_name.project_name.step_definitions;

import com.company_name.project_name.utilities.ConfigurationReader;
import com.company_name.project_name.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before()
    public void setUp(Scenario scenario){
        System.out.println("scenario = " + scenario.getSourceTagNames());
        System.out.println("scenario = " + scenario.getName());

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }



    @After()
    public void tearDown(Scenario scenario) {
       if(scenario.isFailed()){
           final byte[] screenshot =((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

        Driver.closeDriver();
    }
}
