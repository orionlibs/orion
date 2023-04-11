Feature: core in-memory configuration service
    Background:
        Given in-memory configuration entries
            | keys | values |
            | key1 | value1 |
            | key2 | value2 |
            | key3 | value3 |


    Scenario: 1-check config size
        Then in-memory configuration size is at least 3
        
        
    Scenario: 2-check in-memory configuration size after adding entries
        When add in-memory configuration entries
            | keys | values |
            | key4 | value4 |
            | key5 | value5 |
        Then in-memory configuration size is at least 5
        
        
    Scenario: 3-check in-memory configuration size after removing entries
        When delete in-memory configuration entries with keys
            | key1 |
            | key3 |
        Then in-memory configuration size is at least 1
        
        
    Scenario: 4-update in-memory configuration entry
        When update in-memory configuration entries
            | keys | values    |
            | key2 | value2New |
        Then in-memory configuration value for key "key2" is "value2New"