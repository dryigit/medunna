Feature: Registration api testi
  @apiTesti
  Scenario Outline: registrant test
    Given mfapikullanici gerekli path params ayarlamalarini yapar
    And mfapikullanici gerekli parametreleri girer "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" ve "<lan>"
    And mfapikullanici request gonderir ve response alir
    When mfapikullanici api kayitlarili ilgili dosyaya kaydeder
    Then mfapikulllanici api kayitlarini dogrular

    Examples: api test data
      |firstname|lastname|SSN        |email           |username   |password  |lan|
      |Meltem   |Canan   |293-38-2931|meltem@canan.com|meltemcanan|Meltem123.|en|