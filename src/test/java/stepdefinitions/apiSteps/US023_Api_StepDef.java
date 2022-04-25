package stepdefinitions.apiSteps;

import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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


    @Given("path params olustur")
    public void path_params_olustur() {

        //token olusturma

        String url = "https://www.medunna.com/api/authenticate";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", "staffSumey");
        requestBody.put("password", "Batch44+");
        requestBody.put("rememberMe", false);
        Response response = given().contentType(ContentType.JSON).when().body(requestBody).post(url);
        String token =response.jsonPath().getString("id_token");
        System.out.println(requestBody);

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        spec.pathParams("bir","api","iki","bills");

        Bills bills = new Bills("senoll","2022-04-14T16:17:45.545579Z",69105,"COMPLETED");
        System.out.println(bills);

        BillsPojo billsPojo = new BillsPojo(67608,"060-06-0541", 877.00,"CASH",bills);
        System.out.println(billsPojo);


        Response response1 = given().contentType(ContentType.JSON).accept(ContentType.JSON).spec(spec).when().auth().oauth2(token).
                            get("{bir}/{iki}");
        response.prettyPrint();

    }





}
