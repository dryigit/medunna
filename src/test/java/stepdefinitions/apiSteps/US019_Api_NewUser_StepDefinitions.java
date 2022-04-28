package stepdefinitions.apiSteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pojos.CreateNewUser;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;
import java.util.HashMap;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveNewUserApiData;

public class US019_Api_NewUser_StepDefinitions {

    // https://medunna.com/api/users

    /*
    {
            "login": "hakankemal",
            "firstName": "Hakan",
            "lastName": "Can",
            "ssn": "782-81-8844",
            "email": "hakankemal@gmail.com",
            "activated": false
    }

 */
    Response response;
    CreateNewUser createNewUser = new CreateNewUser();
    Faker faker = new Faker();



    @Given("AdminOki sets up the path and params")
    public void adminokiSetsUpThePathAndParams() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        spec.pathParams("first", "api", "second", "/users");
    }


    @And("AdminOki creates expected data_payload {string} {string} {string} {string} {string} with faker class")
    public void adminokiCreatesExpectedData_payloadWithFakerClass(String login, String firstName, String lastName, String ssn, String email) {

      //  createNewUser = new CreateNewUser("api_tester", "ali", "tan", "451-25-7854", "alitan@yahoo.com");


        login = faker.name().username();
        createNewUser.setLogin(login);

        firstName = faker.name().firstName();
        createNewUser.setFirstName(firstName);

        lastName=faker.name().lastName();
        createNewUser.setLastName(lastName);

        ssn=faker.idNumber().ssnValid();
        createNewUser.setSsn(ssn);

        email=faker.internet().emailAddress();
        createNewUser.setEmail(email);


    }

    @And("AdminOki saves the records to file")
    public void adminokiSavesTheRecordsToFile() {
        saveNewUserApiData(createNewUser);

    }


    @And("AdminOki sends the post request with token and gets the response and then validates")
        public void adminokiSendsThePostRequestWithTokenAndGetsTheResponseAndThenValidates() {


        String token = generateToken();

        // request'i alıp response icine atar

        response=given().contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + token)
                .spec(spec)
                .body(createNewUser)
                .when().post("{first}{second}");


        response.prettyPrint(); // dönen responsu konsolda goruruz

        HashMap<String, Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(createNewUser.getLogin().toString(), actualData.get("login").toString() );
        Assert.assertEquals(createNewUser.getFirstName().toString(), actualData.get("firstName").toString() );
        Assert.assertEquals(createNewUser.getLastName().toString(), actualData.get("lastName").toString() );
        Assert.assertEquals(createNewUser.getEmail().toString(), actualData.get("email").toString() );

        System.out.println("api testi basarili");

        }









    @Then("AdminOki validates the expected and actual data")
    public void adminokiValidatesTheExpectedAndActualData() throws IOException {
        System.out.println("Actual status code :" + response.statusCode());
        response.then().assertThat().statusCode(201);

        ObjectMapper obj=new ObjectMapper(); // com.fasterxml.jackson.databind package'ından geliyor
        CreateNewUser actualNewUser = obj.readValue(response.asString(), CreateNewUser.class);


       // CreateNewUser actualNewUser = response.as(CreateNewUser.class);

        System.out.println("Actual Data:" + actualNewUser);

        Assert.assertEquals(createNewUser.getLogin(), actualNewUser.getLogin());
        Assert.assertEquals(createNewUser.getFirstName(), actualNewUser.getFirstName());
        Assert.assertEquals(createNewUser.getLastName(), actualNewUser.getLastName());
        Assert.assertEquals(createNewUser.getSsn(), actualNewUser.getSsn());
        Assert.assertEquals(createNewUser.getEmail(), actualNewUser.getEmail());

    }


}
