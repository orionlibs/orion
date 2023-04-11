Feature: core compare to service
    Scenario: 1-compare 2 strings
        When compare strings "hello" and "hello" to be equal
        When compare strings "hello" and "world" to be unequal