@medunnaAllProject
Feature:US24 DataBase


  Scenario: read user information

    * shuser connects to the database
    #kullanici db ye baglanir.

    * shuser gets the "*" from "bill" table
    # select * from bill sorgusu yapar.

    * shuser read all of the "ssn" column data
    #kullanicin id sutunun oku.

    * shverify "bill" tabel "ssn" column contains "060-06-0541"
    #bill table'deki ssn sutunundaki 060-06-0541 ssnli hasta kayitli mi onu verify et.

    * user close the database connection



