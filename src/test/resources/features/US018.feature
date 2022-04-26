@medunnaAllProject
Feature: US_018 Admin olarak; Yeni Physicians Olustur / Guncelle / Goruntule ve Sil

  Background:
    Given lvntt kullanici "MedunnaURl" sayfasina gider
    Given lvnt kullanici gecerli bilgileri girerek basarili giris yapar

  Scenario: TC01 - Management kullanici bilgileri ile giris yapar ve daha onceden kaydedilmis Physicians'ı SSN numarası ile bulur, aramanin basarili oldugunu dogrular

    And lvnt Items&Titles menusunden Physician'i secer
    And lvnt Create a new Physician'a tiklar
    And lvnt Use Search'e tiklar
    And lvnt SSN alanina varolan bir SSN numarasi girer
    And lvnt Search User'a tiklar
    And lvnt kullanicinin bulundugunu dogrular

  Scenario: TC02 - Management Physician'in bilgilerini degistirebilmeli, profil fotoğrafı ekleyebilmeli, maas ve uzmanlik atayabilmelidir.

    And lvnt Items&Titles menusunden Physician'i secer
    And lvnt SSN numarasi kullanarak kayitli bir physician secer
    And lvnt physician'in telefon, speciality, image, exam fee bilgilerini girer
    And lvnt save butonuna basar ve bilgilerin kaydedildigini dogrular