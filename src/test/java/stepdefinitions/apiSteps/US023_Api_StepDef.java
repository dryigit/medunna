package stepdefinitions.apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pojos.*;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US023_Api_StepDef {

    //BillsPojo expectedData;


    @Given("Path params olustur")
    public void path_params_olustur() {

        //token olusturma
        String url = "https://www.medunna.com/api/authenticate";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", "staffSumey");
        requestBody.put("password", "Batch44+");
        requestBody.put("rememberMe", false);
        Response response = given().contentType(ContentType.JSON).when().body(requestBody).post(url);
        String token = response.jsonPath().getString("id_token");

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        spec.pathParams("bir", "api", "iki", "bills","uc",67608);

        Response response1 = given().contentType(ContentType.JSON).accept(ContentType.JSON).spec(spec).when().auth().oauth2(token).
                get("{bir}/{iki}/{uc}");
        response1.prettyPrint();

        //actualData
        HashMap<String,Object> actualData =response1.as(HashMap.class);
        System.out.println(actualData);

        //Assert.assertTrue(actualData.get("id").toString().equals("67608"));
        response1.then().assertThat().body("id", Matchers.equalTo(67608));

        response1.then().assertThat().body("appointment.status", Matchers.equalTo("COMPLETED"));
        Assert.assertTrue(((Map)actualData.get("appointment")).get("status").toString().equals("COMPLETED"));



    }


    @Then("Olusturulan fatura dogrulama")
    public void olusturulanFaturaDogrulama() {

    }
}
