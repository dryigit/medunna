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

    @FindBy(xpath = "//*[text()='78680']")
    public WebElement ıdText;

    @FindBy(xpath = "//*[text()='Urea']")
    public WebElement nameText;

    @FindBy(xpath = "//*[text()='17']")
    public WebElement defaultMinValueText;

    @FindBy(xpath = "//*[text()='49']")
    public WebElement defaultMaxValueText;

    @FindBy(xpath = "//*[text()='75235']")
    public WebElement testSonucText;

    @FindBy(xpath = "//*[text()='21/04/22 02:13']")
    public WebElement dateText;

   // @FindBy(xpath = "//*[text()='Na111']")
    //public WebElement nameText;

    @FindBy(xpath = "(//a[@class='btn btn-warning btn-sm'])[1]")
    public WebElement showInvoiceButton;

    @FindBy(xpath = "//*[text()='INVOICE']")
    public WebElement invoiceText;

}
