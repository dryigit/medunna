package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US002Page;
import utilities.Driver;


public class US002_StepDefinitions {
    Actions actions=new Actions(Driver.getDriver());
    Faker faker = new Faker();
     String password = faker.internet().password();
    US002Page us002page=new US002Page();

    @Then("kullanici username girer")
    public void kullaniciUsernameGirer() {
        String username = faker.name().username();
        actions.click(us002page.usernamrBox)
                .sendKeys(username)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .perform();

    }

    @Then("kullanici email girer")
    public void kullaniciEmailGirer() {
        String email = faker.internet().emailAddress();
        actions.click(us002page.emailBox)
                .sendKeys(email)
                .perform();

    }

    @Then("kullanici password girilebilmelidir")
    public void kullaniciPasswordGirilebilmelidir() {

        actions.click(us002page.passwordBox)
                .sendKeys(password)
                .sendKeys(Keys.ARROW_DOWN).perform();


    }

    @Then("kullanici password ikinci defa girilebilmelidir")
    public void kullaniciPasswordIkinciDefaGirilebilmelidir() {
        actions.click(us002page.confirmPasswordBox)
                .sendKeys(password);

    }

    @Then("kullanici register butonuna tıklar")
    public void kullaniciRegisterButonunaTıklar() {
        actions.click(us002page.registerButton2).perform();
    }
}
