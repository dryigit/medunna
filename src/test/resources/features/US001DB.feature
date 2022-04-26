@medunnaAllProject
Feature: DB ile ssn dogrulama

   Scenario Outline: DB is ssn kimligi dogrulama

     Given kullanici gerekli path params ayarlamalarini yapar
     And mfdbkullanici gerekli parametreleri girer "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" ve "<lan>"
     And kullanici request gonderir ve response alir
     When kullanici api kayitlarili ilgili dosyaya kaydeder
     Then kulllanici api kayitlarini dogrular
     Then mf kullanici database baglantisi kurar
     Then kullanici "<SSN>" verilerini dogrular
     Examples: api test data
       |firstname|lastname|SSN        |email           |username   |password  |lan|
       |Alim   |Efendi   |244-44-4444|alim@canan.com|alimcan|Alimcan1.|en|
