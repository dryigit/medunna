package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.Select;
import pages.US018Page;
import utilities.ConfigReader;
import utilities.Driver;


import java.util.Random;

public class US018_StepDefinitions {
    US018Page page = new US018Page();
    Random random = new Random();
    Faker faker = new Faker();
    Select select = new Select(page.speciality);

    @Given("lvntt kullanici {string} sayfasina gider")
    public void lvnttKullaniciSayfasinaGider(String arg1) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));
    }

    @Given("lvnt kullanici gecerli bilgileri girerek basarili giris yapar")
    public void lvntKullaniciGecerliBilgileriGirerekBasariliGirisYapar() {
        page.EntryButton.click();
        page.singInButton.click();
        page.usernameButton.sendKeys("team85Admin");
        page.passwordButton.sendKeys("Batch44+");
        page.singInButton2.click();

    }

    @And("lvnt Items&Titles menusunden Physician'i secer")
    public void lvntItemsTitlesMenusundenPhysicianISecer() {
        page.itemsTitlesMenu.click();
        page.physician.click();

    }

    @Given("lvnt Create a new Physician'a tiklar")
    public void lvnt_create_a_new_physician_a_tiklar() {
        page.createNewPhysician.click();

    }

    @Given("lvnt Use Search'e tiklar")
    public void lvnt_use_search_e_tiklar() {
        page.useSearch.click();

    }

    @Given("lvnt SSN alanina varolan bir SSN numarasi girer")
    public void lvnt_ssn_alanina_varolan_bir_s_sn_numarasi_girer() {
        page.searchSSN.sendKeys("360-36-3636");
    }

    @Given("lvnt Search User'a tiklar")
    public void lvnt_search_user_a_tiklar() {
        page.searchUserButton.click();
    }

    @Given("lvnt kullanicinin bulundugunu dogrular")
    public void lvnt_kullanicinin_bulundugunu_dogrular() {
        page.toastify.isDisplayed();
    }

    @And("lvnt SSN numarasi kullanarak kayitli bir physician secer")
    public void lvntSSNNumarasiKullanarakKayitliBirPhysicianSecer() {
        page.createNewPhysician.click();
        page.useSearch.click();
        page.searchSSN.sendKeys("360-36-3636");
        page.searchUserButton.click();
    }

    @And("lvnt physician'in telefon, speciality, image, exam fee bilgilerini girer")
    public void lvntPhysicianInTelefonSpecialityImageExamFeeBilgileriniGirer() {
        page.physicianPhone.sendKeys(faker.phoneNumber().cellPhone());
        select.selectByIndex(random.nextInt());
    }

    @And("lvnt save butonuna basar ve bilgilerin kaydedildigini dogrular")
    public void lvntSaveButonunaBasarVeBilgilerinKaydedildiginiDogrular() {
        page.saveButton.click();
    }


}
