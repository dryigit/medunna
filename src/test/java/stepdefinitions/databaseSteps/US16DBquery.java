package stepdefinitions.databaseSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.Assert;

import pojos.Country;
import pojos.Room;
import pojos.RoomPost;
import pojos.TestItem;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US16DBquery {
TestItem testItem;
    Response response;
RoomPost roomPost=new RoomPost();
Faker faker=new Faker();
    Map<String, Object> actuelData;
Room room=new Room();
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





    @Then("yep admin verfies patient id {string}")
    public void yepAdminVerfiesPatientId(String id) {

      String query="Select * from jhi_user where id ="+id+"";
        List<List<Object>> allColumnUser2= DBUtils.getQueryResultList(query);
        System.out.println(allColumnUser2.toString());

        List<Object> expected=new ArrayList<>();

        Assert.assertTrue(allColumnUser2.toString().contains(id));
    }
// validate all rooms with api creating reading updating and deleting
 // room can be deleted by admin
    @Given("yep arranges pathparams to reach api for rooms")
    public void yepArrangesPathparamsToReachApiForRooms() {
        spec.pathParams("first","/api","second","/rooms","id","/79449");
        // get , put , islemleri icinde ayni
// https://app.swaggerhub.com/apis/MuratTANC/medunna-api/0.0.1
        /*
        User can create a new country
        User should create related states or cities based on the country
        User should validate them with API
        User should create update existing countries using API
        User should validate them with DB
        User can delete countries
         */
        String token = generateToken();
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).when().get("{first}{second}{id}");
response.prettyPrint();
        System.out.println("token :"+token);





/*
room:  id  :  ssn                 patient id leri                 abuziddin id 9595
      79449-123123                 77591 ve 77592                    tum roller
      81701-123124
      81702-123125
      81703-......
      ....7-123110

      country id=77112,77113,77114,77116,77120,77121,77122,77123,77124,77143,77144,77145,77146,77148,77149,77150

 */


    }

    @And("yep creates new room with api")
    public void yepCreatesNewRoomWithApi() {
        spec.pathParams("first","/api","second","/rooms");
        String token = generateToken();
        System.out.println("token"+token);
        System.out.println("*******CREATE/POST********");
        int roomNumber=15000;
        for (int i = 0; i <4 ; i++) {
            int firstnumber=faker.random().nextInt(1000,2000);
            roomNumber+=firstnumber;
        }
        System.out.println("roomNumber :"+roomNumber);

        String description="King residence";
        int price=5000;
        String roomType="TWIN";
        boolean status=true;

        roomPost.setPrice(price);
        roomPost.setDescription(description);
        roomPost.setRoomType(roomType);
        roomPost.setStatus(status);
        roomPost.setRoomNumber(roomNumber);

        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).body(roomPost).when().post("{first}{second}");
        response.prettyPrint();
        actuelData=response.as(HashMap.class);

        System.out.println("room id :"+actuelData.get("id").toString());
        System.out.println("*******PUT/UPDATE********");
        int id= (int) actuelData.get("id");

        price=6000;
room.setPrice(price);
room.setRoomNumber(roomNumber);
room.setRoomType(roomType);
room.setId(id);
room.setDescription(description);
room.setStatus(status);
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).body(room).when().put("{first}{second}");
        response.prettyPrint();
        HashMap<String,String> putMap=new HashMap<>();
        putMap=response.as(HashMap.class);
       response.then().assertThat().body("price", Matchers.equalTo(6000));
        System.out.println("*******DELETE********");
        spec.pathParams("first","/api","second","/rooms","third",id);
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).when().delete("{first}{second}/{third}");
        response.prettyPrint();
        response.then().assertThat().statusCode(204);
        System.out.println("*******CONTROL********");
        spec.pathParams("first","/api","second","/rooms","third",id);
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).when().get("{first}{second}/{third}");
        response.prettyPrint();
        response.then().assertThat().statusCode(404);

    }

    @Given("yep admin create new country {string} and State {string}")
    public void yepAdminCreateNewCountryAndState(String country, String state) {
        // country creation - post
        spec.pathParams("first","/api","second","/countries");
        Country countrypojo=new Country();
        countrypojo.setName(country);
        String token=generateToken();
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).body(countrypojo).when().post("{first}{second}");
        response.prettyPrint();
response.then().assertThat().body("name",Matchers.equalTo(country));
HashMap<String,Object> actuel=response.as(HashMap.class);
int id= (int) actuel.get("id");
        System.out.println("new country id  :"+id);
        Assert.assertEquals(actuel.get("name"),country);

        // state update
        String nameupdated="updated";
        country+=nameupdated;

JSONObject putCountry=new JSONObject();
        putCountry.put("id",id);
        putCountry.put("name",country);

        System.out.println(putCountry.toString());

        spec.pathParams("first","/api","second","/countries");
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).body(putCountry.toString()).when().put("{first}{second}");
        response.prettyPrint();
        HashMap<String,Object> updatedCountry=response.as(HashMap.class);
        System.out.println("new updated country Name"+updatedCountry.get("name"));
Assert.assertEquals(updatedCountry.get("name").toString(),country);
        // state creation post
        JSONObject stateMap=new JSONObject();
        stateMap.put("name",country);
        stateMap.put("id",id);
        JSONObject countryMap=new JSONObject();
        countryMap.put("name",state);
        countryMap.put("country",stateMap);


        spec.pathParams("first","/api","second","/c-states");
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).body(countryMap.toString()).when().post("{first}{second}");
        response.prettyPrint();
        //System.out.println(countryMap.toString());
        HashMap<String,Object> actuelState=response.as(HashMap.class);
        Assert.assertEquals(countryMap.get("name").toString(),actuelState.get("name").toString());
        System.out.println("new created state id :"+actuelState.get("id"));
int createdStateID= (int) actuelState.get("id");

        // state update - put
String updatedState="updated";
state+=updatedState;
        countryMap.put("name",state);
countryMap.put("id",createdStateID);
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).body(countryMap.toString()).when().put("{first}{second}");
        response.prettyPrint();
        System.out.println(countryMap.toString());
        HashMap<String,Object> actuelStateName=response.as(HashMap.class);
       Assert.assertEquals(actuelStateName.get("name").toString(),countryMap.get("name").toString());

// delete state

        spec.pathParams("first","/api","second","/c-states","third",createdStateID);
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).when().delete("{first}{second}/{third}");
        response.prettyPrint();
        response.then().assertThat().statusCode(204);
        System.out.println("state  deleted status code 204 ");
        // delete country
        spec.pathParams("first","/api","second","/countries","third",id);
        response = given().headers(
                "Authorization",
                "Bearer " + token).spec(spec).contentType(ContentType.JSON).when().delete("{first}{second}/{third}");
        response.prettyPrint();
       response.then().statusCode(204);
        System.out.println("country deleted status code 204 ");

    }

    @Given("yep admin connects DB")
    public void yepAdminConnectsDB() {
        DBUtils.createConnection();
    }

    @And("yep admin send query")
    public void yepAdminSendQuery() {
        String query="select * from c_state where id=43533";
        DBUtils.executeQuery(query);
        List<List<Object>> queryResult=DBUtils.getQueryResultList(query);
        System.out.println(queryResult.toString());
Assert.assertTrue(queryResult.toString().contains("legality"));

    }

}
