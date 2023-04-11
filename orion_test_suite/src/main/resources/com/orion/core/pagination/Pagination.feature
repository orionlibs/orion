Feature: core pagination
    Scenario: 1-total number of pages calculation
        Given pagination has 1 elements and page limit of 1
        Then total number of pages for pagination is 1
        Given pagination has 1 elements and page limit of 2
        Then total number of pages for pagination is 1
        Given pagination has 2 elements and page limit of 1
        Then total number of pages for pagination is 2
        Given pagination has 5 elements and page limit of 1
        Then total number of pages for pagination is 5
        Given pagination has 5 elements and page limit of 2
        Then total number of pages for pagination is 3