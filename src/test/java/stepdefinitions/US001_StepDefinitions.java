package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US001Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US001_StepDefinitions {
    US001Page us001page =new US001Page();

    @Given("mf kullanici {string} sayfasina gider")
    public void mfKullaniciSayfasinaGider(String website) {
        Driver.getDriver().get(ConfigReader.getProperty(website));
    }
    @And("mf kullanici menüde bulunan account simgesine tıklar")
    public void mfKullaniciMenüdeBulunanAccountSimgesineTıklar() {
        us001page.accountMenu.click();
    }

    @And("mf kullanici register butonuna tıklar")
    public void mfKullaniciRegisterButonunaTıklar() {
        us001page.registerButton.click();
    }

    @Then("mf kullanıcı ssn girer")
    public void mfKullanıcıSsnGirer() {
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(us001page.ssnBox)
                .sendKeys(faker.idNumber().ssnValid()).perform();

    }



}

