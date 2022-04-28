package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.US012Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;



public class US0012_StepDefinitions {

    US012Page us012Page = new US012Page();

    @When("Dk Medunna Sayfasina gider")
    public void dk_meduna_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));


    }

    @When("Ha Sing in Tiklar")
    public void sing_in_tiklar() {
    us012Page.ButtonTikla.click();
    us012Page.SingInButton.click();

    }

    @When("Ha Your Username Girer")
    public void your_username_girer() {

        us012Page.UsernameBox.sendKeys("doktorhadi");
    }

    @When("Ha Your Password Girer")
    public void your_password_girer() {
    us012Page.PasswordBox.sendKeys("12361236Ha.");
    }

    @When("Ha Sing İn Giris Yapar")
    public void sing_in_giris_yapar() {
    us012Page.SingInGirisButton.click();
    }

    @When("Ha My Pages Buttonunu Tiklar")
    public void my_pages_buttonunu_tiklar() {
    us012Page.MyPagesButton.click();

    }

    @When("Ha My Appointments Tiklar")
    public void my_appointments_tiklar() {
    us012Page.MyAppointmentsButton.click();

    }

    @When("Ha Edit Tiklar")
    public void edit_tiklar() {
    us012Page.EditButton.click();

    }

    @When("Ha Request A Test Tiklar")
    public void request_a_test_tiklar() {
        ReusableMethods.waitFor(2);
    us012Page.RequestATestButton.click();

    }

    @When("Ha Test Seceneklerini Girer")
    public void test_seceneklerini_girer() {
        Actions actions=new Actions(Driver.getDriver());

       us012Page.UreaElement.click();
       ReusableMethods.waitFor(2);
       us012Page.CreatinineElement.click();
        ReusableMethods.waitFor(2);
       us012Page.SodiumElement.click();
        ReusableMethods.waitFor(2);
       us012Page.PotassiumElement.click();
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        jse1.executeScript("arguments[0].click();",us012Page.TotalproteinElement);
       //us012Page.TotalproteinElement.click();
        JavascriptExecutor jse2 = (JavascriptExecutor) Driver.getDriver();
        jse2.executeScript("arguments[0].click();",us012Page.HemoglobinElement);
       // us012Page.HemoglobinElement.click();
        JavascriptExecutor jse3 = (JavascriptExecutor) Driver.getDriver();
        jse3.executeScript("arguments[0].click();",us012Page.AlbuminElement);
        //us012Page.AlbuminElement.click();
        JavascriptExecutor jse4 = (JavascriptExecutor) Driver.getDriver();
        jse4.executeScript("arguments[0].click();",us012Page.GlucoseElement);
        //us012Page.GlucoseElement.click();


        //JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        //javascriptExecutor.executeScript("window.scrollBy(0,200)");
       // JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
       // jse1.executeScript("arguments[0].click();",us012Page.AlbuminElement);
       //us012Page.AlbuminElement.click();
       // actions.sendKeys(Keys.PAGE_DOWN).perform();
       // us012Page.GlucoseElement.click();

    }

    @And("Ha Testleri Save Yapar")
    public void testleriSaveYapar() {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("window.scrollBy(0,6100)");

        ReusableMethods.waitForVisibility(us012Page.TestSaveButton,15);
        JavascriptExecutor jse5 = (JavascriptExecutor) Driver.getDriver();
        jse5.executeScript("arguments[0].click();",us012Page.TestSaveButton);
        //us012Page.TestSaveButton.click();

        //JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        //jse1.executeScript("arguments[0].click();",us012Page.TestSaveButton);

    }


    @Then("Ha Test Sonucunu Goster")
    public void haTestSonucunuGoster() {
        JavascriptExecutor jse2 = (JavascriptExecutor) Driver.getDriver();
        jse2.executeScript("arguments[0].click();",us012Page.ShowTestResults);
    }

    @Then("Ha Test Sonuclarina Bak")
    public void testSonuclarinaBak() {
        ReusableMethods.waitForVisibility(us012Page.TestsonuclarGoster,8);

        JavascriptExecutor jse3 = (JavascriptExecutor) Driver.getDriver();
        jse3.executeScript("arguments[0].click();",us012Page.TestsonuclarGoster);




        us012Page.TestResultElement.click();
        System.out.println("Test Sonuclari==>"+us012Page.TestResultElement.getText());



    }


}