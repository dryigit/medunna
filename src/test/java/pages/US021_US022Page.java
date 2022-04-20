package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US021_US022Page {

    public US021_US022Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement signinsecenegi;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernametexbox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordtexbox;

    @FindBy(xpath = "//span[.='In Patient']")
    public WebElement inpatientbutonu;

    @FindBy(xpath = "//span[.='Search Patient']")
    public WebElement searchpatientbutonu;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement patientssntexbox;

    @FindBy(xpath = "//span[.='Show Appointments']")
    public WebElement showappaointmentsbutonu;

    @FindBy(xpath = "(//span[.='Edit'])[1]")
    public WebElement editbutonu;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startdatetexbox;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement enddatetimetexbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement savebutonu;

    @FindBy(xpath = "//*[@id='login-page']/div/form/div[3]/button[2]")
    public WebElement signinbutonu;

    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement mypagesbutonu;

    @FindBy(xpath = "//*[@id='appointment-status']")
    public WebElement statustexbox;

    @FindBy(xpath = "//*[@name='anamnesis']")
    public WebElement anamnesistexbox;

    @FindBy(xpath = "//*[@name='treatment']")
    public WebElement treatmenttexbox;

    @FindBy(xpath = "//*[@name='diagnosis']")
    public WebElement diagnosistexbox;

    @FindBy(xpath = "//*[@name='physician.id']")
    public WebElement physiciantexbox;

    @FindBy(xpath = "(//*[@class='btn btn-primary btn-sm'])[1]")
    public WebElement showtestbutonu;

    @FindBy(xpath ="(//*[@class='d-none d-md-inline'])[1]" )
    public WebElement viewresultsbutonu;

    @FindBy(xpath = "//span[.='ID']")
    public WebElement testID;

    @FindBy(xpath = "//span[.='Name']")
    public WebElement testName;

    @FindBy(xpath = "//span[.='Result']")
    public WebElement testResult;

    @FindBy(xpath = "//input[@id='c-test-result-result']")
    public WebElement resultedit;

}
