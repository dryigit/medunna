@Tc
Feature: US_008_Password change


  Scenario Outline: US008_TC01_kullanıcı sign in yaptıgında passwordunu duzenleyebilmeli

    Given adminOkan medunna anasayfasına gider
    And giris yapmak icin ikon altındaki signIn'e tıklar
    Then kullanıcı adını "<username>" girer
    And sifresini "<password>" girer
    And signIn sayfasındaki signIn butonuna tıklar
    And ikon altındaki password sekmesine tıklar
    And gecerli sifresini "<currentPassword>" girer
    And yeni sifresini "<newPassword>" girer
    And yeni sifresini "<newPassword>" confirme eder
    And yeni sifreyi kaydetmek icin save butonuna tıklar
    Then yeni sifresinin basarili olarak degistigini kontrol eder

    Examples: Test data

    | username | password | currentPassword | newPassword |
    | Okanok   | Ozi654.  |   Ozi654.       |   Ozi555.   |


  Scenario Outline: US008_TC02_kullanıcı eski passwordu ile sign in yapamamalı

    Given staffHakan medunna anasayfasına gider
    And giris yapmak icin ikon altındaki signIn'e tıklar
    Then kullanıcı adını "<username>" girer
    And sifresini "<eskiPassword>" girer
    And signIn sayfasındaki signIn butonuna tıklar
    Then giris yapılamadıgını kontrol eder

    Examples: Test data

      | username | eskiPassword |
      | Hkaya   |   Hkaya123.   |