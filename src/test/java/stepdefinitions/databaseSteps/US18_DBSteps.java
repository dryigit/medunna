package stepdefinitions.databaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;
import java.util.ArrayList;
import java.util.List;

public class US18_DBSteps {

    @Given("lvnt user connects to the database")
    public void lvnt_user_connects_to_the_database() {
        DBUtils.createConnection();
    }

    @Given("lvnt user gets the {string} from {string} table")
    public void lvnt_user_gets_the_from_table(String column, String table) {
        String myDynamicQuery = "Select " + column + " from " + table;
        DBUtils.executeQuery(myDynamicQuery);
    }

    @Given("lvnt verify {string} table {string} column contains {string}")
    public void lvnt_verify_table_column_contains(String table, String column, String data) {
            List<Object> allColumnData = DBUtils.getColumnData("Select * from physician", "id");
            System.out.println(allColumnData);

            List<Object> expectedDta = new ArrayList<>();
            expectedDta.add(data);

            Assert.assertTrue(allColumnData.containsAll(expectedDta));
    }

    @Then("close the database connection")
    public void close_the_database_connection() {
        DBUtils.closeConnection();
    }
}
