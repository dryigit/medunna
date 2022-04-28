package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US002Page;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.Driver;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.WriteToTxt.saveRegistrantApiData;


public class US002_StepDefinitions {
    Actions actions=new Actions(Driver.getDriver());
    Faker faker = new Faker();
     String password = faker.internet().password();
    US002Page us002page=new US002Page();
    Registrant registrant = new Registrant();
    Response response;


   @Then("kullanici {string} girer")
   public void kullaniciGirer(String username) {
       actions.click(us002page.usernamrBox).sendKeys(username).perform();
   }
    @Then("kullanici {string} yazar ve sayfayi asagi kaydirir")
    public void kullaniciYazar(String email) {
       actions.click(us002page.emailBox).sendKeys(email).
               sendKeys(Keys.TAB).perform();
    }


    @Then("kullanici {string} girilebilmelidir")
    public void kullaniciGirilebilmelidir(String ilkPassword) {
       actions.click(us002page.emailBox).sendKeys(Keys.TAB).sendKeys(ilkPassword).sendKeys(Keys.TAB).perform();

    }

    @Then("kullanici {string} ikinci defa girilebilmelidir")
    public void kullaniciIkinciDefaGirilebilmelidir(String ikinciPassword) {
       actions.sendKeys(Keys.TAB).click(us002page.confirmPasswordBox).sendKeys(ikinciPassword).perform();
    }

    @Then("kullanici register butonuna tıklar")
    public void kullaniciRegisterButonunaTiklar() {
        actions.click(us002page.registerButton2).perform();
    }





}
