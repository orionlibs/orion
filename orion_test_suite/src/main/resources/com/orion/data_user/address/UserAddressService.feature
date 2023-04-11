Feature: data user user address service
    Scenario: 1-is address valid
        Given user address
            | field-names       | values      |
            | houseAddressLine1 | Street Name |
            | postcode          | W6 9HH      |
            | city              | London      |
        Then is user address valid
        
        
    Scenario: 2-is address invalid
        Given user address
            | field-names       | values      |
            | houseAddressLine1 | Street Name |
            | city              | London      |
        Then is user address invalid