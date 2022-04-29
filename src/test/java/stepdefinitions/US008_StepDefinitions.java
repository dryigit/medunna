package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US008Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US008_StepDefinitions {

    US008Page us008Page = new US008Page();

    @Given("adminOkan medunna anasayfasina gider")
    public void adminokanMedunnaAnasayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }

    @And("adminOkan giris yapmak icin ikon altındaki signIn'e tiklar")
    public void adminOkangirisYapmakIcinIkonAltındakiSignInETiklar() {

        us008Page.ikon.click();
        us008Page.ikonSignIn.click();

    }

    @Then("adminOkan kullanici adini {string} girer")
    public void adminOkankullaniciAdiniGirer(String username) {
        us008Page.username.sendKeys(username);
    }

    @And("adminOkan sifresini {string} girer")
    public void adminOkansifresiniGirer(String password) {
        us008Page.password.sendKeys(password);

    }

    @And("adminOkan signIn sayfasindaki signIn butonuna tiklar")
    public void adminOkansigninSayfasindakiSignInButonunaTiklar() {

        us008Page.signInSignInButton.submit();
    }

    /*

    @And("adminOkan ikon altindaki password sekmesine tiklar")
    public void adminOkanikonAltindakiPasswordSekmesineTiklar() {

        us008Page.ikinciIkon.click();
        us008Page.passwordButton.click();
    }

    @And("adminOkan gecerli sifresini {string} girer")
    public void adminOkangecerliSifresiniGirer(String currentPassword) {
        us008Page.currentPassword.sendKeys(currentPassword);

    }

    @And("adminOkan yeni sifresini {string} girer")
    public void adminOkanyeniSifresiniGirer(String newPassword) {
        us008Page.newPassword.sendKeys(newPassword);
    }

    @And("adminOkan yeni sifresini {string} confirme eder")
    public void adminOkanyeniSifresiniConfirmeEder(String newPassword) {
        us008Page.newPasswordConfr.sendKeys(newPassword);
    }

    @And("adminOkan yeni sifreyi kaydetmek icin save butonuna tiklar")
    public void adminOkanyeniSifreyiKaydetmekIcinSaveButonunaTiklar() {

        us008Page.saveButton.click();
    }

    @And("adminOkan yeni sifresinin basarili olarak degistigini kontrol eder")
    public void adminOkanyeniSifresininBasariliOlarakDegistiginiKontrolEder() {
       // Assert.assertFalse(us008Page.hataliSifreConfr.isDisplayed());

        Assert.assertTrue(us008Page.toastify.isEnabled());
    }
    */


    @Then("staffHakan giris yapilamadigini kontrol eder")
    public void staffHakangirisYapilamadiginiKontrolEder() {

        Assert.assertTrue(us008Page.hataliSignIn.isDisplayed());

    }


    @Given("staffHakan medunna anasayfasina gider")
    public void staffhakanMedunnaAnasayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));
    }

    @And("staffHakan giris yapmak icin ikon altindaki signIn'e tiklar")
    public void staffhakanGirisYapmakIcinIkonAltindakiSignInETiklar() {
        us008Page.ikon.click();
        us008Page.ikonSignIn.click();
    }

    @Then("staffHakan kullanici adini {string} girer")
    public void staffhakanKullaniciAdiniGirer(String username) {
        us008Page.username.sendKeys(username);
    }

    @And("staffHakan sifresini {string} girer")
    public void staffhakanSifresiniGirer(String password) {
        us008Page.password.sendKeys(password);
    }

    @And("staffHakan signIn sayfasindaki signIn butonuna tiklar")
    public void staffhakanSignInSayfasindakiSignInButonunaTiklar() {
        us008Page.signInSignInButton.submit();
    }

    @And("staffHakan ikon altindaki password sekmesine tiklar")
    public void staffhakanIkonAltindakiPasswordSekmesineTiklar() {
        us008Page.ikinciIkon.click();
        us008Page.passwordButton.click();
    }

    @And("staffHakan gecerli sifresini {string} girer")
    public void staffhakanGecerliSifresiniGirer(String currentPassword) {
        us008Page.currentPassword.sendKeys(currentPassword);
    }

    @And("staffHakan yeni sifresini girer {string}")
    public void staffhakanYeniSifresiniGirer(String newPassword) {
        us008Page.newPassword.sendKeys(newPassword);
    }

    @Then("staffHakan sifre zorluk seviyesinin {string} oldugunu dogrular")
    public void staffhakanSifreZorlukSeviyesininOldugunuDogrular(String level) throws InterruptedException {
        sifreZorlukSeviyesi(level);
    }

    @Given("staffHakan yeni sifre kutusunu temizler")
    public void staffhakanYeniSifreKutusunuTemizler() {
        ReusableMethods.waitForClickablility(us008Page.newPassword, 3);
        us008Page.newPassword.clear();
    }

    @And("staffHakan en az yedi karakterli yeni sifre{string} girer")
    public void staffhakanEnAzYediKarakterliYeniSifreGirer(String newPassword) {
        us008Page.newPassword.sendKeys(newPassword);
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



}

