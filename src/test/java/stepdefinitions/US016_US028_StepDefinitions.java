package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US011_US003Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US016_US028_StepDefinitions {
    US011_US003Page page=new US011_US003Page();
    Faker faker=new Faker();
    @And("yep give username and pasword to sign in to login admin")
    public void yepGiveUsernameAndPaswordToSignInToLoginAdmin() {
        page.signinUsername.sendKeys(ConfigReader.getProperty("MedunnaAdminUsername"));
        page.signinPasword.sendKeys(ConfigReader.getProperty("MedunnaAdminPassword"));
        page.submit.click();

    }

    @Given("yep clicks to itemtitle")
    public void yepClicksToItemtitle() {
        page.itemsTitles.click();
    }

    @Then("yep clicks to rooms")
    public void yepClicksToRooms() {
       page.rooms.click();
    }


    @And("yep creates a new room having {string} number")
    public void yepCreatesANewRoomHavingNumber(String roomNum) {
       int num=faker.random().nextInt(9800,200000);
        System.out.println("random num faker"+num);
       int num2=faker.random().nextInt(9,200);
        System.out.println("random number2 faker"+num2);
        int num3=faker.random().nextInt(9,200);
        System.out.println("random number3 faker"+num3);
        int top=num+num2+num3;
        System.out.println("random top faker"+top);
        roomNum= String.valueOf(top);
        System.out.println("room num String value"+roomNum);


        page.createAnewRoom.click();
        page.roomNumber.click();
        Select select=new Select(page.roomType);
        List<WebElement> typelist=select.getOptions();

        for (int i = 0; i <typelist.size() ; i++) {
            select.selectByIndex(i);
            Assert.assertTrue(typelist.get(i).isSelected());
        }
        Assert.assertTrue(page.roomRequiremntText.getText().toString().contains("This field is required"));
page.roomNumber.sendKeys(roomNum);
        boolean status= Boolean.parseBoolean(page.roomstatus.getAttribute("value"));
        System.out.println(status);
        Assert.assertEquals(status,false);
        page.roomstatus.click();
        boolean statusSelected=Boolean.parseBoolean(page.roomstatus.getAttribute("value"));
        System.out.println(statusSelected);
        Assert.assertEquals(statusSelected,true);
    }

    @And("yep verifies room price requirement and gives {string} room price")
    public void yepVerifiesRoomPriceRequirementAndGivesRoomPrice(String roomPrice) {

        page.roomprice.click();
page.roomDescription.click();
        System.out.println(page.roompricerequirement.getText().toString());
Assert.assertTrue(page.roompricerequirement.getText().toString().contains("This field is required"));
        page.roomprice.sendKeys(roomPrice);
    }

    @Then("yep controls description cen be provided optionaly")
    public void yepControlsDescriptionCenBeProvidedOptionaly() {
        System.out.println("-bu kisim description-"+page.roomDescription.getText().toString()+"-bu kisim description");
        Assert.assertTrue(page.roomDescription.getText().toString().equals(""));
//JSUtils.scrollDownByJS();
        //  JSUtils.scrollIntoVIewJS(page.roomprice);
        Actions actions=new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //actions.sendKeys(Keys.PAGE_UP).perform();
    }



    @And("yep verifies created date  and cannot be typed earlier")
    public void yepVerifiesCreatedDateAndCannotBeTypedEarlier() {

        String actualDate= page.roomDate.getAttribute("value").toString();
        System.out.println(actualDate);//2022-04-15T00:00
String verifyYear=actualDate.substring(0,4);
        System.out.println(verifyYear);
        Assert.assertTrue(verifyYear.length()==4);
        String verifyMonth=actualDate.substring(5,7);
        System.out.println(verifyMonth);
        Assert.assertTrue(verifyMonth.length()==2);
        String verifyDay=actualDate.substring(8,10);
        System.out.println(verifyDay);
        Assert.assertTrue(verifyDay.length()==2);

       JSUtils.scrollIntoVIewJS(page.roomDate);
    page.roomDate.sendKeys("4/14/2022");
        String createdDate= page.roomDate.getAttribute("value").toString();
    Assert.assertFalse(actualDate.equals(createdDate));
    ReusableMethods.waitForVisibility(page.roomSave,5);
page.roomSave.click();
JSUtils.scrollIntoVIewJS(page.lastRoomPage);
        ReusableMethods.waitForVisibility(page.lastRoomPage,10);

        JSUtils.clickElementByJS(page.lastRoomPage);
//page.lastRoomPage.click();



      //  Driver.getDriver().findElement(By.xpath("//span[text()='"+""+"']"));
    //  //span[contains(text(),'26/03/22')]
    }


    @And("yep sees number {int} and number {int} rooms at same  type")
    public void yepSeesNumberAndNumberRoomsAtSameType(int first, int second) throws InterruptedException {
        page.roomTypestatus.click();
        WebElement firstroomtype=Driver.getDriver().findElement(By.xpath("(//tbody//td//span)["+first+"]"));
       if (second==2){
           second=9;
       }
        WebElement secondroomtype=Driver.getDriver().findElement(By.xpath("(//tbody//td//span)["+second+"]"));
        Thread.sleep(2000);
        ReusableMethods.waitForVisibility(firstroomtype,10);
        ReusableMethods.waitForVisibility(secondroomtype,10);

//WebElement firstroomtype=Driver.getDriver().findElement(By.xpath("(//tbody//td//span)["+first+"]"));
       // WebElement secondroomtype=Driver.getDriver().findElement(By.xpath("(//tbody//td//span)["+second+"]"));
        System.out.println(firstroomtype.getText().toString());
        System.out.println(secondroomtype.getText().toString());
        ReusableMethods.waitForVisibility(firstroomtype,5);

        Assert.assertTrue(firstroomtype.getText().toString().equals(secondroomtype.getText().toString()));
page.firstroomEditButton.click();
page.roomprice.clear();
page.roomprice.sendKeys("3000");
ReusableMethods.waitForVisibility(page.roomUpdateSave,5);
JSUtils.clickElementByJS(page.roomUpdateSave);
//page.roomUpdateSave.click();
ReusableMethods.waitForVisibility(page.roomTostify,5);
        System.out.println("tostify message"+page.roomTostify.getText().toString());
//JSUtils.scrollIntoVIewJS(page.firstRoomPage);
    }

    @Given("yepadmin goes to {string} website")
    public void yepadminGoesToWebsite(String website) {
        Driver.getDriver().get(ConfigReader.getProperty(website));
    }

    @And("yepadmin click to popup")
    public void yepadminClickToPopup() {
        page.popup.click();
    }

    @Then("yepadmin click to logIn")
    public void yepadminClickToLogIn() {
        page.signin.click();
    }

    @And("yepadmin give username and pasword to sign in to login admin")
    public void yepadminGiveUsernameAndPaswordToSignInToLoginAdmin() {
        page.signinUsername.sendKeys(ConfigReader.getProperty("MedunnaAdminUsername"));
        page.signinPasword.sendKeys(ConfigReader.getProperty("MedunnaAdminPassword"));
        page.submit.click();

    }


}
