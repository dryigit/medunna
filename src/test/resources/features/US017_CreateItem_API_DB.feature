
Feature: US017-Test items(öğe) Oluştur / Güncelle / Sil
  @ApiTestItem
  Scenario Outline: TC06 - Validate them with api

  Given kullanici gerekli items icin path params ayarlamalarini yapar
  Then kullanici test items icin expected datalari olusturur "<defMaxVal>", "<defMinVal>", "<description>", "<name>", 400
  Then kullanici items icin request gonderir ve response alir
  And kullanici API kayitlarini dosyaya kaydeder
  And kullanici API kayitlarini onaylar

    Examples: test data
      |defMaxVal|defMinVal|description|name|
      |57      |40      |Api versuch|Jc Hettinger|

  @ApiTestItem
  Scenario Outline: TC07 - Create test items using api

    Given kullanici post islemi icin gerekli items icin path params ayarlamalarini yapar
    Then kullanici test items icin expected datalari olusturur "<defMaxVal>", "<defMinVal>", "<description>", "<name>", 400
    Then kullanici items olusturmak ve post islemi icin request gonderir ve response alir
    And kullanici API kayitlarini dosyaya kaydeder
    And kullanici API kayitlarini onaylar

    Examples: test data
      |defMaxVal|defMinVal|description|name|
      |250      |40      |alkol|metil|



  @ApiTestItem
  Scenario Outline: TC09 -  test item deletion with Api
    Given user sets the necessary path parameters "<id>"
    When user sends delete request and gets the response
    Then user validates that the item "<id>" has been deleted
    Examples: test data
      | id    |
      |75937|

  @DBTestItem
  Scenario Outline: TC08 - Validate them with DB
    Given user connects to the Database
    Given user gets the "<COLUMN>" of registrant "<user>" from "<table>" table
    Then user validates "<user>" from "<COLUMN>" column
    Then user close the database connection
    Examples:test data
      | user     | table       | COLUMN |
      | Chas     | c_test_item | name   |



