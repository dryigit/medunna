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


}
