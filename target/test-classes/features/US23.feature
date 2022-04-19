Feature:
  Scenario: TC01 Kullanici(Staff) fatura olusturabilmeli
  Given Kullanici url'ye gider.
  And Kullanici insan ikonuna tiklar.
  And Kullanici Sign In butonuna tiklar.
  And Kullanici Username kismina valid staff deger girer.
  And Kullanici Password kismina valid staff deger girer ve Sign In butonua tiklar.
  And Kullanici My Pages yazisina tiklar.
  And Kullanici acilan alt menude Seach Patient yazisina tiklar.
  And Kullanici Patients SSN kismina Patient SSN degeri girer.
  And Kullanici acilan sayfada Patient icin Show Appointments kismina tiklar.
  And Kullanici acilan sayfada Payment Invoice Process butonuna tiklar.
  And Kullanici Payment Detail ekranindan Creat Invoice kismina tiklar.
  And Kullanici Create or Edit a Bill sayfasinda patient odeme turunu secer ve Save tusuna basar.
  And Kullanici tekrar acilan Patients sayfasinda SSN kismina Patient SSN degeri girer.
  And Kullanici hastanin Show Appointments kismina tiklar.
  And Kullanici ilgili randevunun Payment Invoice Process yazisina tiklar.
  And Kullanici Payment Detail sayfasinda Show Invoice yazisina tiklar.
  And Kullanici acilan sayfada INVOICE yazisinin oldugunu dogrular.