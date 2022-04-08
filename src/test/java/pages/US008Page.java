package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US008Page extends BasePage{

    //tagName[@attributeIsmi=‘attributeValue']


    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement ikon;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement ikonSignIn;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSignInButton;

    @FindBy(xpath = "//*[@id=\"account-menu\"]/a/span")
    public WebElement ikinciIkon;

    @FindBy(xpath = "//span[text()='Password']")
    public WebElement passwordButton;

    @FindBy(xpath = "//input[@name='currentPassword']")
    public WebElement currentPassword;

    @FindBy(xpath = "//input[@name='newPassword']")
    public WebElement newPassword;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement newPasswordConfr;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[text()='The password and its confirmation do not match!']")
    public WebElement hataliSifreConfr;

    @FindBy(xpath = "//div[@style='pointer-events: none;']")
    public WebElement toastify;

    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    public WebElement hataliSignIn;

    @FindBy(xpath = "//ul[@id='strengthBar']/li[1]")
    public WebElement passwordStrengthFirst;

    //*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')][1]
    @FindBy(xpath = "//ul[@id='strengthBar']/li[2]")
    public WebElement passwordStrengthSecond;

    @FindBy(xpath = "//ul[@id='strengthBar']/li[3]")
    public WebElement passwordStrengthThird;

    @FindBy(xpath = "//ul[@id='strengthBar']/li[4]")
    public WebElement passwordStrengthFourth;

    @FindBy(xpath = "//ul[@id='strengthBar']/li[5]")
    public WebElement passwordStrengthFifth;
    //li[@style='background-color: rgb(221, 221, 221);'][4]

}
