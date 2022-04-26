package stepdefinitions.databaseSteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.US001Page;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.WriteToTxt.saveRegistrantApiData;

public class US001_DBQuery {
    DBUtils db =new DBUtils();
    Faker faker = new Faker();
    Actions actions=new Actions(Driver.getDriver());
    Registrant registrant = new Registrant();
    Response response;

    @Given("kullanici gerekli path params ayarlamalarini yapar")
    public void kullaniciGerekliPathParamsAyarlamalariniYapar() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("bir","api","iki","register");

    }

    @And("mfdbkullanici gerekli parametreleri girer {string}, {string} {string} {string} {string} {string} ve {string}")
    public void mfdbkullaniciGerekliParametreleriGirerVe(String firstname, String lastname, String SSN, String email, String username, String password, String lan) {
        firstname=faker.name().firstName();
        lastname=faker.name().lastName();
        SSN=faker.idNumber().ssnValid();
        email=faker.internet().emailAddress();
        username=faker.name().username();
        password=faker.internet().password(8,15,true,true);

        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        registrant.setSsn(SSN);
        registrant.setEmail(email);
        registrant.setLogin(username);
        registrant.setPassword(password);
    }

    @And("kullanici request gonderir ve response alir")
    public void kullaniciRequestGonderirVeResponseAlir() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("bir","api","iki","register");

        response =given().spec(spec).contentType(ContentType.JSON)
                .body(registrant)
                .when()
                .post("/{bir}/{iki}");
    }

    @When("kullanici api kayitlarili ilgili dosyaya kaydeder")
    public void kullaniciApiKayitlariliIlgiliDosyayaKaydeder() {
        saveRegistrantApiData(registrant);

    }

    @Then("kulllanici api kayitlarini dogrular")
    public void kulllaniciApiKayitlariniDogrular() throws IOException {
        response.then().statusCode(201);
        response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();
        Registrant actualRegistrant=obj.readValue(response.asString(), Registrant.class);

        System.out.println("Actual Data: " + actualRegistrant);

        Assert.assertEquals(registrant.getFirstName(), actualRegistrant.getFirstName());
        Assert.assertEquals(registrant.getLastName(),actualRegistrant.getLastName());
        Assert.assertEquals(registrant.getEmail(),actualRegistrant.getEmail());
        Assert.assertEquals(registrant.getSsn(),actualRegistrant.getSsn());
        Assert.assertEquals(registrant.getLogin(),actualRegistrant.getLogin());





    }

    @Given("mf kullanici database baglantisi kurar")
    public void kullaniciDatabaseBaglantisiKurar() {
        DBUtils.createConnection();
    }


    @Then("kullanici {string} verilerini dogrular")
    public void kullaniciVerileriniDogrular(String SSN) {
        String query="select * from jhi_user";
        DBUtils.executeQuery(query);
        List<Object> actualData= Collections.singletonList(DBUtils.getQueryResultList(query));
        Assert.assertTrue(actualData.toString().contains(SSN));
    }

}
