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

    @FindBy (xpath = "//input[@id='rememberMe']")
    public WebElement us04rememberMe;

    @FindBy (xpath = "//span[normalize-space()='Did you forget your password?']")
    public WebElement us04forgetPassword;

    @FindBy (xpath = "//span[normalize-space()='Register a new account']")
    public WebElement us04registerNewAccount;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement us04signIn;

    @FindBy (xpath = "//span[normalize-space()='MY PAGES']")
    public WebElement us04myPages;

}
