package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Us013_Page {

    public Us013_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement loginIkon;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement singInButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement singInEnter;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesButonu;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myAppoinButonu;

    @FindBy(xpath = "//a[@href='/appointment-update/52927']")
    public WebElement editButonu;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement testSonuclariniGoster;

    @FindBy(xpath = "//a[@href='/testresult/test/49089']")
    public WebElement viewResults;

    @FindBy(xpath = "//span[text()='ID']")
    public WebElement idBaslik;

    @FindBy(xpath = "//span[text()='Name']")
    public WebElement nameBaslik;

    @FindBy(xpath = "//span[text()='Default Min. Value']")
    public WebElement defaultMinBaslik;

    @FindBy(xpath = "//span[text()='Default Max. Value']")
    public WebElement defaultMaxBaslik;

    @FindBy(xpath = "//span[text()='Test']")
    public WebElement testBaslik;

    @FindBy(xpath = "//span[text()='Date']")
    public WebElement tarihBaslik;


    //*********************************US13--TC002

    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement anamnesisAlani;

    @FindBy(xpath = "//textarea[@name='treatment']")
    public WebElement tedaviAlani;

    @FindBy(xpath = "//textarea[@name='diagnosis']")
    public WebElement teshisAlani;

    @FindBy(xpath = "//textarea[@name='prescription']")
    public WebElement receteAlani;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement taniAlani;

    @FindBy(xpath = "//button[@class='btn btn-warning btn-sm']")
    public WebElement requestImpatientButonu;


    //Toast Container: (xpath = "//*[contains(text(),'Registration Saved')]"

    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement toastify;

//    @FindBy (xpath = "(//div[@role='alert'])/span/strong")
//    public WebElement toastify;

    @FindBy(xpath = "//span[text()='My Inpatients']")
    public WebElement yatiliHastaButonu;








}
