Feature: Registration api testi
  @apiTesti
  Scenario Outline: registrant test
    Given kullanici gerekli path params ayarlamalarini yapar
    And kullanici gerekli parametreleri girer "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" ve "<lan>"
    And kullanici request gonderir ve response alir
    When kullanici api kayitlarili ilgili dosyaya kaydeder
    Then kulllanici api kayitlarini dogrular

    Examples: api test data
      |firstname|lastname|SSN        |email           |username   |password  |lan|
      |Meltem   |Canan   |293-38-2931|meltem@canan.com|meltemcanan|Meltem123.|en|