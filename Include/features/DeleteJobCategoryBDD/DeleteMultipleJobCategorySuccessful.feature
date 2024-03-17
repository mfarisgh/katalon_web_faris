Feature: Delete Multiple Job Category
Scenario Outline: Users delete more than one job category

Given User navigates to the Job Category Page
When User deletes based on checkboxes that are checked beside job categories <jobCategoryNames>
And User clicks on confirmation button to delete job category
Then Job Categories <jobCategoryNames> are successfully deleted

Examples:
|jobCategoryNames|
|Cat B,Cat C|