Feature: core SQL timestamp comparator
    Scenario: 1-compare 2 SQL timestamps
        When compare SQL timestamps with time in milliseconds 2000000 and 2000000 to be equal
        When compare SQL timestamps with time in milliseconds 2000000 and 500000 to be unequal