package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US25_Page extends BasePage {

    @FindBy(xpath="//*[@id=\"entity-menu\"]/a/span")
    public WebElement myPagesbuttonPatient;

    @FindBy(xpath="//*[@id=\"entity-menu\"]/div/a[2]/span")
    public WebElement makeAnAppointment;

    @FindBy(xpath=" //*[@id=\"firstName\"]")
    public WebElement firstName;

    @FindBy(xpath="//*[@id=\"lastName\"]")
    public WebElement lastName;

    @FindBy(xpath="//*[@id=\"ssn\"]")
    public WebElement SSN;

    @FindBy(xpath="//*[@id=\"email\"]")
    public WebElement email;

    @FindBy(xpath="//*[@id=\"phone\"]")
    public WebElement phone;

@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div/div/div[1]/span")
    public WebElement toastify;

    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement toasttify;

    @FindBy(xpath="//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement toastMessage;

@FindBy(xpath="//*[@id=\"register-submit\"]")
    public WebElement sendAppnmtButton;

@FindBy(xpath="(//a[@class='d-flex align-items-center nav-link'])[6]")

    public WebElement contactButton;

@FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement contactName;

@FindBy(xpath="//*[@id=\"email\"]")
    public WebElement contactEmail;

@FindBy(xpath = "//*[@id=\"subject\"]")
    public WebElement contactSubject;

@FindBy(xpath="//*[@id=\"message\"]")
    public WebElement contactMessage;

@FindBy(xpath="//*[@id=\"register-submit\"]")
    public WebElement contactSendButton;


@FindBy(xpath="//input[@id='twotabsearchtextbox']")
    public WebElement amazonText;



}
