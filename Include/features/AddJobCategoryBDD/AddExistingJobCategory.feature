Feature: Add Existing Job Category
Scenario Outline: Users enter existing job category

Given User navigates to the Job Category Page
When User clicks on Add button
And User inputs <jobCategoryName>
Then Job Category is not successfully saved

Examples:
|jobCategoryName|
|Cat A|