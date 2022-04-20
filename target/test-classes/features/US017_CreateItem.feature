@US017
Feature: US017-Test items(öğe) Oluştur / Güncelle / Sil

  Background: Kullanici Admin olarak giris yapar
    Given Kullanici medunna anasayfasina gider
    Then Admin olarak giris yapar
    |Kullanici Adi|Sifre|
    |Team86Admin|Batch44+|
    Then Menuden Items&Titles butonunu tiklar
    And Test item secenegini tiklar

  Scenario: TC01 - Admin can create new test itemsAdmin can create new test items
    Then Create a new test item butonunu tiklar
  Then Test item bilgilerini doldurur
  And A new Test Item is created with identifier yazisi gorulur olmali
    Then Sayfayi kapatir

    Scenario: TC02 -there should be following items for creating/ updating test items; Name, Description, price Default min value, Default max value and created date as MM/DAY/YEAR
      Then Created Date sekmesine tiklar
      And Edit butonuna tiklar
      Then Name, Description, price Default min value, Default max value and created date as MM DAY YEAR kutularinin goruntulendigini dogrular"
      And Name, Description, price Default min value, Default max value bilgilerini gunceller
      Then "A Test Item is updated with identifier" basarili guncelleme yazisini dogrular
      Then Sayfayi kapatir

  Scenario: TC04 - Admin can view test items
    Then Test Items yazisi gorunur olmali
    Then Sayfayi kapatir

  Scenario: TC05 - Admin can delete test items
    Then Delete Butonunu tiklar
    And Acilan pencerede delete butonuna tiklar
    Then Silindi yazisi gorulebilmeli
    Then Sayfayi kapatir