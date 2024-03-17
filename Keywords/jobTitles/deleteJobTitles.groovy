package jobTitles

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

public class deleteJobTitles {
	/**
	 * Automate tick multiple job titles based on specified parameter
	 *
	 *
	 *
	 * @param multiJobTitles multiple strings of job titles
	 * @return
	 */
	@Keyword(keywordObject = 'Delete Multiple Job Titles')
	def deleteMultipleJobTitles(String multiJobTitles) {
		String[] arrayJobTitles = multiJobTitles.split(",")

		for(String jobTitle : arrayJobTitles) {
			WebUI.waitForPageLoad(0)

			WebUI.check(findTestObject('OrangeHRM-DeleteJobTitle/Page_OrangeHRM/div_Job_Checkbox_oxd-table-cell oxd-padding-cell', [
				('jobTitle') : jobTitle]))
		}
	}

	/**
	 * Automate verify deleted multiple job titles based on specified parameter
	 *
	 *
	 *
	 * @param multiJobTitles multiple strings of job titles
	 * @return
	 */
	@Keyword(keywordObject = 'Verify Delete Multiple Job Titles')
	def verifyDeleteMultipleJobTitles(String multiJobTitles) {
		String[] arrayJobTitles = multiJobTitles.split(",")

		for(String jobTitle : arrayJobTitles) {
			WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-DeleteJobTitle/Page_OrangeHRM/div_Job_Title_List', [('jobTitle') : jobTitle]),
			0)
		}
	}
}
