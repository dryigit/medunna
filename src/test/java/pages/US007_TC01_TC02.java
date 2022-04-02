package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US007_TC01_TC02 extends BasePage {

 //tagName[@attributeIsmi=‘attributeValue']


 @FindBy(xpath = "//input[@name='firstName']")
 public WebElement firstName;

 @FindBy(xpath = "//input[@name='lastName']")
 public WebElement lastName;

 @FindBy(xpath = "//input[@name='ssn']")
 public WebElement SSN;

 @FindBy(xpath = "//input[@name='email']")
 public WebElement email;

 @FindBy(xpath = "//input[@name='phone']")
 public WebElement phone;

 @FindBy(xpath = "//input[@name='appoDate']")
 public WebElement appnmtDate;

 @FindBy(xpath = "//span[text()='Send an Appointment Request']")
 public WebElement sendAppnmtButton;


}
