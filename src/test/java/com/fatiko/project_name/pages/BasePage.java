package com.fatiko.project_name.pages;

import com.fatiko.project_name.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    /*This class is base class of other pages, it initiliazes web elements that are defined in the page object classes,
    So we dont how to call PageFactory method in other page object classes that inherit from this class
    Also we can define some web elements that are common to all the classes in this class*/

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
