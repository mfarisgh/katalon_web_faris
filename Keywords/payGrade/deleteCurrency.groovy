package payGrade

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

public class deleteCurrency {
	/**
	 * Automate tick multiple currencies based on specified parameter
	 *
	 *
	 *
	 * @param multiCurrency multiple strings of currency
	 * @return
	 */
	@Keyword(keywordObject = 'Delete Multiple Currency')
	def deleteMultipleCurrency(String multiCurrency) {
		String[] arrayCurrency = multiCurrency.split(",")

		for(String currency : arrayCurrency) {
			WebUI.waitForPageLoad(0)

			WebUI.verifyElementPresent(findTestObject('OrangeHRM-DeleteCurrency/Page_OrangeHRM/div_Currency_List_Name', [('currency') : currency]),
			0)

			WebUI.verifyElementText(findTestObject('OrangeHRM-DeleteCurrency/Page_OrangeHRM/div_Currency_List_Name', [('currency') : currency]),
			currency)

			WebUI.check(findTestObject('OrangeHRM-DeleteCurrency/Page_OrangeHRM/div_Currency_Checkbox_oxd-table-cell oxd-padding-cell',
					[('currency') : currency]))
		}
	}

	/**
	 * Automate verify deleted multiple currencies based on specified parameter
	 *
	 *
	 *
	 * @param multiCurrency multiple strings of currency
	 * @return
	 */
	@Keyword(keywordObject = 'Verify Delete Multiple Currency')
	def verifyDeleteMultipleCurrency(String multiCurrency) {
		String[] arrayCurrency = multiCurrency.split(",")

		for(String currency : arrayCurrency) {
			WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-DeleteCurrency/Page_OrangeHRM/div_Currency_List_Name', [('currency') : currency]),
			0)
		}
	}
}
