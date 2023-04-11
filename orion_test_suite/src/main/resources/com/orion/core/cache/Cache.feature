Feature: core cache
    Background:
        Given cache entries
            | keys | values |
            | key1 | value1 |
            | key2 | value2 |
            | key3 | value3 |


    Scenario: 1-check cache size
        Then cache size is 3
    
        
    Scenario: 2-check cache size after adding entries
        When add cache entries
            | keys | values |
            | key4 | value4 |
            | key5 | value5 |
        Then cache size is 5
        
        
    Scenario: 3-check cache size after removing entries
        When delete cache entries with keys
            | key1 |
            | key3 |
        Then cache size is 1