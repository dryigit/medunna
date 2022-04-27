package stepdefinitions.apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Bills;
import pojos.BillsPojo;
import utilities.ConfigReader;

import javax.xml.crypto.Data;

import java.util.HashMap;
import java.util.Map;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US023_Api_StepDef {

    Response respons;
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
        String token =response.jsonPath().getString("id_token");


        //String token = generateToken();
        System.out.println(requestBody);

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        spec.pathParams("bir","api","iki","bills");

       Bills bills = new Bills("senoll","2022-04-14T16:17:45.545579Z",69105,"COMPLETED");
        System.out.println(bills);

       BillsPojo expectedData = new BillsPojo(67608,"060-06-0541", 877.00,"CASH",bills);
        System.out.println(expectedData);


        Response response1 = given().contentType(ContentType.JSON).accept(ContentType.JSON).spec(spec).when().auth().oauth2(token).
                            get("{bir}/{iki}");
        response1.prettyPrint();

        //actualData
       BillsPojo actualData =response1.as(BillsPojo.class);

        Assert.assertEquals(expectedData.getId(),actualData.getId());
        // Assert.assertEquals(billsPojo.);
        //Assert.assertEquals(expectedData.getPaymentMethod(),actualData.getAppointment());
        Assert.assertEquals(expectedData.getSsn(),actualData.getSsn());
        //Assert.assertEquals(expectedData.getTotalCost(),actualData.getPaymentMethod());
        Assert.assertEquals(expectedData.getAppointment().getStatus(),actualData.getAppointment().getStatus());
        Assert.assertEquals(expectedData.getAppointment().getId(),actualData.getAppointment().getId());
        Assert.assertEquals(expectedData.getAppointment().getStatus(),actualData.getAppointment().getStatus());

    }


    @Then("Olusturulan fatura dogrulama")
    public void olusturulanFaturaDogrulama() {

    }
}
