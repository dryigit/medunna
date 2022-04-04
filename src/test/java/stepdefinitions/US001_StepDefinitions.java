package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
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


    @And("mf kullanıcı ssn kutusunu bos birakirsa hata alir")
    public void mfKullanıcıSsnKutusunuBosBirakirsaHataAlir() {
        Actions action = new Actions(Driver.getDriver());
        action.click(us001page.ssnBox).sendKeys(Keys.TAB).perform();
        Assert.assertTrue("SSN Boş Bırakılamaz", us001page.ssnAllert.isDisplayed());

    }

    @And("mf kullanici gecerli bir ilk isim girer")
    public void mfKullaniciGecerliBirIlkIsimGirer() {
        Actions actions=new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String firstName=faker.name().firstName();;
        actions.click(us001page.firstNameBox).sendKeys(firstName).
                sendKeys(Keys.TAB).perform();
        Assert.assertFalse("İsim alanı bos birakilamaz",firstName.isBlank());

    }

    @And("mf kullanici gecerli bir soyisim isim girer")
    public void mfKullaniciGecerliBirSoyisimIsimGirer() {
        Actions actions=new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        actions.click(us001page.lastNameBox).sendKeys(lastName).sendKeys(Keys.TAB).perform();
        Assert.assertFalse("soyisim boş bırakılamaz", lastName.isBlank());
    }
}

