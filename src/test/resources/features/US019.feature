Feature: US_019_Admin create a new staff, edit and delete

  Scenario Outline: US019_TC_01_Admin can create a new staff

    Given AdminOkan signs in from home page by own admin "<username>" and "<password>"
    Then AdminOkan clicks the User Management from Administration title
    And AdminOkan clicks the Create a new User
    And AdminOkan enters the info all text boxs, select the language & role and clicks the save button
    And AdminOkan verifies the successful save process

    Examples:

      | username | password |
      | Okanok | Ozi888. |


  Scenario Outline: US019_TC_02_Admin can search new Staff among registered people using their SSN

    Given AdminOkan signs in from home page by own admin "<username>" and "<password>"
    Then AdminOkan clicks the Staff in dropdown menu from Items&Titles
    And AdminOkan clicks the Create a new User
    And AdminOkan enters the SSN and searches
    And AdminOkan should populate the text box which is null "<phone>" "<address>" "<description>" and save
    And AdminOkan verifies the successful save process

    Examples:

      | username | password | phone         | address     | description |
      | Okanok | Ozi888.    |  147-542-7854 | high street | technician |