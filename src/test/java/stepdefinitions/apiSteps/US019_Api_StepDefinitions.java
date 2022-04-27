package stepdefinitions.apiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import pojos.PopulateStaffinfo;
import pojos.PopulateStaffinfo;
import utilities.ConfigReader;

import static Hooks.Hooks.spec;

    public class US019_Api_StepDefinitions {

        PopulateStaffinfo staffInfo = new PopulateStaffinfo();
        Response response;

        @Given("AdminOkan sets up the path and params")
        public void adminokanSetsUpThePathAndParams() {
            spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
            spec.pathParams("bir","api","iki","register");

        }

        @Then("AdminOkan sends a request and get a response")
        public void adminokanSendsARequestAndGetAResponse() {
        }

        @And("AdminOkan saves the response to file")
        public void adminokanSavesTheResponseToFile() {
        }

        @And("AdminOkan verifies the expected and actual data")
        public void adminokanVerifiesTheExpectedAndActualData() {
        }
    }


