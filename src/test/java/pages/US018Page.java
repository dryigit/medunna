package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US018Page extends BasePage{

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

    @FindBy(id = "entity-menu")
    public WebElement itemsTitlesMenu;

    @FindBy(xpath = "//a[@href='/physician']")
    public  WebElement physician;

    @FindBy(id = "jh-create-entity")
    public WebElement createNewPhysician;

    @FindBy(id = "useSSNSearch")
    public WebElement useSearch;

    @FindBy(id = "searchSSN")
    public WebElement searchSSN;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement searchUserButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement toastify;

    @FindBy(id = "physician-phone")
    public WebElement physicianPhone;

    @FindBy(id = "file_image")
    public WebElement profilePhoto;

    @FindBy(id = "physician-speciality")
    public WebElement speciality;

    @FindBy(id = "save-entity")
    public WebElement saveButton;


}
