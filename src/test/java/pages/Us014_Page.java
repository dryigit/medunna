package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Us014_Page {
    public Us014_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@href='/in-patient/53354/edit']")
    public WebElement yatiliHastaEdit;


    @FindBy(xpath = "//input[@name='id']")
    public WebElement idAlani;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startDateAlani;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement endDateAlani;

   @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionAlani;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createdDateAlani;

   @FindBy(xpath = "//select[@name='appointment.id']")
    public WebElement appointmentidAlani;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement statusAlani;

    @FindBy(xpath = "//select[@name='room.id']")
    public WebElement roomidAlani;

    @FindBy(xpath = "//select[@name='patient.id']")
    public WebElement patientidAlani;

    @FindBy(id ="save-entity")
   // @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButonu;

//    @FindBy(xpath = "//span[text()='Save']")
//    public WebElement saveButonu;























}
