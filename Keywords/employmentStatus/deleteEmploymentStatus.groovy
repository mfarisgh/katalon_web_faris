package employmentStatus

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

public class deleteEmploymentStatus {
	/**
	 * Automate tick multiple employment status based on specified parameter
	 *
	 *
	 *
	 * @param multiEmpStatus multiple strings of employment status
	 * @return
	 */
	@Keyword(keywordObject = 'Delete Multiple Employment Status')
	def deleteMultipleEmploymentStatus(String multiEmpStatus) {
		String[] arrayEmpStatus = multiEmpStatus.split(",")

		for(String employmentStatusName : arrayEmpStatus) {
			WebUI.waitForPageLoad(0)

			WebUI.check(findTestObject('OrangeHRM-DeleteEmploymentStatus/Page_OrangeHRM/div_EmpStatus_Checkbox_oxd-table-cell oxd-padding-cell',
					[('employmentStatusName') : employmentStatusName]))
		}
	}

	/**
	 * Automate verify deleted multiple employment status based on specified parameter
	 *
	 *
	 *
	 * @param multiEmpStatus multiple strings of employment status
	 * @return
	 */
	@Keyword(keywordObject = 'Verify Delete Multiple Employment Status')
	def verifyDeleteMultipleEmploymentStatus(String multiEmpStatus) {
		String[] arrayEmpStatus = multiEmpStatus.split(",")

		for(String employmentStatusName : arrayEmpStatus) {
			WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-DeleteEmploymentStatus/Page_OrangeHRM/div_EmpStatus_Name_List',
					[('employmentStatusName') : employmentStatusName]), 0)
		}
	}
}
