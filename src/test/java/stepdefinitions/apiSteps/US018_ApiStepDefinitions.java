package stepdefinitions.apiSteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Physician;
import utilities.Authentication;
import utilities.ConfigReader;

import java.io.IOException;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class US018_ApiStepDefinitions {

    Faker faker = new Faker();
    Physician physician = new Physician();
    Response response;

    @Given("lvnt gerekli path params ayarlamalarini yapar")
    public void lvntGerekliPathParamsAyarlamalariniYapar() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("bir","api","iki","physicians");
    }

    @And("lvnt gerekli parametreleri girer")
    public void lvntGerekliParametreleriGirer() {
        physician.setSsn(faker.idNumber().ssnValid());
        physician.setFirstName(faker.name().firstName());
        physician.setLastName(faker.name().lastName());
        physician.setBirthDate(faker.date().birthday(20,120).toString());
        physician.setPhone(faker.phoneNumber().cellPhone());
        physician.setBloodGroup("Apositive");
        physician.setSpeciality("SURGERY");
        physician.setExamFee("500");


    }

    @And("lvnt request gonderir ve response alir")
    public void lvntRequestGonderirVeResponseAlir() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("bir","api","iki","physicians");

        response =given().spec(spec).contentType(ContentType.JSON)
                .body(physician)
                .when()
                .put("/{bir}/{iki}");

        response.prettyPrint();

        System.out.println(response.statusCode());

    }

    @Then("lvnt api kayitlarini dogrular")
    public void lvntApiKayitlariniDogrular() throws IOException {
        response.then().statusCode(200);
        response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();
        Physician actualPhysician=obj.readValue(response.asString(), Physician.class);

        System.out.println("Actual Data: " + actualPhysician);

       /* Assert.assertEquals(.getFirstName(), actualRegistrant.getFirstName());
        Assert.assertEquals(registrant.getLastName(),actualRegistrant.getLastName());
        Assert.assertEquals(registrant.getEmail(),actualRegistrant.getEmail());
        Assert.assertEquals(registrant.getSsn(),actualRegistrant.getSsn());
        Assert.assertEquals(registrant.getLogin(),actualRegistrant.getLogin());
        */


    }

    @Given("lvnt kullanici medunna apiden {string} physician bilgilerini okur")
    public void lvntKullaniciMedunnaApidenPhysicianBilgileriniOkur(String url) {
        response = given().headers(
                "Authorization",
                "Bearer " + Authentication.generateToken(),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).
            when().
            get(url).
            then().
            extract().
            response();
        response.prettyPrint();
        Assert.assertEquals(200, response.statusCode());
    }

    @Given("lvnt kullanici api end point {string} den physician olusturur")
    public void lvntKullaniciApiEndPointDenPhysicianOlusturur(String url) {

        Physician physician = new Physician("anonymousUser","22-07-1996","Apositive","300","levo","366","nevo","333-333-4444","Surgery","200-36-3636","pattern", " user", "lvnt@gmail.com");
        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body(physician)
                .post(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        Assert.assertTrue(response.statusCode()==400);
    }


}
