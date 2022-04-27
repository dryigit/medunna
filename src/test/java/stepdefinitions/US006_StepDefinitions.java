package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.Select;
import pages.AccountSettings;

public class US006_StepDefinitions {

    AccountSettings accountSettings = new AccountSettings();
    Faker faker = new Faker();
    Select options = new Select(accountSettings.accountMenu);

    @And("lvnt kullanici account menu simgesine tiklar")
    public void lvntKullaniciAccountMenuSimgesineTiklar() {
        accountSettings.accountMenu.click();
    }

    @Given("lvnt kullanici acilan menuden sing-in'i secer")
    public void lvnt_kullanici_acilan_menuden_sing_in_i_secer() {
        accountSettings.firstSignIn.click();
    }
    @Given("lvnt username alanina {string} girer")
    public void lvnt_username_alanina_girer(String string) {
        accountSettings.username.sendKeys("userLevent");
    }
    @Given("lvnt password alanina {string} girer")
    public void lvnt_password_alanina_girer(String string) {
        accountSettings.password.sendKeys("Zlu.asdf1234");
    }
    @Given("lvnt sign in butonuna tiklar")
    public void lvnt_sign_in_butonuna_tiklar() {
        accountSettings.signInButton.click();
    }

    @And("lvnt kullanici user simgesine tiklar")
    public void lvntKullaniciUserSimgesineTiklar() {
        accountSettings.userMenu.click();
    }

    @Given("lvnt acilan menuden settings'i secer")
    public void lvnt_acilan_menuden_settings_i_secer() {
        accountSettings.settings.click();
    }
    @Given("lvnt  firstname alanina yeni bir isim girer")
    public void lvnt_firstname_alanina_yeni_bir_isim_girer() {
        accountSettings.firstName.sendKeys(faker.name().firstName());
    }
    @Given("lvnt lastname alanina yeni bir isim girer")
    public void lvnt_lastname_alanina_yeni_bir_isim_girer() {
        accountSettings.lastName.sendKeys(faker.name().lastName());
    }
    @Given("lvnt email alania yeni bir mail girer")
    public void lvnt_email_alania_yeni_bir_mail_girer() {
        accountSettings.email.sendKeys(faker.internet().emailAddress());
    }
    @Given("lvnt save butonuna tiklar")
    public void lvnt_save_butonuna_tiklar() {
        accountSettings.saveButton.click();
    }
    @Given("lvnt degisikliklerin kaydedildigini dogrular")
    public void lvnt_degisikliklerin_kaydedildigini_dogrular() {
        accountSettings.toastify.isDisplayed();
    }



}
