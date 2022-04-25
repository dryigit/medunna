Feature:US24 DataBase


  Scenario: read user information

    * user connects to the database
    #kullanici db ye baglanir.

    * user gets the "*" from "bill" table
    # select * from bill sorgusu yapar.

    * user read all of the "ssn" column data
    #kullanicin id sutunun oku.

    * verify "bill" tabel "ssn" column contains "060-06-0541"
    #bill table'deki ssn sutunundaki 060-06-0541 ssnli hasta kayitli mi onu verify et.

    * user close the database connection



