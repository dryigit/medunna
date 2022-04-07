Feature: US008_Guclu password

Background:

  Given adminOkan medunna anasayfasına gider // //
  And giris yapmak icin ikon altındaki signIn'e tıklar
  Then kullanıcı adını "<username>" girer
  And sifresini "<password>" girer
  And signIn sayfasındaki signIn butonuna tıklar
  And ikon altındaki password sekmesine tıklar
  And gecerli sifresini "<currentPassword>" girer







  Scenario Outline: US008_TC03_Kucuk harf kullanarak guclu sifre olusturmak

    Given

  Scenario Outline: US008_TC04_Buyuk harf kullanarak guclu sifre olusturmak


  Scenario Outline: US008_TC05_Ozel karakter kullanarak guclu sifre olusturmak


  Scenario Outline: US008_TC06_Rakam kullanarak guclu sifre olusturmak

  Scenario Outline: US008_TC07_En az yedi karakterli guclu sifre olusturmak