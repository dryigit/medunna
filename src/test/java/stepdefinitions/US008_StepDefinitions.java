package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.US008Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US008_StepDefinitions {

    US008Page us008Page = new US008Page();

    @Given("adminOkan medunna anasayfasina gider")
    public void adminokanMedunnaAnasayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }

    @And("giris yapmak icin ikon altındaki signIn'e tiklar")
    public void girisYapmakIcinIkonAltındakiSignInETiklar() {

        us008Page.ikon.click();
        us008Page.ikonSignIn.click();

    }

    @Then("kullanici adini {string} girer")
    public void kullanıciAdiniGirer(String username) {
        us008Page.username.sendKeys(username);
    }

    @And("sifresini {string} girer")
    public void sifresiniGirer(String password) {
        us008Page.password.sendKeys(password);

    }

    @And("signIn sayfasindaki signIn butonuna tiklar")
    public void signinSayfasindakiSignInButonunaTiklar() {

        us008Page.signInSignInButton.submit();
    }

    @And("ikon altindaki password sekmesine tiklar")
    public void ikonAltindakiPasswordSekmesineTiklar() {

        us008Page.ikinciIkon.click();
        us008Page.passwordButton.click();
    }

    @And("gecerli sifresini {string} girer")
    public void gecerliSifresiniGirer(String currentPassword) {
        us008Page.currentPassword.sendKeys(currentPassword);

    }

    @And("yeni sifresini {string} girer")
    public void yeniSifresiniGirer(String newPassword) {
        us008Page.newPassword.sendKeys(newPassword);
    }

    @And("yeni sifresini {string} confirme eder")
    public void yeniSifresiniConfirmeEder(String newPassword) {
        us008Page.newPasswordConfr.sendKeys(newPassword);
    }

    @And("yeni sifreyi kaydetmek icin save butonuna tiklar")
    public void yeniSifreyiKaydetmekIcinSaveButonunaTiklar() {

        us008Page.saveButton.click();
    }

    @And("yeni sifresinin basarili olarak degistigini kontrol eder")
    public void yeniSifresininBasariliOlarakDegistiginiKontrolEder() {
       // Assert.assertFalse(us008Page.hataliSifreConfr.isDisplayed());

        Assert.assertTrue(us008Page.toastify.isEnabled());
    }

    @Then("giris yapilamadigini kontrol eder")
    public void girisYapilamadiginiKontrolEder() {

        Assert.assertTrue(us008Page.hataliSignIn.isDisplayed());

    }

    @Given("staffHakan medunna anasayfasına gider")
    public void staffhakanMedunnaAnasayfasınaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }

    @Given("kullanıcı yeni sifresini girer {string}")
    public void kullanıcıYeniSifresiniGirer(String newPassword) {

        us008Page.newPassword.sendKeys(newPassword);
    }


    @Given("kullanıcı en az yedi karakterli yeni sifre{string} girer")
    public void kullanıcıEnAzYediKarakterliYeniSifreGirer(String newPassword) {
        us008Page.newPassword.sendKeys(newPassword);
    }

    @Then("sifre zorluk seviyesinin {string} oldugunu dogrular")
    public void sifreZorlukSeviyesininOldugunuDogrular(String level) throws InterruptedException {

        sifreZorlukSeviyesi(level);

    }

    public void sifreZorlukSeviyesi(String level) throws InterruptedException {
            // switch case ile yapılabilir


        if (1==Integer.parseInt(level)) {
            Assert.assertTrue(us008Page.passwordStrengthFirst.isDisplayed());
            Thread.sleep(2);
        }

         else if (2==Integer.parseInt(level)) {
            Assert.assertTrue(us008Page.passwordStrengthSecond.isDisplayed());
            Thread.sleep(2);
        }

        else if (3==Integer.parseInt(level)) {
            Assert.assertTrue(us008Page.passwordStrengthThird.isDisplayed());
            Thread.sleep(2);
        }

        else if (4==Integer.parseInt(level)) {
            Assert.assertTrue(us008Page.passwordStrengthFourth.isDisplayed());
            Thread.sleep(2);
        }

        else if (5==Integer.parseInt(level)) {
            Assert.assertTrue(us008Page.passwordStrengthFifth.isDisplayed());
        }
    }

    @Given("kullanıcı yeni şifre kutusunu temizler")
    public void kullanıcıYeniŞifreKutusunuTemizler() {

        us008Page.newPassword.clear();
    }
}

