import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Common/G0-S1-Login/G0-S1-TC1-Admin Successfully Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Use custom keyword for same steps in a group of feature'
CustomKeywords.'common.navigateMenu.navigateQualificationsSkillsMenu'()

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/button_Skill_Add'))

WebUI.waitForPageLoad(0)

WebUI.setText(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/input_Skill_Name_oxd-input oxd-input--focus'), skillName)

WebUI.setText(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/textarea_Skill_Description_oxd-textarea oxd-textarea--focus oxd-textarea--resize-vertical'), 
    skillDescription)

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/button_Skill_Save'))

WebUI.verifyElementPresent(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/p_Skill_Prompt_Successfully Saved'), 0)

WebUI.verifyElementText(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/p_Skill_Prompt_Successfully Saved'), GlobalVariable.promptSavedSuccess)

WebUI.waitForPageLoad(0)

'Wait for page load alone does not wait until spinning circle in OrangeHRM finish and then make the table visible. Thus, wait for element visible is also used.'
WebUI.waitForElementVisible(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/div_skill_Name_List', [('skillName') : skillName]), 
    0)

'Verify whether table contains new skill'
WebUI.verifyElementPresent(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/div_skill_Name_List', [('skillName') : skillName]), 
    0)

WebUI.verifyElementText(findTestObject('OrangeHRM-AddSkill/Page_OrangeHRM/div_skill_Name_List', [('skillName') : skillName]), 
    skillName)

WebUI.closeBrowser()

