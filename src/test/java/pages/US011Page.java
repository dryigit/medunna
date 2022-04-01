package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US011Page extends BasePage{



    @FindBy(xpath = "//span[text()='ABOUT']")
    public WebElement aboutlink;
    @FindBy(xpath = "(//header//div/a)[6]")
    public WebElement makeAnApp;
    @FindBy (css = "input[name='firstName']")
    public WebElement appFirstname;
@FindBy(id = "register-submit")
    public WebElement appReqSubButton;
}
