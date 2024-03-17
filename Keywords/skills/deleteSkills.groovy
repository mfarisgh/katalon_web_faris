package skills

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

public class deleteSkills {
	/**
	 * Automate tick multiple skills based on specified parameter
	 *
	 *
	 *
	 * @param multiSkills multiple strings of skills
	 * @return
	 */
	@Keyword(keywordObject = 'Delete Multiple Skills')
	def deleteMultipleSkills(String multiSkills) {
		String[] arraySkills = multiSkills.split(",")

		for(String skillName : arraySkills) {
			WebUI.waitForPageLoad(0)

			WebUI.check(findTestObject('OrangeHRM-DeleteSkill/Page_OrangeHRM/div_Skill_Checkbox_oxd-table-cell oxd-padding-cell', [('skillName') : skillName]))
		}
	}

	/**
	 * Automate verify deleted multiple skills based on specified parameter
	 *
	 *
	 *
	 * @param multiSkills multiple strings of skills
	 * @return
	 */
	@Keyword(keywordObject = 'Verify Delete Multiple Skills')
	def verifyDeleteMultipleSkills(String multiSkills) {
		String[] arraySkills = multiSkills.split(",")

		for(String skillName : arraySkills) {
			WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-DeleteSkill/Page_OrangeHRM/div_Skill_Name_List', [('skillName') : skillName]),
			0)
		}
	}
}
