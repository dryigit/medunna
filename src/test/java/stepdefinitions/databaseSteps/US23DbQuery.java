package stepdefinitions.databaseSteps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class US23DbQuery {


    @Given("shuser connects to the database")
    public void shuser_connects_to_the_database() {
        DBUtils.createConnection();
        //db ye baglanmak.
    }
    @Given("shuser gets the {string} from {string} table")
    public void shuser_gets_the_from_table(String column, String table) {
       // String query = "Select " + column + " from " + table;
        String query ="Select * from bill";
        DBUtils.executeQuery(query);
    }
    @Given("shuser read all of the {string} column data")
    public void shuser_read_all_of_the_column_data(String column) throws SQLException {
        while (DBUtils.getResultset().next()){
            Object columnData = DBUtils.getResultset().getObject(column);
            System.out.println(columnData);
        }
        //tum column datasi geldi.
    }
    @Given("shverify {string} tabel {string} column contains {string}")
    public void shverify_tabel_column_contains(String table, String column, String data) {
        List<Object> allColumnData =DBUtils.getColumnData("Select * from bill","ssn");
        System.out.println(allColumnData);

        List<Object> expectedData = new ArrayList<>();
        expectedData.add(data);
        System.out.println(expectedData);

       Assert.assertTrue(allColumnData.containsAll(expectedData));
    }


}
