package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSettings extends BasePage{

    @FindBy(id = "account-menu")
    public WebElement userMenu;

    @FindBy(id= "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(id = "login-item")
    public  WebElement firstSignIn;

    @FindBy(xpath = "//a[@href='/account/settings']")
    public WebElement settings;

    @FindBy(className = "Toastify__toast-body")
    public  WebElement toastify;

    @FindBy(xpath = "//li[@class='dropdown nav-item']")
    public WebElement accountMenu;
}
