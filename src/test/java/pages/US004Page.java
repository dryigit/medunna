package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US004Page extends BasePage{
    @FindBy (xpath = "//li[@id='account-menu']")
    public WebElement us04AccountLink;

    @FindBy (xpath = "//span[normalize-space()='Sign in']")
    public WebElement us04SingIn;

    @FindBy (xpath = "//input[@id='username']")
    public WebElement us04username;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement us04password;

    @FindBy (xpath = "//input[@value='false']")
    public WebElement us04rememberMe;

    @FindBy (xpath = "//a[@href='/account/reset/request']")
    public WebElement us04forgetPassword;

    @FindBy (xpath = "//a[@href='/account/register']")
    public WebElement us04registerNewAccount;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement us04signIn;

    @FindBy (xpath = "//span[normalize-space()='MY PAGES']")
    public WebElement us04myPages;

    @FindBy (xpath = "//span[normalize-space()='Cancel']")
    public WebElement us04cancel;

}
