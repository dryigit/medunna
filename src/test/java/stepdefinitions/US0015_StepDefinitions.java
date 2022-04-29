package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US015Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US0015_StepDefinitions {

    US015Page us015Page=new US015Page();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();

    //==================TC001==================================
    //  TC001 Yeni hastalar yalnızca yönetici tarafından oluşturulabilir

    @When("Yonetici Medunna Sayfasina gider")
    public void yonetici_medunna_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }
    @When("Sing inTiklar")
    public void sing_in_tiklar() {
        us015Page.ButtonTikla.click();
        us015Page.SinginButton.click();

    }
    @When("Your Username Girer")
    public void your_username_girer() {us015Page.UsernameBox.sendKeys("hadiarici");
    }
    @When("Your Password Girer")
    public void your_password_girer() { us015Page.PasswordBox.sendKeys("12361236Ha.");
    }
    @When("Sing in Giris Yapar")
    public void sing_in_giris_yapar() {us015Page.SinginGirisButton.click();
    }


    @And("haitems&Titles Tiklar")
    public void haitemsTitlesTiklar() {
        us015Page.ItemsTitlesElement.click();
    }
    @Given("Patients Tiklar")
    public void patients_tiklar() {us015Page.PatientElement.click();
    }
    @Given("Create or edit a Patient Tiklar")
    public void create_or_edit_a_patient_tiklar() {us015Page.CreateNewPatient.click();
    }
    @Given("Create or edit a Patient Tiklar Hasta icin Gerekli Bilgiler girer")
    public void create_or_edit_a_patient_tiklar_hasta_icin_gerekli_bilgiler_girer() {

        actions.click(us015Page.patientFirstName)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys("23.05.2022"+ Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys("543-325-2525"+Keys.TAB).perform();

        Select select=new Select(us015Page.patientGender);
        select.selectByVisibleText("MALE");

        Select select1=new Select(us015Page.patientBloodGroup);
        select1.selectByVisibleText("AB+");

        actions.click(us015Page.patientAdress).sendKeys("namık kemal Mah."+Keys.TAB)
                .sendKeys("bagirsak hastalikalri"+ Keys.TAB).perform();

        Select select2 = new Select(us015Page.patientUser);
        select2.selectByVisibleText("bakalim");

        Select select3 = new Select(us015Page.patientCountry);
        select3.selectByVisibleText("Türkiye");

        Select select4 = new Select(us015Page.patientCstate);
        select4.selectByVisibleText("Istanbul");
    }
    @Given("Save Buttonuna Tiklar")
    public void save_buttonuna_tiklar() { us015Page.patientSave.click();

    }
//============================TC 002 ================================

    @Given("hasta bilgilerini gorebilir")
    public void hasta_bilgilerini_gorebilir() {
        System.out.println("id==>"+us015Page.idElement.getText()+"\n"
                +"SSN==>"+ us015Page.ssn1Element.getText()+"\n"
                +"First Name==>"+us015Page.firstNameElement.getText()+"\n"
                +"Last Name==>"+us015Page.lastNameElement.getText()+"\n"
                +"Birth Date==>"+us015Page.birthDateElement.getText()+"\n"
                +"Phone==>"+us015Page.phoneElement.getText()+"\n"
                +"Email==>"+us015Page.emailElement.getText()+"\n"
                +"Gender==>"+us015Page.genderElement.getText()+"\n"
                +"Blood Group==>"+us015Page.blokGroupElement.getText()+"\n"
                +"Address==>"+us015Page.adressElement.getText()+"\n"
                +"Description==>"+ us015Page.DescriptionElement.getText()+"\n"
                +"Created Date==>"+us015Page.CreatedDateElement.getText()+"\n"
                +"User==>"+us015Page.userElement.getText()+"\n"
                +"Country==>"+us015Page.countryElement.getText());
    }

    //===========================TC 003==================================
    //TC004 Eyalet, ABD eyaleti olarak sağlanmali ve boş birakilamaz

    @Given("iDYour Username Girer")
    public void i_d_your_username_girer() { us015Page.UsernameBox.sendKeys("hadiarici2");

    }
    @Given("iDYour Password Girer")
    public void i_d_your_password_girer() { us015Page.PasswordBox.sendKeys("12361236Ha.");


        //==============================TC 003=============================
    }

    @Given("HaiD  sadece admin hastaya doktorunu atayabilir")
    public void haid_sadece_admin_hastaya_doktorunu_atayabilir() {
        us015Page.myPagesElement.click();
        us015Page.searchPatientElement.click();
        us015Page.patientsElement.isDisplayed();
        System.out.println("hasta==>" + us015Page.patientsElement.getText());

        us015Page.sSnElemenet.sendKeys("023-05-1986", Keys.ENTER);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].click();", us015Page.showAppointmentsElement);

        JavascriptExecutor javascriptExecutor1 = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor1.executeScript("arguments[0].click();", us015Page.editButton);

        JavascriptExecutor javascriptExecutor2 = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor2.executeScript("arguments[0].click();", us015Page.physicianElement);

        ReusableMethods.waitForVisibility(us015Page.physicianElement, 5);
        Select select = new Select(us015Page.physicianElement);
        select.selectByVisibleText("46094:hadi1 doktor:DERMATOLOGY");

        JavascriptExecutor javascriptExecutor3 = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor3.executeScript("arguments[0].click();", us015Page.saveButton);

    }
    //=============================TC 004=================================


    @Given("Edit Tikalar")
    public void edit_tikalar() {
        us015Page.patientEditElement.click();


    }

    @Given("Country USA secer")
    public void country_usa_secer() {
        Select select3 = new Select(us015Page.patientCountry);
        select3.selectByVisibleText("USA");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].click();", us015Page.patientSave);
        //us015Page.patientSave.click();
    }
     //=========================TC 005=======================================
        @Given("Delete Tiklar")
        public void delete_tiklar() { us015Page.patinetDeleteElement.click();
        }

        @Given("Delete Onaylar")
        public void delete_onaylar() {

            JavascriptExecutor javascriptExecutor1 = (JavascriptExecutor) Driver.getDriver();
            javascriptExecutor1.executeScript("arguments[0].click();", us015Page.patientDeleteOnayElement);

            //us015Page.patientDeleteOnayElement.click();
        // ==============================TC006=========================

        }
            @Given("Messages Tiklar")
            public void messages_tiklar() { us015Page.adminMessagesElemet.click();

            }

            @Given("Yazarlarini ve e-postalarini goruntuler")
            public void yazarlarini_ve_e_postalarini_goruntuler() {
                us015Page.mesajFirstNameElement.isDisplayed();
                us015Page.mesajEmailElement.isDisplayed();

                System.out.println("Mesaj Yazari==>"+us015Page.mesajFirstNameElement.getText());
                System.out.println("Email Adresi==>"+us015Page.mesajEmailElement.getText());

            }
            //============================TC 007=========================

    @Given("Create or edit a Message Tiklar")
    public void create_or_edit_a_message_tiklar() {
    us015Page.CreateanewMessageElement.click();

    }

    @Given("Message icin gerekli bilgiler girer")
    public void message_icin_gerekli_bilgiler_girer() {

        actions.click(us015Page.yeniMesajNameElement).sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys("Randevu Alamiyorum Bu nasil Bir durum"+ Keys.TAB).perform();
    }

    @Given("Save Tikalar")
    public void save_tikalar() {
        us015Page.mesajSaveElemet.click();
    }
    @Given("Mesaj sil Tiklar ve Onaylar")
    public void mesaj_sil_tiklar_ve_onaylar() {
        us015Page.mesajDeleteElement.click();
        us015Page.mesajDeletOnaylaElement.click();



    }

        }











    /*
    @When("Yonetici hasta bilgilerini gorebilir")
    public void yonetici_hasta_bilgilerini_gorebilir() {
        us015Page.myPagesElement.click();
        us015Page.searchPatientElement.click();
        us015Page.patientsElement.isDisplayed();
        System.out.println("hasta==>" + us015Page.patientsElement.getText());

        us015Page.sSnElemenet.sendKeys("023-05-1986", Keys.ENTER);

        System.out.println("id==>"+us015Page.idElement.getText()+"\n"
                +"SSN==>"+ us015Page.ssn1Element.getText()+"\n"
                +"First Name==>"+us015Page.firstNameElement.getText()+"\n"
                +"Last Name==>"+us015Page.lastNameElement.getText()+"\n"
                +"Birth Date==>"+us015Page.birthDateElement.getText()+"\n"
                +"Phone==>"+us015Page.phoneElement.getText()+"\n"
                +"Email==>"+us015Page.emailElement.getText()+"\n"
                +"Gender==>"+us015Page.genderElement.getText()+"\n"
                +"Blood Group==>"+us015Page.blokGroupElement.getText()+"\n"
                +"Address==>"+us015Page.adressElement.getText()+"\n"
                +"Description==>"+ us015Page.DescriptionElement.getText()+"\n"
                +"Created Date==>"+us015Page.CreatedDateElement.getText()+"\n"
                +"User==>"+us015Page.userElement.getText()+"\n"
                +"Country==>"+us015Page.countryElement.getText());



       //JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
       //jsexecutor.executeScript("arguments[0].click();", us015Page.editButton);
       //us015Page.editButton.click();




    }

    @When("ID  sadece admin hastaya doktorunu atayabilir")
    public void ıd_sadece_admin_hastaya_doktorunu_atayabilir() {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].click();",us015Page.physicianElement);

        ReusableMethods.waitForVisibility(us015Page.physicianElement,5);
        Select select=new Select(us015Page.physicianElement);
        select.selectByVisibleText("46094:hadi1 doktor:DERMATOLOGY");

        JavascriptExecutor javascriptExecutor1 = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor1.executeScript("arguments[0].click();",us015Page.saveButton);



     */








