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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

import internal.GlobalVariable

public class calcSalary {
	/**
	 * Automate compare min & max salary whether suitable based on test case requirement
	 *
	 *
	 *
	 * @param minSalary string of minimum salary
	 * @param maxSalary string of maximum salary
	 * @return
	 */
	@Keyword(keywordObject = 'Compare Min & Max Salary')
	def compareMinMaxSalary(String minSalary, String maxSalary) {
		String statusText = "Min & max salary comparison passed. Proceeding next test steps ..."
		if (Integer.parseInt(minSalary) < Integer.parseInt(maxSalary)) {
			statusText = "Value of min salary is lower than max salary! Thus, defeating the purpose of this test case."
			KeywordUtil.markFailedAndStop(statusText)
		}
		return statusText
	}
}
