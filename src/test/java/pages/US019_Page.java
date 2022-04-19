package pages;

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
    //button[@type='submit']

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement toastifyBasariliSave;




}
