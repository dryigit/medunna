package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US020_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US020_StepDefinitions {


    US020_Page us020_page = new US020_Page();
    Actions actions = new Actions(Driver.getDriver());


    @Given("admin url gider")
    public void admin_url_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }

    @Then("admin username ve password ile giris yapar")
    public void admin_username_ve_password_ile_giris_yapar() {

        us020_page.username.sendKeys(ConfigReader.getProperty("MedunnaAdminUsername"));
        us020_page.password.sendKeys(ConfigReader.getProperty("MedunnaAdminPassword"));
        us020_page.singInEnter.click();


    }

    @Then("administration butonuna tiklar")
    public void administration_butonuna_tiklar() {

        us020_page.administrationButon.click();

    }

    @Then("user management butonuna tiklar")
    public void user_management_butonuna_tiklar() {

        us020_page.userManagementButon.click();

    }

    @Given("ilgili personeli bulur")
    public void ilgili_personeli_bulur() {

        us020_page.ilkKayitlikisi.click();

    }

    @Then("personel bilgisi icin viev tiklanir")
    public void personel_bilgisi_icin_viev_tiklanir() {

        us020_page.loginViev.click();

    }

    @Then("bilgiler gorulur")
    public void bilgiler_gorulur() {

        Assert.assertTrue(us020_page.firstnameViev.isDisplayed());
        Assert.assertTrue(us020_page.lastnameViev.isDisplayed());
        Assert.assertTrue(us020_page.emailViev.isDisplayed());
        Assert.assertTrue(us020_page.profilesViev.isDisplayed());


    }


    @Then("testdoktor icin edit tiklar")
    public void testdoktorIcinEditTiklar() {


        ReusableMethods.waitForVisibility(us020_page.sonsayfaButonu, 3);
        JSUtils.clickElementByJS(us020_page.sonsayfaButonu);


        ReusableMethods.scrollToWebEementVisivle(us020_page.doktorEdit);
        ReusableMethods.waitForVisibility(us020_page.sonsayfaButonu, 3);

        JSUtils.clickElementByJS(us020_page.doktorEdit);


    }


    @And("Activated bun-tonuna tiklar")
    public void activatedBunTonunaTiklar() {
        ReusableMethods.waitFor(2);

        JSUtils.clickElementByJS(us020_page.activatedButonu);

    }

    @Then("profil atamasi yapilir")
    public void profilAtamasiYapilir() {
        Select select = new Select(us020_page.profilDropdown);
        ReusableMethods.waitFor(2);
        select.selectByValue("ROLE_PHYSICIAN");
    }

    @And("save butonuna tiklanir")
    public void saveButonunaTiklanir() {
        JSUtils.clickElementByJS(us020_page.saveButonu);
        //us020_page.saveButonu.click();
    }


    @Then("testpersonel icin edit tiklar")
    public void testpersonelIcinEditTiklar() {

        ReusableMethods.waitForVisibility(us020_page.sonsayfaButonu, 3);
        JSUtils.clickElementByJS(us020_page.sonsayfaButonu);


        ReusableMethods.waitForVisibility(us020_page.personelEdit, 3);
        JSUtils.clickElementByJS(us020_page.personelEdit);


    }

    @Then("personel profil atamasi yapilir")
    public void personelProfilAtamasiYapilir() {
        Select select=new Select(us020_page.profilDropdown);
        select.selectByValue("ROLE_STAFF");

    }

    @Then("testhasta icin edit tiklar")
    public void testhastaIcinEditTiklar() {

        ReusableMethods.waitForVisibility(us020_page.sonsayfaButonu, 3);
        JSUtils.clickElementByJS(us020_page.sonsayfaButonu);


        ReusableMethods.waitForVisibility(us020_page.hastaEdit, 3);
        JSUtils.clickElementByJS(us020_page.hastaEdit);

    }

    @Then("hasta profil atamasi yapilir")
    public void hastaProfilAtamasiYapilir() {

        Select select=new Select(us020_page.profilDropdown);
        select.selectByValue("ROLE_PATIENT");


    }

    @Then("ilgili kullaniciyi silmek icin delete tiklar")
    public void silmekIcinDeleteTiklar() {


        ReusableMethods.waitForVisibility(us020_page.sonsayfaButonu, 3);
        JSUtils.clickElementByJS(us020_page.sonsayfaButonu);


        ReusableMethods.waitFor(3);

        JSUtils.clickElementByJS(us020_page.deletebutonu);

        //us020_page.deletebutonu.click();

        ReusableMethods.waitFor(3);

        JSUtils.clickElementByJS(us020_page.delet2Buton);

        //us020_page.delet2Buton.click();



     //   A user is deleted with identifier lelia.stoltenberg


    }
}
