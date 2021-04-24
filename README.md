Cucumber-BDD-Framework
======
Cucumber BDD Framework using *Java, Maven, Junit, and Selenium*
-----
* [Features File](#Features)
* [Configuration Properties](#Configuration-Properties)
* [Configuration Reader](#Configuration-Reader)  
* [Folder Structure](#Folder-Structure) 
* [Dependencies](#Dependencies)
  * [Selenium](#Selenium)
  * [WebDriverManager](#WebDriver-Manager)
  * [Cucumber-Java](#Cucumber-Java)
  * [Cucumber-Junit](#Cucumber-JUnit)
  * [Java-Faker(Optional)](#Java-Faker)
* [Plugins](#Plug-Ins)  
  * [Maven Compiler Plugin](#Maven-Compiler-Plugin)
  * [Maven Surefire Plugin](#Maven-Surefire-Plugin)
  * [Maven Cucumber Reporting](#Maven-Cucumber-Reporting)
  
 
Folder Structure
===
Our main package takes place under test package, it should have your project name. 

  In our main package, we have 4 different packages. Pages, runners, step_definitions,
and utilities. Pages package has the page object classes, runners package has our runner classes this is where
we trigger our framework, step_definitions has implementation of our code for running the driver,
and utilities package is used for general utility classes.
    
Also under test package, there is a resources file, and under it we have our features directory for our feature files.

Finally, we have a configuration.properties file right under our root file.

Features
===
Feature files are used to write our test cases like scenarios from real life. This is what makes
our project Behaviour Driven. On top of using this file to write and read our test cases for automation, also non-technical people can
understand what we are testing. We need to provide path of these files in our [cukes runner class](src/test/java/com/company_name/project_name/runners/CukesRunner.java) 
for our framework to read test cases from these files. It is done by features keyword inside @CucumberOptions tag. 
It uses [Gherkin language](https://cucumber.io/docs/guides/overview/#what-is-gherkin) which makes plain test structured enough for cucumber
to understand. [Link for the reference](https://cucumber.io/docs/gherkin/reference/) from official website. In this project,
features files are located in test/resources/features. To see the example [click here.](src/test/resources/features/userstory1.feature)

Step Definitions
===
  [Step Defintions](src/test/java/com/company_name/project_name/step_definitions) is the package where we write our java code to
implement selenium logic. We have to implement all scenarios from our feature files otherwise it will give an error. 
The framework uses runners class to run these implementation, we need to provide path of this file in our [cukes runner class](src/test/java/com/company_name/project_name/runners/CukesRunner.java)
.This is done by using glue keyword inside @CucumberOptions tag.

Configuration Properties
===
  Configuration properties is a file where we store some important information that 
can change the flow of the whole framework. Such as browser type, environment, username and
password. It also helps us to avoid hard-coding, to change these values are easier
as we only have to change them in one place. 
[To see the file click here](configuration.properties)

Configuration Reader
===
  Configuration Reader is an utility class that we use to read data from [configuration.properties](#Configuration-Properties) file.
It has a private Properties object we load all the data from configuration.properties file, and we can get
this data using public getProperty method.


Dependencies
====
Selenium
---
```java
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
```
  Selenium is defined as "Selenium is an umbrella project for a range of tools and libraries that enable and support the automation of web browsers." in its [official 
website](https://www.selenium.dev/documentation/en/). It is basically the tool we automate browsers with for test automation.

WebDriver Manager
---
```java
<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>4.3.1</version>
        </dependency>
```

Normally, to use some browsers like Firefox,Safari,Chrome etc. we have to download their drivers which is 
their binary files that let WebDriver to handle the specific browser. It is cumbersome effort, and you have
to check new versions of driver manually. WebDriverManager can be used to make this process easier for us to
download any kind of Driver. For example:
```java
  WebDriverManager.chromedriver().setup();
  WebDriver driver = new ChromeDriver();
```
[For more information click here](https://github.com/bonigarcia/webdrivermanager)

Cucumber Java
---
  Dependency needed to integrate Cucumber into Java.
```java
<dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.10.0</version>
        </dependency>
```
Cucumber JUnit
---
  Dependency needed to run Cucumber with JUnit. Mostly, to
use assertions of JUnit.
```java
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>6.10.0</version>
            <scope>test</scope>
        </dependency>
```

Java Faker
---
  Dependency that is used to create all kinds of dummy data.

```java
 <dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
```

Plug-Ins
===

Maven Compiler Plugin
---
  To use the java 8 features (-source 1.8) and also compile classes to be compatible with JVM 1.8 (-target 1.8).
This plugin is needed.
```java

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>
</plugin>

```

Maven Surefire Plugin
---
  This plug-in allows us to run the cukes runner class from maven lifecycle. It also allows us to run our test parallel
using threadCount we can decide how many threads to run, also with parallel tag we can choose if we want to run methods or classes
parallel. Finally, if testFailureIgnore is true, it will continue with tests even if one test fails, otherwise
it will stop execution.
```java

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <parallel>methods</parallel>
                    <threadCount>4</threadCount>
                    <perCoreThreadCount>false</perCoreThreadCount>
                    <testFailureIgnore>true</testFailureIgnore>
                    <includes>
                        <include>**/CukesRunner*.java</include>
                    </includes>
                </configuration>
            </plugin>
```

Maven Cucumber Reporting
---
    This is 3rd party tool for a detailed report generation. It makes use of cucumber.json file to create the report.
```java
 <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>5.4.0</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>Cucumber HTML Reports</projectName>
                            <outputDirectory>${project.build.directory}</outputDirectory>
                            <inputDirectory>${project.build.directory}</inputDirectory>
                            <jsonFiles>
                                <param>**/cucumber*.json</param>
                            </jsonFiles>
                        </configuration>
                    </execution>
                </executions>
            </plugin>



```









