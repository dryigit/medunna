package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.Driver;

public class US001_StepDefinitions {
    @Given("mf kullanici medunna sayfasina gider")
    public void kullanici_medunna_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }

    @And("mf kullanici register butonuna tıklar")
    public void mfKullaniciRegisterButonunaTıklar() {
    }
}

