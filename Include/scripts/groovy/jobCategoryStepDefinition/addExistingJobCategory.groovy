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

class addExistingJobCategory {
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
	 @When("User clicks on Add button")
	 def clickAdd() {
	 WebUI.click(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/button_JobCategory_Add'))
	 WebUI.waitForPageLoad(0)
	 }
	 @And("User inputs (.*)")
	 def addJobCategoryDetails(String jobCategoryName) {
	 WebUI.setText(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/input_JobCategory_Name_oxd-input oxd-input--focus'),
	 jobCategoryName)
	 WebUI.waitForPageLoad(0)
	 WebUI.click(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/button_JobCategory_Save'))
	 }
	 */

	@Then("Job Category is not successfully saved")
	def jobCategoryNotSaved() {
		WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/p_JobCategory_Prompt_Successfully Saved'),
				0)

		WebUI.verifyElementPresent(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/span_JobCategory_Prompt_Already exists'),
				0)

		WebUI.verifyElementText(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/span_JobCategory_Prompt_Already exists'),
				GlobalVariable.promptAlreadyExists)

		WebUI.closeBrowser()
	}
}