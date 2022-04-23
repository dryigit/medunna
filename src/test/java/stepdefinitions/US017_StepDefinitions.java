package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US017_Page;
import pojos.TestItem;
import utilities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.deleteRequest;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.getSSNIDs;
import static utilities.ReadTxt.getTestItemIDs;
import static utilities.WriteToTxt.saveTestItemData;
import static utilities.WriteToTxt.saveTestItemsData;

public class US017_StepDefinitions {
US017_Page page=new US017_Page();
Response response;
TestItem testItem=new TestItem();
String endpointToDelete;
    List< Object> allDBItemIds;

    @When("Kullanici medunna anasayfasina gider")
    public void kullaniciMedunnaAnasayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }

    @Then("Admin olarak giris yapar")
    public void admin_olarak_giris_yapar(io.cucumber.datatable.DataTable dataTable) {
        List<String> loginCredintals=dataTable.row(1);
        page.girisyap(loginCredintals.get(0),loginCredintals.get(1));
    }


    @Then("Menuden Items&Titles butonunu tiklar")
    public void menudenItemsTitlesButonunuTiklar() {
        page.itemsTitlesButton.click();
    }

    @And("Test item secenegini tiklar")
    public void testItemSeceneginiTiklar() {
        page.testItemButton.click();
    }

    @Then("Create a new test item butonunu tiklar")
    public void createANewTestItemButonunuTiklar() {
        page.createANewTestItemButton.click();
    }

    @Then("Test item bilgilerini doldurur")
    public void testItemBilgileriniDoldurur() {
        Actions actions=new Actions(Driver.getDriver());
        actions.click(page.nameTextBox).sendKeys(Faker.instance().funnyName().name())
                .sendKeys(Keys.TAB).sendKeys(Faker.instance().pokemon().name())
                .sendKeys(Keys.TAB).sendKeys(Faker.instance().random().nextInt(100,500).toString())
                .sendKeys(Keys.TAB).sendKeys(Faker.instance().random().nextInt(10,100).toString())
                .sendKeys(Keys.TAB).sendKeys(Faker.instance().random().nextInt(200,300).toString())
                .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }


    @And("A new Test Item is created with identifier yazisi gorulur olmali")
    public void aNewTestItemIsCreatedWithIdentifierYazisiGorulurOlmali() {
        Assert.assertTrue(page.basariliItemOlusturulduText.isDisplayed());
    }

    @Then("Name, Description, price Default min value, Default max value and created date as MM DAY YEAR kutularinin goruntulendigini dogrular\"")
    public void nameDescriptionPriceDefaultMinValueDefaultMaxValueAndCreatedDateAsMMDAYYEARKutularininGoruntulendiginiDogrular() throws Throwable {
        Assert.assertTrue(page.nameTextBox.isDisplayed());
        Assert.assertTrue(page.descriptionBox.isDisplayed());
        Assert.assertTrue(page.minValueBox.isDisplayed());
        Assert.assertTrue(page.maxValueBox.isDisplayed());
        Assert.assertTrue(page.createdDateBox.isDisplayed());
    }

    @Then("Test Items yazisi gorunur olmali")
    public void testItemsYazisiGorunurOlmali() {
        Assert.assertTrue(page.testItemsText.isDisplayed());
    }

    @Then("Created Date sekmesine tiklar")
    public void createdDateSekmesineTiklar() {
        ReusableMethods.waitFor(1);
        page.createdDateButton.click();
    }

    @And("Edit butonuna tiklar")
    public void editButonunaTiklar() {
        ReusableMethods.waitFor(1);
        page.editButtonList.get(0).click();
    }

    @And("Name, Description, price Default min value, Default max value bilgilerini gunceller")
    public void nameDescriptionPriceDefaultMinValueDefaultMaxValueBilgileriniGunceller() {
        Actions actions=new Actions(Driver.getDriver());
        page.nameTextBox.clear();
        actions.click(page.nameTextBox).sendKeys(Keys.ENTER).sendKeys(Faker.instance().funnyName().name())
                .sendKeys(Keys.TAB).sendKeys(Faker.instance().pokemon().name())
                .sendKeys(Keys.TAB).sendKeys(Faker.instance().random().nextInt(100,500).toString())
                .sendKeys(Keys.TAB).sendKeys(Faker.instance().random().nextInt(10,100).toString())
                .sendKeys(Keys.TAB).sendKeys(Faker.instance().random().nextInt(200,300).toString())
                .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB) .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }






    @Then("{string} basarili guncelleme yazisini dogrular")
    public void basariliGuncellemeYazisiniDogrular(String metin) throws IOException {
        ReusableMethods.getScreenshot("tostify");
    //        String toasttext = page.toasttify.getText().toString();
      //      System.out.println("writen text " + toasttext);
        //    Assert.assertTrue(toasttext.contains(metin));
        Assert.assertTrue(page.basariliEditText.isDisplayed());
    }



    @Then("Delete Butonunu tiklar")
    public void deleteButonunuTiklar() {
        page.createdDateButton.click();
        ReusableMethods.waitFor(1);
        page.deleteButtonList.get(0).click();
    }

    @And("Acilan pencerede delete butonuna tiklar")
    public void acilanPenceredeDeleteButonunaTiklar() {
        ReusableMethods.waitFor(2);
        page.deleteButtonList.get(40).click();
    }

    @Then("Silindi yazisi gorulebilmeli")
    public void silindiYazisiGorulebilmeli() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(page.itemDeletedText.isDisplayed());
    }


    @Then("Sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @Given("kullanici gerekli items icin path params ayarlamalarini yapar")
    public void kullaniciGerekliItemsIcinPathParamsAyarlamalariniYapar() {
        spec.pathParams("first","api","second","c-test-items","third","72800");

    }

    @Then("kullanici test items icin expected datalari olusturur {string}, {string}, {string}, {string}, {int}")
    public void kullanici_test_items_icin_expected_datalari_olusturur(String defMaxVal, String defMinVal, String description, String name, int price) {
    //    defMaxVal=Faker.instance().random().nextInt(150,250).toString();
    //    defMinVal=Faker.instance().random().nextInt(10,100).toString();
    //    description=Faker.instance().pokemon().name();
    //    name=Faker.instance().funnyName().name();
    //    price=Faker.instance().random().nextInt(100,250).intValue();

        testItem.setDefaultValMax(defMaxVal);
        testItem.setDefaultValMin(defMinVal);
        testItem.setDescription(description);
        testItem.setName(name);
        testItem.setPrice(price);

    }

    @Then("kullanici test items olusturmak icin expected datalari olusturur {string}, {string}, {string}, {string}, {int}")
    public void kullaniciTestItemsOlusturmakIcinExpectedDatalariOlusturur(String defMaxVal, String defMinVal, String description, String name, int price) {
            defMaxVal=Faker.instance().random().nextInt(150,250).toString();
            defMinVal=Faker.instance().random().nextInt(10,100).toString();
            description=Faker.instance().pokemon().name();
            name=Faker.instance().funnyName().name();
            price=Faker.instance().random().nextInt(100,250).intValue();

        testItem.setDefaultValMax(defMaxVal);
        testItem.setDefaultValMin(defMinVal);
        testItem.setDescription(description);
        testItem.setName(name);
        testItem.setPrice(price);
    }

    @Then("kullanici items icin request gonderir ve response alir")
    public void kullaniciItemsIcinRequestGonderirVeResponseAlir() {
        String token = generateToken();
        response=given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}/{third}");

    }

    @And("kullanici API kayitlarini dosyaya kaydeder")
    public void kullaniciAPIKayitlariniDosyayaKaydeder() {
        saveTestItemData(testItem);

    }

    @And("kullanici API kayitlarini onaylar")
    public void kullaniciAPIKayitlariniOnaylar() throws IOException {
        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
        TestItem actualTestItem= obj.readValue(response.asString(),TestItem.class);

        System.out.println("actualTestItem = " + actualTestItem);

        Assert.assertEquals("Test item isimleri farkli",testItem.getName(),actualTestItem.getName());
        Assert.assertEquals("Test item defMinValue farkli",testItem.getDefaultValMin(),actualTestItem.getDefaultValMin());
        Assert.assertEquals("Test item defMaxValue farkli",testItem.getDefaultValMax(),actualTestItem.getDefaultValMax());
        Assert.assertEquals("Test item description farkli",testItem.getDescription(),actualTestItem.getDescription());
        Assert.assertEquals("Test item price farkli",testItem.getPrice(),actualTestItem.getPrice());
    }


    @Given("kullanici post islemi icin gerekli items icin path params ayarlamalarini yapar")
    public void kullaniciPostIslemiIcinGerekliItemsIcinPathParamsAyarlamalariniYapar() {
        spec.pathParams("first","api","second","c-test-items");
    }

    @Then("kullanici items olusturmak ve post islemi icin request gonderir ve response alir")
    public void kullaniciItemsOlusturmakVePostIslemiIcinRequestGonderirVeResponseAlir() {
        String token = generateToken();
        response = given().headers(
                "Authorization",
                "Bearer " + token).given().spec(spec).contentType(ContentType.JSON).body(testItem).when().post("/{first}/{second}");
    }

    //delete ite api
    @Given("user sets the necessary path parameters {string}")
    public void userSetsTheNecessaryPathParameters(String id) {
      spec.pathParams("first","api","second","c-test-items","third",id);
        endpointToDelete = ConfigReader.getProperty("api_test_items_endpoint") + "/" +id;
    }

    @When("user sends delete request and gets the response")
    public void userSendsDeleteRequestAndGetsTheResponse() {
        response = deleteRequest(generateToken(), endpointToDelete);
    }

    @Then("user validates that the item {string} has been deleted")
    public void userValidatesThatTheItemHasBeenDeleted(String id) {
   response.then().assertThat().statusCode(204);
        //    response = getRequest(generateToken(),ConfigReader.getProperty("api_test_items_endpoint"));
   /*      HashMap<String,Object> idData=response.as(HashMap.class);
    //    List<String> idData=response.as(List.class);
        System.out.println("idData.= " + idData);
        int size= idData.size();
        for (int i = 0; i < size; i++) {
            Assert.assertNotEquals("id ye ait item silinemedi",idData.get("id"),id);
        }
*/

     // response.then().assertThat().body("id", hasItem(id));
    }
    //Test item DB
    @Given("user creates a connection with DB using {string} and {string} , {string}")
    public void userCreatesAConnectionWithDBUsingAnd(String url, String username, String password) {
        DatabaseUtility.createConnection(url,username,password);
    }





    @Given("user sends the query to DB and gets the column data {string} and {string}")
    public void userSendsTheQueryToDBAndGetsTheColumnDataAnd(String query, String columnName) {
        allDBItemIds =DatabaseUtility.getColumnData(query,columnName);
        System.out.println("allDBItemNames = " + allDBItemIds);
    }

    @Then("user saves the DB records to correspondent files")
    public void userSavesTheDBRecordsToCorrespondentFiles() {
        saveTestItemsData(allDBItemIds);
    }

    @And("user validates DB test item data")
    public void userValidatesDBTestItemData() {
        List<String> expectedTestItemIDs = new ArrayList<>();
        expectedTestItemIDs.add("30198");
        expectedTestItemIDs.add("1402");
        expectedTestItemIDs.add("1403");
        expectedTestItemIDs.add("1404");

        List<String> actualData = getTestItemIDs();//All records

        Assert.assertTrue(actualData.containsAll(expectedTestItemIDs));
    }
    @Then("user close the database connection")
    public void userCloseTheDatabaseConnection() {
        DatabaseUtility.closeConnection();
    }

    @Given("user connects to the database")
    public void userConnectsToTheDatabase() {
        DatabaseUtility.createConnection();
    }

    @And("user gets the {string} from {string} table")
    public void userGetsTheFromTable(String column, String table) {
        String myDynamicQuery = "select " + column + " from " + table;
        DatabaseUtility.executeQuery(myDynamicQuery);
    }

    @And("user read all of the {string} column data")
    public void userReadAllOfTheColumnData(String column) {
        //        DBUtils.getResultset().next();
//
//        Object columnData = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData); //anonymoususer tablodaki 1. kullanici
//
//        DBUtils.getResultset().next();
//        Object columnData2 = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData2); //bakalim tablodaki 2. kullanici
//
//        DBUtils.getResultset().next();
//        Object columnData3 = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData3); //systema tablodaki 3. kullanici

//        while (DBUtils.getResultset().next()){
//            Object eachColumnData = DBUtils.getResultset().getObject(column);
//            System.out.println(eachColumnData);
//        }
    }

    @And("verify {string} table {string} column contains {string}")
    public void verifyTableColumnContains(String table, String column, String data) {
        List<Object> allColumnData = DatabaseUtility.getColumnData("Select * from c_test_item", "name");
        System.out.println(allColumnData);

        List<Object> expectedDta = new ArrayList<>();
        expectedDta.add(data);

        Assert.assertTrue(allColumnData.containsAll(expectedDta));
    }


}