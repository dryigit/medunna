package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US011Page extends BasePage{



    @FindBy(xpath = "//span[text()='ABOUT']")
    public WebElement aboutlink;
    @FindBy(xpath = "(//header//div/a)[6]")
    public WebElement makeAnApp;
    @FindBy (css = "input[name='firstName']")
    public WebElement appFirstname;
@FindBy(id = "register-submit")
    public WebElement appReqSubButton;
@FindBy(xpath = "//div[@class='Toastify']")
    public WebElement toasttify;
@FindBy(css = "a[aria-expanded='false']")
   public WebElement popup;
@FindBy(id = "login-item")
    public WebElement signin;
@FindBy(id="username")
    public WebElement signinUsername;
@FindBy(id = "password")
    public WebElement signinPasword;
@FindBy(css = "button[type='submit']")
public WebElement submit;
@FindBy (css = "#account-menu")
public WebElement doctoraccountbutton;
@FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement doctorMyappointments;


}
