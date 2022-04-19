package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US24_Page extends BasePage{


    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement insanİkonButton;

    @FindBy(id = "login-item")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameButton;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement signInButton2;

    @FindBy(xpath = "//*[text()='MY PAGES(PATIENT)']")
    public WebElement myPagesButtonPatient;

    @FindBy(xpath = "(//*[text()='My Appointments'])[1]")
    public WebElement myAppointmentsButton;

    @FindBy(id = "fromDate")
    public WebElement fromDateButton;

    @FindBy(id = "toDate")
    public WebElement toDateButton;

    @FindBy(xpath = "(//*[text()='Show Tests'])[1]")
    public WebElement showTestsButton;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    public WebElement viewResultsButton;

    @FindBy(xpath = "//*[text()='70690']")
    public WebElement ıdText;

    @FindBy(xpath = "//*[text()='Na111']")
    public WebElement nameText;

    @FindBy(xpath = "//*[text()='66']")
    public WebElement defaultMinValueText;

    @FindBy(xpath = "//*[text()='100']")
    public WebElement defaultMaxValueText;

    @FindBy(xpath = "//*[text()='65692']")
    public WebElement testSonucText;

    @FindBy(xpath = "//*[text()='15/04/22 22:58']")
    public WebElement dateText;

   // @FindBy(xpath = "//*[text()='Na111']")
    //public WebElement nameText;

    @FindBy(xpath = "(//*[text()='Show Invoice'])[1]")
    public WebElement showInvoiceButton;

    @FindBy(xpath = "//*[text()='INVOICE']")
    public WebElement ınvoiceText;

}