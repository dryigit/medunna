Feature: us002 api ve database testi

  Scenario: email api testi
    Given mf kullanici api icin gerekli path params ayarlamalarini yapar
    And kullanici gerekli parametreleri girer "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" ve "<lan>"
    And kullanici email testi icin request gonderir ve response alir
    When kullanici email testi icin api kayitlarili ilgili dosyaya kaydeder
    Then email api ile dogrulanir

  Scenario: email db testi
    Given mf kullanici email dogrulamasi icin db baglantisi kurar
    Then kullanici db testi icin "email" dogrular


