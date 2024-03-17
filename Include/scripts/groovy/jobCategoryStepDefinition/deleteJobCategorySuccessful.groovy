package jobCategoryStepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import common.navigateMenu

class deleteJobCategorySuccessful {
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

	@When("User clicks on Delete button for job category (.*)")
	def clickDelete(String jobCategoryName) {
		WebUI.click(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/button_JobCategory_Delete_oxd-icon-button oxd-table-cell-action-space',
			[('jobCategoryName') : jobCategoryName]))
	
		WebUI.waitForPageLoad(0)
	}

	@And("User clicks on confirmation button to delete job category")
	def confirmDelete() {
		WebUI.click(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/button_JobCategory_Confirm_Yes, Delete'))
	}

	@Then("Job Category (.*) is successfully deleted")
	def jobCategoryDeleted(String jobCategoryName) {
		WebUI.verifyElementPresent(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/p_JobCategory_Prompt_Successfully Deleted'),
			0)
		
		WebUI.verifyElementText(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/p_JobCategory_Prompt_Successfully Deleted'),
			GlobalVariable.promptDeleteSuccess)
		
		WebUI.waitForPageLoad(0)
		
		WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/div_JobCategory_Name_List', [('jobCategoryName') : jobCategoryName]),
			0)
		
		WebUI.closeBrowser()
	}
}