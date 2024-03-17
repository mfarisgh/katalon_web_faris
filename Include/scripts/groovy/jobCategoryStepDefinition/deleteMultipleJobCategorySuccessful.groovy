package jobCategoryStepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable

import jobCategory.deleteJobCategory

public class deleteMultipleJobCategorySuccessful {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	/*	Step definitions already exist in addJobCategorySuccessful.groovy
	@Given("User navigates to the Job Category Page")
	def navigateJobCategoryPage() {
		WebUI.callTestCase(findTestCase('Common/G0-S1-Login/G0-S1-TC1-Admin Successfully Login'), [:], FailureHandling.STOP_ON_FAILURE)

		//CustomKeywords.'common.navigateMenu.navigateJobCategoriesMenu'()
		new navigateMenu().navigateJobCategoriesMenu()

		WebUI.waitForPageLoad(0)
	}
	*/

	@When("User deletes based on checkboxes that are checked beside job categories (.*)")
	def multipleDelete(String jobCategoryNames) {
		'Call function that consists of test steps based in G5-S2-TC1 but run multple times based on number of job categories'
		//CustomKeywords.'jobCategory.deleteJobCategory.deleteMultipleJobCategories'(jobCategoryNames)
		new deleteJobCategory().deleteMultipleJobCategories(jobCategoryNames)

		WebUI.waitForPageLoad(0)
		
		'Scroll to the upper most of the page to capture the next desired element'
		WebUI.scrollToPosition(0, 0)
		
		WebUI.click(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/button_JobCategory_Multiple_Delete Selected'))
		
		WebUI.waitForPageLoad(0)
	}

	/*	Step definitions already exist in deleteJobCategorySuccessful.groovy
	@And("User clicks on confirmation button to delete job category")
	def confirmDelete() {
		WebUI.click(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/button_JobCategory_Confirm_Yes, Delete'))
	}
	*/

	@Then("Job Categories (.*) are successfully deleted")
	def multipleJobCategoriesDeleted(String jobCategoryNames) {
		WebUI.verifyElementPresent(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/p_JobCategory_Prompt_Successfully Deleted'), 
			0)

		WebUI.verifyElementText(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/p_JobCategory_Prompt_Successfully Deleted'), 
			GlobalVariable.promptDeleteSuccess)

		WebUI.waitForPageLoad(0)

		//CustomKeywords.'jobCategory.deleteJobCategory.verifyDeleteMultipleJobCategories'(jobCategoryNames)
		new deleteJobCategory().verifyDeleteMultipleJobCategories(jobCategoryNames)

		WebUI.closeBrowser()
	}
}
