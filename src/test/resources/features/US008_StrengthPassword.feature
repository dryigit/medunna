@medunnaAllProject
Feature: US008_Guclu password


  Scenario Outline: US008_TC03_kullanici buyuk harf kullanarak sifre zorluk seviyesini test eder (level 1)

    Given staffHakan medunna anasayfasina gider
    And staffHakan giris yapmak icin ikon altindaki signIn'e tiklar
    Then staffHakan kullanici adini "Hkaya" girer
    And staffHakan sifresini "Hkaya123," girer
    And staffHakan signIn sayfasindaki signIn butonuna tiklar
    And staffHakan ikon altindaki password sekmesine tiklar
    And staffHakan gecerli sifresini "Hkaya123," girer
    And staffHakan yeni sifresini girer "<newPassword>"
    Then staffHakan sifre zorluk seviyesinin "1" oldugunu dogrular

    Examples: Test Data
    |newPassword |
    | ABCDEFG    |

  # Scenario Outline: US008_TC04_kullanici buyuk ve kucuk harf kullanarak sifre zorluk seviyesini test eder (level 2)

   # Given staffHakan yeni sifre kutusunu temizler
   # And staffHakan yeni sifresini girer "<newPassword>"
    #Then staffHakan sifre zorluk seviyesinin "2" oldugunu dogrular

    Examples: Test Data
      |newPassword |
      | Abcdefg    |

  #Scenario Outline: US008_TC05_kullanici buyuk, kucuk harf ve rakam kullanarak sifre zorluk seviyesini test eder (level 3)

   # Given staffHakan yeni sifre kutusunu temizler
   # And staffHakan yeni sifresini girer "<newPassword>"
   # Then staffHakan sifre zorluk seviyesinin "3" oldugunu dogrular

    Examples: Test Data
      |newPassword |
      | ABcdE23 |

 # Scenario Outline: US008_TC06_kullanici buyuk, kucuk harf, rakam ve ozel karakter kullanarak sifre zorluk seviyesini test eder (level 4)

   # Given staffHakan yeni sifre kutusunu temizler
   # And staffHakan yeni sifresini girer "<newPassword>"
   # Then staffHakan sifre zorluk seviyesinin "4" oldugunu dogrular

    Examples: Test Data
      |newPassword |
      |  ABcdE23  |

  #Scenario Outline: US008_TC07_kullanici en az yedi karakterli buyuk-kucuk harf, ozel karakter ve rakam kullanarak sifre zorluk seviyesini test eder (level 5)

    # Given staffHakan yeni sifre kutusunu temizler
    # And staffHakan en az yedi karakterli yeni sifre"<newPassword>" girer
    # Then staffHakan sifre zorluk seviyesinin "5" oldugunu dogrular

    Examples: Test Data

      |newPassword|
      | Abcde1.  |

