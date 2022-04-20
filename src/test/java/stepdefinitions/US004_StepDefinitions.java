package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.US004Page;
import utilities.Driver;

public class US004_StepDefinitions {
    US004Page us004page=new US004Page();
    Actions actions=new Actions(Driver.getDriver());

    @And("mf kullanici menude bulunan account simgesine tiklar")
    public void mfKullaniciMenudeBulunanAccountSimgesineTiklar() {
        us004page.us04AccountLink.click();

    }

    @And("mf acilan alt menuden sign in butonuna tiklar")
    public void mfAcilanAltMenudenSignInButonunaTiklar() {
        us004page.us04SingIn.click();

    }

    @Then("cikan pencerede dogru {string} ve {string} girip sign in yaptiginda menude mypages sekmesini gorur")
    public void cikanPenceredeDogruVeGiripSignInYaptigindaMenudeMypagesSekmesiniGorur(String username, String password) {

        us004page.us04username.sendKeys(username);
        us004page.us04password.sendKeys(password);
        us004page.us04signIn.click();

        Assert.assertTrue(us004page.us04myPages.isDisplayed());



    }
}
