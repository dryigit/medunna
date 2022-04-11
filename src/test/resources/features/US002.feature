@Tc
Feature: US002_Email ve Username
  Scenario Outline: TC01_Kayıt olmak için girilebilmelidir
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menüde bulunan account simgesine tıklar
    And mf kullanici register butonuna tıklar
    Then kullanici "<username>" girer
    Examples: test data
      |username|
      |alicankara|

  Scenario Outline:TC02_Kayıt olmak için girilebilmelidir
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menüde bulunan account simgesine tıklar
    And mf kullanici register butonuna tıklar
    Then kullanici "<email>" yazar ve sayfayi asagi kaydirir
    Examples: test data
      |email|
      |alicankara@medunna.com|

  Scenario Outline:: TC03_Kayıt olmak için girilebilmelidir
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menüde bulunan account simgesine tıklar
    And mf kullanici register butonuna tıklar
    Then kullanici "<ilkPassword>" girilebilmelidir
    Then kullanici "<ikinciPassword>" ikinci defa girilebilmelidir
  Then kullanici register butonuna tıklar
    Examples: test data
      |ilkPassword|ikinciPassword|
      |Alicankara20!|Alicankara20!|



