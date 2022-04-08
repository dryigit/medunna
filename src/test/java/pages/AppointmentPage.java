package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentPage extends BasePage {
    @FindBy(className = "appointment-btn scrollto")
    public WebElement makeanappointment;

    @FindBy(id = "firstName")
    public WebElement firstname;

    @FindBy(id = "lastname")
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






}
