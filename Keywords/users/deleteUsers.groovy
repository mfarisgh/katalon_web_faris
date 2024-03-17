package users

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

public class deleteUsers {
	/**
	 * Automate tick multiple user names based on specified parameter
	 *
	 *
	 *
	 * @param multiUserNames multiple strings of user names
	 * @return
	 */
	@Keyword(keywordObject = 'Delete Multiple Users')
	def deleteMultipleUsers(String multiUserNames) {
		String[] arrayUserNames = multiUserNames.split(",")

		for(String userName : arrayUserNames) {
			WebUI.waitForPageLoad(0)

			WebUI.check(findTestObject('OrangeHRM-DeleteUser/Page_OrangeHRM/div_Checkbox_oxd-table-cell oxd-padding-cell', [('userName') : userName]))
		}
	}

	/**
	 * Automate verify deleted multiple user names based on specified parameter
	 *
	 *
	 *
	 * @param multiUserNames multiple strings of user names
	 * @return
	 */
	@Keyword(keywordObject = 'Verify Delete Multiple Users')
	def verifyDeleteMultipleUsers(String multiUserNames) {
		String[] arrayUserNames = multiUserNames.split(",")

		for(String userName : arrayUserNames) {
			WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-DeleteUser/Page_OrangeHRM/div_UsernameList', [('userName') : userName]),
			0)
		}
	}
}
