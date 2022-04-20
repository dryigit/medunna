@qwe
Feature:US25 Hasta olarak kayit olusturulmali

Background:
  Given PatientAG "MedunnaURL" sayfasina gider
    And PatientAG gecerli bilgileri girerek basarili giris yapar



    Scenario:Hasta olarak kayit olusturulmali

        And PatientAG My Pages sayfasi altinda Make an Appointment butonuna tiklar
        Then PatientAG firstname,lastname,SSN,email,phone,appointment date kutularini doldurur
        And PatientAG Send an appointment request butonuna tiklayarak cikan mesajdan randevu olusturuldugunu dogrular

    Scenario:US26 İletisim mesajı istegi gönderebilmeli
        Then PatientAG gecerli bilgileri girerek basarili giris yapar
        And PatientAG Contact sayfasina tiklar
        Then PatientAG name,email,subject,message kutularini doldurur
        And PatientAG Send butonuna tiklayarak cikan mesajdan iletisim istegi gönderildigini dogrular





