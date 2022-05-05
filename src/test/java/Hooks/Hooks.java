package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

    public class Hooks {


        @Before
        public void setUp(){
        }





     @After
     public void tearDown(Scenario scenario){


         if (scenario.isFailed()) {
             final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshot, "image/png","screenshots");
         }
         Driver.closeDriver();
      }


    }