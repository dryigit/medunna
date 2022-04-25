package stepdefinitions.databaseSteps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class US23DbQuery {


    @Given("user connects to the database")
    public void user_connects_to_the_database() {
        DBUtils.createConnection();
        //db ye baglanmak.
    }
    @Given("user gets the {string} from {string} table")
    public void user_gets_the_from_table(String column, String table) {
       // String query = "Select " + column + " from " + table;
        String query ="Select * from bill";
        DBUtils.executeQuery(query);
    }
    @Given("user read all of the {string} column data")
    public void user_read_all_of_the_column_data(String column) throws SQLException {
        while (DBUtils.getResultset().next()){
            Object columnData = DBUtils.getResultset().getObject(column);
            System.out.println(columnData);
        }
        //tum column datasi geldi.
    }
    @Given("verify {string} tabel {string} column contains {string}")
    public void verify_tabel_column_contains(String table, String column, String data) {
        List<Object> allColumnData =DBUtils.getColumnData("Select * from bill","ssn");
        System.out.println(allColumnData);

        List<Object> expectedData = new ArrayList<>();
        expectedData.add(data);
        System.out.println(expectedData);

       Assert.assertTrue(allColumnData.containsAll(expectedData));
    }


}
