package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US011_US003Page extends BasePage{
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
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement register;
    @FindBy(name = "ssn")
    public WebElement ssn;
    @FindBy(css = "#firstPassword")
    public WebElement password;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])")
    public WebElement passwordReqText;
    @FindBy(xpath = "(//a[@href='/search-patient'])[1]")
    public WebElement searchpat;
    @FindBy(xpath = "(//div[@class='table-responsive'])[2]")
    public  WebElement tableresp;
    @FindBy(xpath = "//a[@href='/patient-appointments/46766']")
    public WebElement showapp;
    @FindBy(css = "#entity-menu")
    public WebElement mypages;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement doctorMyappointments;

//  //a[@href='/appointment-update/5198 "1" ']    edit buttonu 51981,51982..
@FindBy(css = "#fromDate")
public WebElement appFromDate;
    @FindBy(css = "#toDate")
    public WebElement apptoDate;
    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement appedit;
    @FindBy(xpath = "#appointment-physician")
    public WebElement appPhysician;

    @FindBy(css = "li[style='background-color: rgb(255, 0, 0);']")
    public WebElement passwordFirstCond;

    @FindBy(css = "li[style='background-color: rgb(255, 153, 0);']")
    public WebElement passwordSecondCond;
    @FindBy(css = "li[style='background-color: rgb(153, 255, 0);']")
    public WebElement passwordThirdCond;
    @FindBy(css = "li[style='background-color: rgb(153, 255, 0);']")
    public WebElement passwordForthCond;
    @FindBy(css = "li[style='background-color: rgb(0, 255, 0);']")
    public WebElement passwordFifthCond;
    @FindBy(css = "#entity-menu")
    public WebElement itemsTitles;
    @FindBy(xpath = "//span[text()='Room']")
    public WebElement rooms;
    @FindBy(css = "#jh-create-entity")
    public WebElement createAnewRoom;
    @FindBy(css = "#room-roomNumber")
    public WebElement roomNumber;
@FindBy(css = "#room-roomType")
public WebElement roomType;
    @FindBy (xpath = "//div[@class='invalid-feedback']")
    public WebElement roomRequiremntText;
    @FindBy (css = "#room-status")
public WebElement roomstatus;
@FindBy(css = "#room-price")
    public WebElement roomprice;
@FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement roompricerequirement;
@FindBy(css = "#room-description")
    public WebElement roomDescription;
@FindBy(css = "#room-createdDate")
public WebElement roomDate;
@FindBy(css = "#save-entity")
    public WebElement roomSave;
@FindBy(xpath = "(//a[@class='page-link'])[9]")
    public WebElement lastRoomPage;
    @FindBy(xpath = "(//a[@class='page-link'])[1]")
    public WebElement firstRoomPage;
    @FindBy(xpath = "(//th[@class='hand'])[3]")
    public WebElement roomTypestatus;
    @FindBy(xpath = "(//tbody//td//div//a)[2]")
    public WebElement firstroomEditButton;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement roomTostify;
    @FindBy(css = "#save-entity")
    public WebElement roomUpdateSave;

}
