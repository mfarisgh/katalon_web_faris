Feature: Add Job Category
Scenario Outline: Successfully add new job category

Given User navigates to the Job Category Page
When User clicks on Add button
And User inputs <jobCategoryName>
Then Job Category <jobCategoryName> is successfully saved

Examples:
|jobCategoryName|
|Cat A|
|Cat B|