package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.List;

public class US012Page extends BasePage {

    @FindBy(xpath = " //body/div[@id='root']/div[1]/div[1]/div[2]/nav[1]/div[1]/ul[1]/li[7]/a[1]/*[1]")
    public WebElement ButtonTikla;

    @FindBy(xpath = " //span[contains(text(),'Sign in')]")
    public WebElement SingInButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement UsernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement PasswordBox;

    @FindBy(xpath = " //body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[2]/span[1]")
    public WebElement SingInGirisButton;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement MyPagesButton;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement MyAppointmentsButton;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement EditButton;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement RequestATestButton;

    @FindBy(xpath = "//input[@id='1402']")
    public WebElement UreaElement;

    @FindBy(xpath = "//input[@id='1403']")
    public WebElement CreatinineElement;

    @FindBy(xpath = "//input[@id='1404']")
    public WebElement SodiumElement;

    @FindBy(xpath = "//input[@id='1405']")
    public WebElement PotassiumElement;

    @FindBy(xpath = "//input[@id='1408']")
    public WebElement HemoglobinElement;

    @FindBy(xpath = "//input[@id='1406']")
    public WebElement TotalproteinElement;


    @FindBy(xpath = "//input[@id='1407']")
    public WebElement AlbuminElement;

    @FindBy(xpath = "//input[@name='1401']")
    public WebElement GlucoseElement;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement TestSaveButton;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement ShowTestResults;

    @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[6]")
    public WebElement TestsonuclarGoster;

    @FindBy(xpath = "//span[text()='Test Results']")
    public WebElement TestResultElement;


}
