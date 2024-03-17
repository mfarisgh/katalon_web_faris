Feature: Delete Job Category
Scenario Outline: Successfully delete a job category

Given User navigates to the Job Category Page
When User clicks on Delete button for job category <jobCategoryName>
And User clicks on confirmation button to delete job category
Then Job Category <jobCategoryName> is successfully deleted

Examples:
|jobCategoryName|
|Cat A|