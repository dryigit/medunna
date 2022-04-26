@medunnaAllProject
Feature: US006-Kullanıcı bilgisi sekmesi (Setting) Ana Sayfada düzenlenebilir olmalıdır.

    Background:
      Given lvnt kullanici "MedunnaURL" sayfasina gider
      And lvnt kullanici account menu simgesine tiklar
      And lvnt kullanici acilan menuden sing-in'i secer
      And lvnt username alanina "userLevent" girer
      And lvnt password alanina "Zlu.asdf1234" girer
      And lvnt sign in butonuna tiklar
      And lvnt kullanici user simgesine tiklar
      And lvnt acilan menuden settings'i secer

    Scenario: TC_001 Kullanıcılar Account Settings sayfasindaki bilgileri eksiksiz doldurmali vedegisiklikleri kaydedebilmeli
      And lvnt  firstname alanina yeni bir isim girer
      And lvnt lastname alanina yeni bir isim girer
      And lvnt email alania yeni bir mail girer
      And lvnt save butonuna tiklar
      And lvnt degisikliklerin kaydedildigini dogrular

    Scenario: TC_002 Kullanıcılar Account Settings sayfasindaki sadece firstname alanini degistirmeli ve degisikligi kaydedebilmeli
      And lvnt  firstname alanina yeni bir isim girer
      And lvnt save butonuna tiklar
      And lvnt degisikliklerin kaydedildigini dogrular

    Scenario: TC_003 - Kullanıcılar Account Settings sayfasindaki sadece firstname alanini degistirmeli ve degisikligi kaydedebilmeli
      And lvnt lastname alanina yeni bir isim girer
      And lvnt save butonuna tiklar
      And lvnt degisikliklerin kaydedildigini dogrular

    Scenario: TC_004 - Kullanıcılar Account Settings sayfasindaki sadece firstname alanini degistirmeli ve degisikligi kaydedebilmeli
      And lvnt email alania yeni bir mail girer
      And lvnt save butonuna tiklar
      And lvnt degisikliklerin kaydedildigini dogrular