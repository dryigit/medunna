package stepdefinitions.databaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;
import utilities.DBUtils;

import java.util.List;

public class US16DBquery {
    @Given("yep connects database")
    public void yepConnectsDatabase() {
    DBUtils.createConnection();
    }

    @Then("yep closes db connection")
    public void yepClosesDbConnection() {
        DBUtils.closeConnection();
    }



    @And("yep send query {string} {string} from {string} where {string} {string}")
    public void yepSendQueryFromWhere(String select, String data, String table, String column, String number) {
        String patientQuery=select+data+ " from " +table+ " where " +column+" = "+number;
        DBUtils.executeQuery(patientQuery);



    }

    @Given("yep admin connects database")
    public void yepAdminConnectsDatabase() {
        DBUtils.createConnection();
    }

    @And("yep admin send query {string} {string} from {string} where {string} {string}")
    public void yepAdminSendQueryFromWhere(String select, String data, String table, String column, String number) {
        String patientQuery=select+data+ " from " +table+ " where " +column+" = "+number;
       String query="select * from jhi_user";
        DBUtils.executeQuery(query);
    }
}
