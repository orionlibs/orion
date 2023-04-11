Feature: core reverse compare to service
    Scenario: 1-reverse compare 2 strings
        When reverse compare strings "hello" and "world" to be equal
        When reverse compare strings "hello" and "hello" to be unequal