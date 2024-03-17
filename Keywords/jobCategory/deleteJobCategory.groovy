package jobCategory

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

import internal.GlobalVariable

public class deleteJobCategory {
	/**
	 * Automate tick multiple job categories based on specified parameter
	 *
	 *
	 *
	 * @param multiJobCategories multiple strings of job categories
	 * @return
	 */
	@Keyword(keywordObject = 'Delete Multiple Job Categories')
	def deleteMultipleJobCategories(String multiJobCategories) {
		String[] arrayJobCategories = multiJobCategories.split(",")

		for(String jobCategoryName : arrayJobCategories) {
			WebUI.waitForPageLoad(0)

			WebUI.check(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/div_JobCategory_Checkbox_oxd-table-cell oxd-padding-cell',
					[('jobCategoryName') : jobCategoryName]))
		}
	}

	/**
	 * Automate verify deleted multiple job categories based on specified parameter
	 *
	 *
	 *
	 * @param multiJobCategories multiple strings of job categories
	 * @return
	 */
	@Keyword(keywordObject = 'Verify Delete Multiple Job Categories')
	def verifyDeleteMultipleJobCategories(String multiJobCategories) {
		String[] arrayJobCategories = multiJobCategories.split(",")

		for(String jobCategoryName : arrayJobCategories) {
			WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/div_JobCategory_Name_List', [('jobCategoryName') : jobCategoryName]),
			0)
		}
	}
}
