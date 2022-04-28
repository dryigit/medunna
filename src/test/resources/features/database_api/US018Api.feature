Feature: US_018 Admin olarak; Yeni Physicians Olustur / Guncelle / Goruntule ve Sil

  @api1
  Scenario : Physician registrant test
   Given lvnt gerekli path params ayarlamalarini yapar
   And lvnt gerekli parametreleri girer
   And lvnt request gonderir ve response alir
   Then lvnt api kayitlarini dogrular

  @api2
  Scenario: Physicians okuma
    Given lvnt kullanici medunna apiden "https://www.medunna.com/api/physicians/" physician bilgilerini okur

  @api3
  Scenario :Physicians olusturma
    Given lvnt kullanici api end point "https://www.medunna.com/api/physicians" den physician olusturur

