Feature: US002_Email ve Username
  Scenario: TC01_Kayıt olmak için girilebilmelidir
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menüde bulunan account simgesine tıklar
    And mf kullanici register butonuna tıklar
    Then kullanici username girer

  Scenario: TC02_Kayıt olmak için girilebilmelidir
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menüde bulunan account simgesine tıklar
    And mf kullanici register butonuna tıklar
    Then kullanici email girer

  Scenario: TC03_Kayıt olmak için girilebilmelidir
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menüde bulunan account simgesine tıklar
    And mf kullanici register butonuna tıklar
    Then kullanici email girer
    Then kullanici password girilebilmelidir
    Then kullanici password ikinci defa girilebilmelidir
    Then kullanici register butonuna tıklar
    And



