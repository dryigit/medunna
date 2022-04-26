
Feature: US_019_Admin create a new staff, edit and delete

  @E2E
  Scenario Outline: US019_TC_01_Admin can create a new staff

    Given AdminOkan signs in from home page by own admin "<username>" and "<password>"
    Then AdminOkan clicks the User Management from Administration title
    And AdminOkan clicks the Create a new User
    And AdminOkan enters the info all text boxs, select the language & role and clicks the save button
    And AdminOkan verifies the successful save process
    Then AdminOkan sign out yapar

    Examples:

      | username | password |
      | Okanok | Ozi888. |


  Scenario Outline: US019_TC_02_Admin can search new Staff among registered people using their SSN

    Given AdminOkan signs in from home page by own admin "<username>" and "<password>"
    Then AdminOkan clicks the Staff in dropdown menu from Items&Titles
    And AdminOkan clicks the Create a new Staff
    And AdminOkan enters the SSN "<SSN>" and searches
    And AdminOkan should populate the text box which is null "<phone>" "<address>" "<description>" and save
    And AdminOkan verifies the search result

    Examples:

      | username | password | SSN            |phone         | address     | description |
      | Okanok | Ozi888.    | 777-88-9999   |147-542-7854  | 801 street | doctor |

    @E2E
    Scenario Outline: US019_TC_03_Admin can edit staff information

      Given AdminOkan signs in from home page by own admin "<username>" and "<password>"
      Then AdminOkan clicks the User Management from Administration title
      And AdminOkan finds the record to edit
      And AdminOkan edits some info "<email>" and save
      And AdminOkan verifies the successful edit process
      Then AdminOkan sign out yapar

      Examples:

      | email            | username | password |
      | nursefatma@yahoo.com  | Okanok   | Ozi888. |

  @E2E
  Scenario Outline: US019_TC_04_Admin can select a user from the existing users

    Given AdminOkan signs in from home page by own admin "<username>" and "<password>"
    And AdminOkan clicks the User Management from Administration title
    And AdminOkan can select a user from the existing users
    And AdminOkan verifies the visibility of selected user info
    Then AdminOkan sign out yapar

    Examples:

    | username | password |
    | Okanok   | Ozi888. |

  @E2E
  Scenario Outline: US019_TC_05_Admin can delete created Staff

    Given AdminOkan signs in from home page by own admin "<username>" and "<password>"
    Then AdminOkan clicks the User Management from Administration title
    And AdminOkan finds the record of newly staff
    And AdminOkan deletes the new staff record
    Then AdminOkan verifies the successful delete process

    Examples:

    | username | password |
    | Okanok   | Ozi888. |





