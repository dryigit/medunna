@Tc
@medunnaAllProject
Feature: US_008_Password change


  Scenario Outline: US008_TC01_kullanici sign in yaptiginda passwordunu duzenleyebilmeli

    Given adminOkan medunna anasayfasina gider
    And giris yapmak icin ikon altındaki signIn'e tiklar
    Then kullanici adini "<username>" girer
    And sifresini "<password>" girer
    And signIn sayfasindaki signIn butonuna tiklar
    And ikon altindaki password sekmesine tiklar
    And gecerli sifresini "<currentPassword>" girer
    And yeni sifresini "<newPassword>" girer
    And yeni sifresini "<newPassword>" confirme eder
    And yeni sifreyi kaydetmek icin save butonuna tiklar
    Then yeni sifresinin basarili olarak degistigini kontrol eder

    Examples: Test data

    | username | password | currentPassword | newPassword |
    | Okanok   | Ozi654.  |   Ozi654.       |   Ozi555.   |


  Scenario Outline: US008_TC02_kullanıcı eski passwordu ile sign in yapamamalı

    Given staffHakan medunna anasayfasına gider
    And giris yapmak icin ikon altındaki signIn'e tiklar
    Then kullanici adini "<username>" girer
    And sifresini "<eskiPassword>" girer
    And signIn sayfasindaki signIn butonuna tiklar
    Then giris yapilamadigini kontrol eder

    Examples: Test data

      | username | eskiPassword |
      | Hkaya   |   Hkaya123.   |