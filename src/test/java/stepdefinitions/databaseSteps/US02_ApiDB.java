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
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.DBUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.WriteToTxt.saveRegistrantApiData;

public class US02_ApiDB {

    Faker faker = new Faker();
    Registrant registrant = new Registrant();
    Response response;


    @Given("mf kullanici api icin gerekli path params ayarlamalarini yapar")
    public void mfKullaniciApiIcinGerekliPathParamsAyarlamalariniYapar() {
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




    @And("kullanici email testi icin request gonderir ve response alir")
    public void kullaniciEmailTestiIcinRequestGonderirVeResponseAlir() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("bir","api","iki","register");

        response =given().spec(spec).contentType(ContentType.JSON)
                .body(registrant)
                .when()
                .post("/{bir}/{iki}");
    }

    @When("kullanici email testi icin api kayitlarili ilgili dosyaya kaydeder")
    public void kullaniciEmailTestiIcinApiKayitlariliIlgiliDosyayaKaydeder() {
        saveRegistrantApiData(registrant);

    }

    @Then("email api ile dogrulanir")
    public void emailApiIleDogrulanir() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        Registrant actualRegistrant=obj.readValue(response.asString(), Registrant.class);

        System.out.println("Actual Data: " + actualRegistrant);
        Assert.assertEquals(registrant.getEmail(),actualRegistrant.getEmail());

    }

    @Given("mf kullanici email dogrulamasi icin db baglantisi kurar")
    public void mfKullaniciEmailDogrulamasiIcinDbBaglantisiKurar() {
        DBUtils.createConnection();

    }

    @Then("kullanici db testi icin {string} dogrular")
    public void kullaniciDbTestiIcinDogrular(String email) {
        String query="select * from jhi_user";
        DBUtils.executeQuery(query);
        List<Object> actualData= Collections.singletonList(DBUtils.getQueryResultList(query));
        Assert.assertTrue(actualData.toString().contains("mohammad.balistreri@yahoo.com"));
    }
}
