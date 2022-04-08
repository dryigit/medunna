package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US001Page {
    public US001Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath = "(//span[contains(text(),'Register')])[1]")
    public WebElement registerButton;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement ssnAllert;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//div[normalize-space()='Your FirstName is required.']")
    public WebElement firstNameAllertText;

    @FindBy (xpath = "//input[@id='lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//div[normalize-space()='Your FirstName is required.']")
    public WebElement lastNameAllertText;

}
