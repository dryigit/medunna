@Tc
@medunnaAllProject
Feature: US_008_Password change


  Scenario Outline: US008_TC01_kullanici sign in yaptiginda passwordunu duzenleyebilmeli

    Given adminOkan medunna anasayfasina gider
    And adminOkan giris yapmak icin ikon altındaki signIn'e tiklar
    Then adminOkan kullanici adini "<username>" girer
    And adminOkan sifresini "<password>" girer
    And adminOkan signIn sayfasindaki signIn butonuna tiklar
   # And adminOkan ikon altindaki password sekmesine tiklar
   # And adminOkan gecerli sifresini "<currentPassword>" girer
   # And adminOkan yeni sifresini "<newPassword>" girer
   # And adminOkan yeni sifresini "<newPassword>" confirme eder
   # And adminOkan yeni sifreyi kaydetmek icin save butonuna tiklar
   # Then adminOkan yeni sifresinin basarili olarak degistigini kontrol eder

    Examples: Test data

    | username | password | currentPassword | newPassword |
    | Okanok   | Ozi654.  |   Ozi654.       |   Ozi555.   |


  Scenario Outline: US008_TC02_kullanıcı eski passwordu ile sign in yapamamalı

    Given staffHakan medunna anasayfasina gider
    And adminOkan giris yapmak icin ikon altındaki signIn'e tiklar
    Then adminOkan kullanici adini "<username>" girer
    And adminOkan sifresini "<eskiPassword>" girer
    And adminOkan signIn sayfasindaki signIn butonuna tiklar
    Then staffHakan giris yapilamadigini kontrol eder

    Examples: Test data

      | username | eskiPassword |
      | Hkaya   |   Hkaya123.   |