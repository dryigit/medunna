package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.List;

public class US015Page extends  BasePage {

    @FindBy(xpath = " //body/div[@id='root']/div[1]/div[1]/div[2]/nav[1]/div[1]/ul[1]/li[7]/a[1]/*[1]")
    public WebElement ButtonTikla;

    @FindBy(xpath = " //span[contains(text(),'Sign in')]")
    public WebElement SinginButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement UsernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement PasswordBox;

    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[2]/span[1]")
    public WebElement SinginGirisButton;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesElement;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatientElement;

    @FindBy(xpath = "//span[text()='Patients']")
    public WebElement patientsElement;

//=======================TC001==============================
    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement ItemsTitlesElement;

    @FindBy(xpath = "//span[text()='Patient']")
    public WebElement PatientElement;

    @FindBy(xpath = "//span[text()='Create a new Patient']")
    public WebElement CreateNewPatient;

    @FindBy(xpath = "//input[@id='patient-firstName']")
    public WebElement patientFirstName;

    @FindBy(xpath = "//select[@id='patient-gender']")
    public WebElement patientGender;

    @FindBy(xpath = "//select[@id='patient-bloodGroup']")
    public WebElement patientBloodGroup;

    @FindBy(xpath = "//input[@id='patient-adress']")
    public WebElement patientAdress;

    @FindBy(xpath = "//select[@id='patient-user']")
    public WebElement patientUser;

    @FindBy(xpath = "//select[@id='patient-country']")
    public WebElement patientCountry;

    @FindBy(xpath = "//select[@id='patient-cstate']")
    public WebElement patientCstate;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement patientSave;

    //=======================TC002==============================

    @FindBy(xpath = "//span[text()='Patients']")
    public WebElement staffHastaKayitElement;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement sSnElemenet;

    @FindBy(xpath = "(//tbody//tr//td)[1]")
    public WebElement idElement;
    @FindBy(xpath = "(//tbody//tr//td)[2]")
    public WebElement ssn1Element;
    @FindBy(xpath = "(//tbody//tr//td)[3]")
    public WebElement firstNameElement;
    @FindBy(xpath = "(//tbody//tr//td)[4]")
    public WebElement lastNameElement;
    @FindBy(xpath = "(//tbody//tr//td)[5]")
    public WebElement birthDateElement;
    @FindBy(xpath = "(//tbody//tr//td)[6]")
    public WebElement phoneElement;
    @FindBy(xpath = "(//tbody//tr//td)[7]")
    public WebElement emailElement;
    @FindBy(xpath = "(//tbody//tr//td)[8]")
    public WebElement genderElement;
    @FindBy(xpath = "(//tbody//tr//td)[9]")
    public WebElement blokGroupElement;
    @FindBy(xpath = "(//tbody//tr//td)[10]")
    public WebElement adressElement;
    @FindBy(xpath = "(//tbody//tr//td)[11]")
    public WebElement DescriptionElement;
    @FindBy(xpath = "(//tbody//tr//td)[12]")
    public WebElement CreatedDateElement;
    @FindBy(xpath = "(//tbody//tr//td)[13]")
    public WebElement userElement;
    @FindBy(xpath = "(//tbody//tr//td)[14]")
    public WebElement countryElement;


    //==================TC 003===============================
    @FindBy(xpath = "(//span[text()='Show Appointments'])[1]")
    public WebElement showAppointmentsElement;

    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    public WebElement editButton;

    @FindBy(xpath = "//select[@id='appointment-physician']")
    public WebElement physicianElement;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButton;

    //=======================TC 004=================================
    @FindBy(xpath = "(//span[text()='Edit'])[2]")
    public WebElement patientEditElement;


    //=========================TC 005================================

    @FindBy(xpath = "(//span[text()='Delete'])[1]")
    public WebElement patinetDeleteElement;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-patient']//span[contains(text(),'Delete')]")
    public WebElement patientDeleteOnayElement;


    //============================TC 006==================================
    @FindBy(xpath = "//span[text()='Messages']")
    public WebElement adminMessagesElemet;

    @FindBy(xpath = "(//tbody//tr//td)[2]")
    public WebElement mesajFirstNameElement;

    @FindBy(xpath = "(//tbody//tr//td)[3]")
    public WebElement mesajEmailElement;

    //=====================TC 007========================================

    @FindBy(xpath = "//span[text()='Create a new Message']")
    public WebElement CreateanewMessageElement;

    @FindBy(xpath = "//input[@id='c-message-name']")
    public WebElement yeniMesajNameElement;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement mesajSaveElemet;

    @FindBy(xpath = "(//span[text()='Delete'])[2]")
    public WebElement mesajDeleteElement;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-cMessage']//*[name()='svg']")
    public WebElement mesajDeletOnaylaElement;



}
