Feature: US008_Guclu password


  Scenario Outline: US008_TC03_kullanıcı buyuk harf kullanarak şifre zorluk seviyesini test eder (level 1)

    Given staffHakan medunna anasayfasına gider
    And giris yapmak icin ikon altındaki signIn'e tıklar
    Then kullanıcı adını "Hkaya" girer
    And sifresini "Hkaya123," girer
    And signIn sayfasındaki signIn butonuna tıklar
    And ikon altındaki password sekmesine tıklar
    And gecerli sifresini "Hkaya123," girer
    And kullanıcı yeni sifresini girer "<newPassword>"
    Then sifre zorluk seviyesinin "1" oldugunu dogrular

    Examples: Test Data
    |newPassword |
    | ABCDEFG    |

  Scenario Outline: US008_TC04_kullanıcı buyuk ve kucuk harf kullanarak şifre zorluk seviyesini test eder (level 2)

    Given kullanıcı yeni şifre kutusunu temizler
    And kullanıcı yeni sifresini girer "<newPassword>"
    Then sifre zorluk seviyesinin "2" oldugunu dogrular

    Examples: Test Data
      |newPassword |
      | Abcdefg    |

  Scenario Outline: US008_TC05_kullanıcı buyuk, kucuk harf ve rakam kullanarak şifre zorluk seviyesini test eder (level 3)

    Given kullanıcı yeni şifre kutusunu temizler
    And kullanıcı yeni sifresini girer "<newPassword>"
    Then sifre zorluk seviyesinin "3" oldugunu dogrular

    Examples: Test Data
      |newPassword |
      | ABcdE23 |

  Scenario Outline: US008_TC06_kullanıcı buyuk, kucuk harf, rakam ve ozel karakter kullanarak şifre zorluk seviyesini test eder (level 4)

    Given kullanıcı yeni şifre kutusunu temizler
    And kullanıcı yeni sifresini girer "<newPassword>"
    Then sifre zorluk seviyesinin "4" oldugunu dogrular

    Examples: Test Data
      |newPassword |
      |  ABcdE23  |

  Scenario Outline: US008_TC07_kullanıcı en az yedi karakterli buyuk-kucuk harf, ozel karakter ve rakam kullanarak şifre zorluk seviyesini test eder (level 5)

    Given kullanıcı yeni şifre kutusunu temizler
    And kullanıcı en az yedi karakterli yeni sifre"<newPassword>" girer
    Then sifre zorluk seviyesinin "5" oldugunu dogrular

    Examples: Test Data

      |newPassword|
      | Abcde1.  |

