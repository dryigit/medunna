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
    public WebElement yatılıHastaEdit;


    @FindBy(xpath = "//input[@name='id']")
    public WebElement idAlanı;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startDateAlanı;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement endDateAlanı;

   @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionAlanı;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createdDateAlanı;

   @FindBy(xpath = "//select[@name='appointment.id']")
    public WebElement appointmentidAlanı;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement statusAlanı;

    @FindBy(xpath = "//select[@name='room.id']")
    public WebElement roomidAlanı;

    @FindBy(xpath = "//select[@name='patient.id']")
    public WebElement patientidAlanı;

    @FindBy(id ="save-entity")
   // @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButonu;

//    @FindBy(xpath = "//span[text()='Save']")
//    public WebElement saveButonu;























}
