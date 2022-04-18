package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.WeakHashMap;

public class US23_Page {

    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesButton;

    @FindBy(xpath = "//*[text()='Search Patient']")
    public WebElement searchPatientButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement patientsSSNtextBox;

    @FindBy(xpath = "//*[text='Show Appointments']")
    public WebElement showAppointmentsButton;


}
