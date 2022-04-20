package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US9Page {

    public US9Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement EntryButton;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement singInButton;

    @FindBy(xpath="//input[@name='username']")
    public WebElement usernameButton;

    @FindBy(xpath="//input[@name='password']")
    public WebElement passwordButton;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement singInButton2;

    @FindBy(xpath="(//span[text()='MY PAGES'])")
    public WebElement MyPagesButtonStaff;

    @FindBy(xpath="//span[text()='In Patient']")
    public WebElement InpatientButton;

    @FindBy(xpath="//a[@href='/patient-detail/2251']")
    public WebElement InpatientInformation;

    @FindBy(xpath="//a[@href='/patient-update/2251']")
    public WebElement patientEdit;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/a[2]")
    public WebElement editButonu;

    @FindBy(xpath="//input[@name='id']")
    public WebElement firstNameButton;

    @FindBy(xpath="//input[@name='lastName']")
    public WebElement lastNameButton;

    @FindBy(xpath="//input[@name='email']")
    public WebElement emailNameButton;

    @FindBy(xpath= "//*[@id=\"save-entity\"]")
    public WebElement saveButton;

    @FindBy(xpath="(//a[@class='dropdown-item'])[1]")
    public WebElement searchPatientButton;

    @FindBy(xpath="//input[@name='ssn']")
    public WebElement searchSSNbutton;

    @FindBy(xpath="(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewButton;

    @FindBy (tagName="h2")
    public WebElement InPatientsText;

    @FindBy(xpath="//input[@name='firstName']")
    public WebElement firstNameButton2;

    @FindBy(xpath="//input[@name='lastName']")
    public WebElement lastNameButton2;

    @FindBy(xpath="//input[@name='email']")
    public WebElement emailButton2;

    @FindBy(xpath="(//*[@id=\"entity-menu\"]/a)[1]")
    public WebElement doctorMyPages;

    @FindBy(xpath="//*[@id=\"entity-menu\"]/div/a[1]")
    public WebElement myAppointments;

    @FindBy (tagName="h2")
    public WebElement appointmentsText;


    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr[1]/td[12]/a")
    public WebElement firstPatient;

@FindBy(xpath="//*[@id=\"app-view-container\"]/div/div/div/div/a[2]")
    public WebElement editButonuDoctor;

@FindBy (xpath="//*[@id=\"ssn\"]/span")
    public WebElement doctorSSN;

    @FindBy (xpath="//*[@id=\"firstName\"]/span")
    public WebElement doctorFirstName;

    @FindBy (xpath="//*[@id=\"lastName\"]/span")
    public WebElement doctorLastName;


    @FindBy(xpath="//*[@id=\"system\"]/td[11]/div/a[3]")
    public WebElement adminDelete;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[1]/div[2]/input")
    public WebElement ssnStaff;



}
