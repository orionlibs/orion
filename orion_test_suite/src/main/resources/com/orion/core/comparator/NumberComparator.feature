Feature: core number comparator
    Scenario: 1-compare 2 numbers
        When compare numbers "2" and "2.0" to be equal
        When compare numbers "2.76" and "-5" to be unequal