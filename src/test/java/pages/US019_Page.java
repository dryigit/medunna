package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US019_Page extends BasePage {

    @FindBy(xpath = "//span[text()='Administration']")
    public WebElement administrationTitle;

    @FindBy(xpath = "//span[text()='User management']")
    public WebElement userManagementButton;

    @FindBy(xpath = "//span[text()='Create a new user']")
    public WebElement createNewUserButton;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement createLogin;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement createFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement createLastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement createEmail;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement createSSN;

    @FindBy(xpath = "//select[@name='langKey'][2]")
    public WebElement selectLanguage;

    @FindBy(xpath = "//select[@id='authorities']")
    public WebElement selectProfile;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;


    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement toastifyBasariliSave;

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemTitlesMenu;

    @FindBy(xpath = "//span[text()='Staff']")
    public WebElement staffButton;

    @FindBy(xpath = "//span[text()='Create a new Staff']")
    public WebElement createNewStaff;

    @FindBy(xpath = "//input[@name='useSSNSearch']")
    public WebElement ssnSearchCheckBox;

    @FindBy(xpath = "//input[@placeholder='000-00-0000']")
    public WebElement ssnSearchBox;

    @FindBy(xpath = "//button[text()='Search User']")
    public WebElement ssnSearchButton;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement staffPhone;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement staffAddress;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement staffDesc;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement staffCountryDropdown;

    @FindBy(xpath = "//select[@name='cstate.id']")
    public WebElement staffStateDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButtonCreateStaff;

    @FindBy(xpath ="//*[contains(text(),'View')]")
    public WebElement viewButton;


    @FindBy(xpath = "//*[text()='systema']")
    public WebElement userSystema;

    @FindBy(xpath = "//span[text()='ID']")
    public WebElement idButton;

    @FindBy(xpath = "//tbody/tr/td[03]")
    public WebElement newlyStaffSSN;

    @FindBy(xpath = "//span[text()='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Delete')]")
    public WebElement deleteConfirmButton;
    //body//div//button[2]

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement userMenuDropdown;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOutDropdown;

    @FindBy(xpath = "//*[contains(text(),'A User is deleted']")
    public WebElement toastifyDeleteConfirm;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement editEmail;

    @FindBy(xpath = "//*[contains(text(),'Edit')]")
    public WebElement editButton;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement editSaveButton;




}
