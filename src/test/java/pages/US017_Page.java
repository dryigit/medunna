package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class US017_Page extends BasePage{
    @FindBy(id = "account-menu")
    public WebElement insanIkonu;

    @FindBy(id = "login-item")
    public WebElement signinButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement signinUsernameTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement signinPasswordTextBox;

    @FindBy(xpath = "(//span[.='Sign in'])[3]")
    public WebElement signinSigninButton;

    public void girisyap(String username, String password) {
        insanIkonu.click();
        signinButton.click();
        signinUsernameTextBox.sendKeys(username);
        signinPasswordTextBox.sendKeys(password);
        signinSigninButton.click();
    }

    @FindBy(xpath = "//span[.='Items&Titles']")
    public WebElement itemsTitlesButton;

    @FindBy(xpath = "//span[.='Test Item']")
    public WebElement testItemButton;

    @FindBy(xpath = "//span[.='Create a new Test Item']")
    public  WebElement createANewTestItemButton;

    @FindBy(xpath = "//input[@id='c-test-item-name']")
    public WebElement nameTextBox;

   // @FindBy(xpath = "//div[.='A new Test Item is created with identifier 72755']")
   // public WebElement basariliItemOlusturulduText;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement basariliItemOlusturulduText;

    @FindBy(xpath = "//input[@id='c-test-item-description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//input[@id='c-test-item-price']")
    public WebElement priceBox;

    @FindBy(xpath = "//input[@id='c-test-item-defaultValMin']")
    public WebElement minValueBox;

    @FindBy(xpath = "//input[@id='c-test-item-defaultValMax']")
    public WebElement maxValueBox;

    @FindBy(xpath = "//input[@id='c-test-item-createdDate']")
    public WebElement createdDateBox;

    @FindBy(xpath = "//span[.='Test Items']")
    public WebElement testItemsText;

    @FindBy(xpath = "//span[.='Delete']")
    public List<WebElement> deleteButtonList;

    @FindBy(xpath = "//span[.='Created Date']")
    public WebElement createdDateButton;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public  WebElement itemDeletedText;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']") //span[.='Edit']
    public List<WebElement>  editButtonList;

    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement toasttify;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement basariliEditText;
}
