package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US020_Page {

    public US020_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement loginIkon;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement singInButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement singInEnter;

    @FindBy(xpath = "//span[text()='Administration']")
    public WebElement administrationButon;

    @FindBy(xpath = "//span[text()='User management']")
    public WebElement userManagementButon;

    @FindBy(xpath = "(//span[text()='View'])[1]")
    public WebElement ilkKayitlikisi;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginViev;

    @FindBy(xpath = "//span[text()='First name']")
    public WebElement firstnameViev;

    @FindBy(xpath = "//span[text()='Last name']")
    public WebElement lastnameViev;

    @FindBy(xpath = "//span[text()='Email']")
    public WebElement emailViev;

    @FindBy(xpath = "//span[text()='Profiles']")
    public WebElement profilesViev;

    //**tc002

    @FindBy(xpath = "//a[text()='»»']")
    public WebElement sonsayfaButonu;

    @FindBy(xpath = "//a[@href='/admin/user-management/testdoktor/edit']")
    public WebElement doktorEdit;

    @FindBy(xpath = "//input[@name='activated']")
    public WebElement activatedButonu;

    @FindBy(xpath = "//select[@id='authorities']")
    public WebElement profilDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButonu;

    @FindBy(xpath = "//a[@href='/admin/user-management/testpersonel/edit']")
    public WebElement personelEdit;

    @FindBy(xpath = "//a[@href='/admin/user-management/testhasta/edit']")
    public WebElement hastaEdit;

    //tc003----




    @FindBy(xpath = "(//span[text()='Delete'])[20]")
    public WebElement deletebutonu;


    @FindBy(xpath = "(//span[text()='Delete'])[21]")
    public WebElement delet2Buton;

    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement toastify;




}
