package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.WeakHashMap;

public class US23_Page extends BasePage{

    @FindBy(id = "entity-menu")
    public WebElement myPagesButton;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatientButton;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement patientsSSNtextBox;

    @FindBy(xpath = "//*[text()='Show Appointments']")
    public WebElement showAppointmentsButton;

    @FindBy(xpath = "(//span[text()='Payment / Invoice Process'])[1]")
    public WebElement paymentInvoiceProcessButton;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement createInvoiceButton;

    @FindBy(id = "bill-description")
    public WebElement descriptionText;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[text()='800']")
    public WebElement examFeeText;

    @FindBy(xpath = "//*[text()='50']")
    public WebElement na111FeeText;

    @FindBy(xpath = "//*[text()='12']")
    public WebElement ureaFeeText;

    @FindBy(xpath = "//*[text()='15']")
    public WebElement creatinineFeeText;

    @FindBy(xpath = "(//*[text()='COMPLETED'])[1]")
    public WebElement statusTextCompleted;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement showInvoicePaymentButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement toastify;


    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    public WebElement appointmentButoon;

    @FindBy(id = "appoDate")
    public WebElement appoDATe;



}
