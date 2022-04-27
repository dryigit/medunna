@medunnaAllProject
Feature: US012 Physician (Doktor) test isteyebilmel

Scenario: TC001 Doctor test icin giris yababilmeli

When   Dk Medunna Sayfasina gider
  And  Ha Sing in Tiklar
  And  Ha Your Username Girer
  And  Ha Your Password Girer
  And  Ha Sing İn Giris Yapar
  And  Ha My Pages Buttonunu Tiklar
  And  Ha My Appointments Tiklar
  And  Ha Edit Tiklar
  And  Ha Request A Test Tiklar
  And  Ha Test Seceneklerini Girer
  And  Ha Testleri Save Yapar
  Then Ha Test Sonucunu Goster(Show Test Resuelt)
  Then Ha Test Sonuclarına Bak
