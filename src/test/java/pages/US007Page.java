package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US007Page extends BasePage {

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
 public WebElement randevuTarihi;

 @FindBy(xpath = "//button[@type='submit']")
 public WebElement sendAppnmtButton;

 @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
 public WebElement toastifyBasarili;

 @FindBy(xpath = "//span[text()='Appointment date can not be past date!']")
 public WebElement pastDateText;



}
