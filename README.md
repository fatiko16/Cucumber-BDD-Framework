Cucumber-BDD-Framework
======
Cucumber BDD Framework using *Java, Maven, Junit, and Selenium*
-----
* [Folder Structure](#Folder-Structure) 
* [Dependencies](#Dependencies)
  * Selenium
  * WebDriverManager
  * Cucumber-Java
  * Cucumber-Junit
  * Java-Faker(Optional)
* Plugins  
  * Maven Compiler Plugin
  * Maven Surefire Plugin
  * Maven Cucumber Reporting
  





Folder Structure
===
Our main package takes place under test package, it should have your project name. 

  In our main package, we have 4 different packages. Pages, runners, step_definitions,
and utilities. Pages package has the page object classes, runners package has our runner classes this is where
we trigger our framework, step_definitions has implementation of our code for running the driver,
and utilities package is used for general utility classes.
    
Also under test package, there is a resources file, and under it we have our features directory for our feature files.

Finally, we have a configuration.properties file right under our root file.

Dependencies
====





