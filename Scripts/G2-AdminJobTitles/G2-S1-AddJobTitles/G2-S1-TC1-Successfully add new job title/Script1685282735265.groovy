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
CustomKeywords.'common.navigateMenu.navigateJobTitlesMenu'()

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/button_Add_JobTitle'))

WebUI.waitForPageLoad(0)

WebUI.setText(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/input_Job Title_oxd-input oxd-input--focus'), jobTitle)

WebUI.setText(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/textarea_Job Description_oxd-textarea oxd-textarea--focus oxd-textarea--resize-vertical'), 
    jobDescription)

'Upload file based on location of file in local computer'
WebUI.uploadFile(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/div_BrowseNo file chosen'), jobFileLoc)

WebUI.waitForPageLoad(0)

WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/span_Attachment Size Exceeded'), 0)

WebUI.setText(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/textarea_Note_oxd-textarea oxd-textarea--focus oxd-textarea--resize-vertical'), 
    jobNote)

WebUI.click(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/button_Save_JobTitle'))

WebUI.verifyElementPresent(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/p_Successfully Saved'), 0)

WebUI.verifyElementText(findTestObject('OrangeHRM-AddJobTitle/Page_OrangeHRM/p_Successfully Saved'), GlobalVariable.promptSavedSuccess)

WebUI.closeBrowser()

