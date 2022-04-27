Feature: us002 api ve db testi

  Scenario: kullanici api testi
    Given kullanici gerekli path params ayarlamalarini yapar
    And kullanici gerekli parametreleri girer "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" ve "<lan>"
    And kullanici request gonderir ve response alir
    When kullanici api kayitlarili ilgili dosyaya kaydeder
    Then kulllanici adi api ile dogrulanir

