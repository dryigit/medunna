package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US011Page extends BasePage{



    @FindBy(xpath = "//span[text()='ABOUT']")
    public WebElement aboutlink;
}
