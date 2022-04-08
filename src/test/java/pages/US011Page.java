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
@FindBy(css = "#entity-menu")
    public WebElement mypages;
@FindBy(css = "#fromDate")
    public WebElement appFromDate;
    @FindBy(css = "#toDate")
    public WebElement apptoDate;

    // for doctor
@FindBy(css = "input[name='id']")
    public WebElement apppatientId;
    @FindBy(css = "input[name='startDate']")
    public WebElement appstartdate;
    @FindBy(css = "input[name='endDate']")
    public WebElement appenddate;
@FindBy(css = "#appointment-status")
    public WebElement appstatus;
    @FindBy(css = "#appointment-physician")
    public WebElement apppyschn;
@FindBy(name = "anamnesis")
    public WebElement anemsis;
    @FindBy(name = "treatment")
    public WebElement treatmnt;
    @FindBy(name = "treatment")
    public WebElement diagnos;
@FindBy(css = "#appointment-prescription")
    public WebElement prescrip;
@FindBy(css = "#appointment-description")
    public WebElement descript;
@FindBy(css = "#save-entity")
    public WebElement appsave;

}
