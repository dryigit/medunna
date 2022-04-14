package stepdefinitions.apiSteps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Registrant;
import utilities.ConfigReader;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.WriteToTxt.saveRegistrantApiData;

public class US001_ApiStepDefinition {
    Faker faker = new Faker();
    Registrant registrant= new Registrant();
    Response response;


    @Given("kullanici gerekli path params ayarlamalarini yapar")
    public void kullaniciGerekliPathParamsAyarlamalariniYapar() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("bir","api","iki","register");

    }

    @And("kullanici gerekli parametreleri girer {string}, {string} {string} {string} {string} {string} ve {string}")
    public void kullaniciGerekliParametreleriGirerVe(String firstname, String lastname, String SSN, String email, String username, String password, String lan) {
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
    public void kulllaniciApiKayitlariniDogrular() throws JsonProcessingException {
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
        }
