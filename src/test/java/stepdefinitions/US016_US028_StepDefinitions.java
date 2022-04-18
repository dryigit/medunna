package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US011_US003Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;

import java.util.ArrayList;
import java.util.List;

public class US016_US028_StepDefinitions {
    US011_US003Page page=new US011_US003Page();
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

    }


}
