package common

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

public class navigateMenu {

	/**
	 * Automate navigate menu steps to be used repeatedly in multiple test cases
	 *
	 *
	 *
	 * @param 
	 * @return
	 */
	@Keyword(keywordObject = 'Navigate User Management')
	def navigateUsersMenu() {
		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddUser/Page_OrangeHRM/span_Admin_MainMenu'))
	}

	/**
	 * Automate navigate menu steps to be used repeatedly in multiple test cases
	 *
	 *
	 *
	 * @param
	 * @return
	 */
	@Keyword(keywordObject = 'Navigate Job Titles')
	def navigateJobTitlesMenu() {
		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/span_Admin_MainMenu'))

		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/span_Job_SubMenu'))

		WebUI.click(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/a_Job Titles_SubSubMenu'))
	}

	/**
	 * Automate navigate menu steps to be used repeatedly in multiple test cases
	 *
	 *
	 *
	 * @param
	 * @return
	 */
	@Keyword(keywordObject = 'Navigate Pay Grades')
	def navigatePayGradeMenu() {
		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/span_Admin_MainMenu'))

		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/span_SubMenu_Job'))

		WebUI.click(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/a_SubSubMenu_Pay Grades'))
	}

	/**
	 * Automate navigate menu steps to be used repeatedly in multiple test cases
	 *
	 *
	 *
	 * @param
	 * @return
	 */
	@Keyword(keywordObject = 'Navigate Employment Status')
	def navigateEmpStatusMenu() {
		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddEmploymentStatus/Page_OrangeHRM/span_MainMenu_Admin'))

		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddEmploymentStatus/Page_OrangeHRM/span_SubMenu_Job'))

		WebUI.click(findTestObject('OrangeHRM-AddEmploymentStatus/Page_OrangeHRM/a_SubSubMenu_Employment Status'))
	}

	/**
	 * Automate navigate menu steps to be used repeatedly in multiple test cases
	 *
	 *
	 *
	 * @param
	 * @return
	 */
	@Keyword(keywordObject = 'Navigate Job Categories')
	def navigateJobCategoriesMenu() {
		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/span_MainMenu_Admin'))

		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/span_SubMenu_Job'))

		WebUI.click(findTestObject('OrangeHRM-AddJobCategory/Page_OrangeHRM/a_SubSubMenu_Job Categories'))
	}

	/**
	 * Automate navigate menu steps to be used repeatedly in multiple test cases
	 *
	 *
	 *
	 * @param
	 * @return
	 */
	@Keyword(keywordObject = 'Navigate Qualifications Skills')
	def navigateQualificationsSkillsMenu() {
		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/span_MainMenu_Admin'))

		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/span_SubMenu_Qualifications'))

		WebUI.click(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/a_SubSubMenu_Skills'))
	}
}
