package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US002Page extends BasePage{

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernamrBox;

    @FindBy(xpath = "(//input[@id='email'])[1]")
    public WebElement emailBox;

    @FindBy(xpath = "(//input[@id='firstPassword'])[1]")
    public WebElement passwordBox;

    @FindBy(xpath = "(//input[@id='secondPassword'])[1]")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "(//span[contains(text(),'Register')])[2]")
    public WebElement registerButton2;

}
