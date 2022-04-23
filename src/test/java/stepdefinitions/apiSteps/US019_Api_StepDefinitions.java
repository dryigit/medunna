package stepdefinitions.apiSteps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.StaffApi;
import utilities.ConfigReader;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveStaffApiData;

public class US019_Api_StepDefinitions {


        Response response;

        StaffApi staffApi = new StaffApi();


        @Given("AdminOkan sets up the path and params")
        public void adminokanSetsUpThePathAndParams() {
            spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
            spec.pathParams("bir","api","iki","staff", "uc", "67348");

        }

        @And("AdminOkan create expected data {string} {string} {string}")
        public void adminokanCreateExpectedData(String lastName, String firstName, String id) {
            staffApi.setLastName(lastName);
            staffApi.setFirstName(firstName);
            staffApi.setId(id);
        }


        @Then("AdminOkan sends a request and get a response")
        public void adminokanSendsARequestAndGetAResponse() {

            String token = generateToken();
            response=given().headers(
                    "Authorization",
                    "Bearer " + token).spec(spec).contentType(ContentType.JSON).when().get("/{bir}/{iki}/{uc}");

        }

        @And("AdminOkan saves the response to file")
        public void adminokanSavesTheResponseToFile() {
            saveStaffApiData(staffApi);


        }

        @And("AdminOkan verifies the expected and actual data")
        public void adminokanVerifiesTheExpectedAndActualData() throws JsonProcessingException {

            response.prettyPrint();
            ObjectMapper obj = new ObjectMapper();

            StaffApi actualStaffApi= obj.readValue(response.asString(),StaffApi.class);

            System.out.println("actualStaff = " + actualStaffApi);

            Assert.assertEquals("firstname",staffApi.getFirstName(),actualStaffApi.getFirstName());
            Assert.assertEquals("lastname",staffApi.getFirstName(),actualStaffApi.getFirstName());
            Assert.assertEquals("id",staffApi.getFirstName(),actualStaffApi.getFirstName());



        }


    }


