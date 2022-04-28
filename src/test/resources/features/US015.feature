
Feature: US015 Admin tarafindan hasta oluşturma ve düzenleme
         US027 Yonetici Mesajlari Gorur ve Silebilir

  Background:
  * Yonetici Medunna Sayfasina gider
  * Sing in Tiklar
  * Your Username Girer
  * Your Password Girer
  * Sing in Giris Yapar
  * Items&Titles Tiklar


  Scenario: TC001 Yeni hastalar yalnizca yönetici tarafindan olusturulabilir
  * Patients Tiklar
  * Create or edit a Patient Tiklar
  * Create or edit a Patient Tiklar Hasta icin Gerekli Bilgiler girer
  * Save Buttonuna Tiklar

  Scenario: TC002 Yonetici asagıdaki gibi tüm hasta bilgilerini gorebilir
  * Patients Tiklar
  * hasta bilgilerini görebilir

  Scenario: TC003 ID. Ayrıca sadece admin hastaya doktorunu atayabilir
  * Yonetici Medunna Sayfasina gider
  *  Sing inTiklar
  *  iDYour Username Girer
  *  iDYour Password Girer
  *  Sing in Giris Yapar
  *  ID  sadece admin hastaya doktorunu atayabilir

  Scenario: TC004 Eyalet, ABD eyaleti olarak saglanmalı ve bos bırakılamaz
  * Patients Tiklar
  * Edit Tikalar
  * Country USA secer


  Scenario: TC005 Yonetici herhangi bir hastayi silebilir
  * Patients Tiklar
  * Delete Tiklar
  * Delete Onaylar

  Scenario: TC006 Yonetici, mesaj portalına gidebilir ve tum mesajları, yazarlarını ve
   e-postalarini goruntuleyebilir
  * Messages Tiklar
  * Yazarlarini ve e-postalarini goruntuler


  Scenario: TC007 Yonetici mesajlari olusturabilir, guncelleyebilir, silebilir
  * Messages Tiklar
  * Create or edit a Message Tiklar
  * Message icin gerekli bilgiler girer
  * Save Tikalar
  * Mesaj sil Tiklar ve Onaylar








