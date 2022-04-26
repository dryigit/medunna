package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentPage {

    public AppointmentPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='#appointment']")
    public WebElement makeanappointment;

    @FindBy(id = "firstName")
    public WebElement firstname;

    @FindBy(id = "lastName")
    public WebElement lastname;

    @FindBy(id = "ssn")
    public WebElement ssn;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "appoDate")
    public WebElement appoDate;

    @FindBy(id = "register-submit")
    public WebElement requestButton;

    @FindBy(className = "Toastify__toast-body")
    public  WebElement toastify;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement invalidFeedback;

}
