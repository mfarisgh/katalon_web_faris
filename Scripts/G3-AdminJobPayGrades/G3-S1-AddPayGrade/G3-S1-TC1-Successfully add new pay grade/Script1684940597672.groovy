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
CustomKeywords.'common.navigateMenu.navigatePayGradeMenu'()

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/button_PayGrade_Add'))

WebUI.waitForPageLoad(0)

WebUI.setText(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/input_PayGrade_Name_oxd-input oxd-input--focus'), payGrade)

WebUI.click(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/button_PayGrade_Save'))

WebUI.waitForPageLoad(0)

'Since Katalon Spy Web could not capture the element \'Successfully Saved\' because it is too \r\nquick. Clicking Cancel is to return back to the table list to see whether the record is \r\nsuccessfully added.'
WebUI.click(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/button_AddPayGrade_Cancel'))

WebUI.waitForPageLoad(0)

'Wait for page load alone does not wait until spinning circle in OrangeHRM finish and then make the table visible. Thus, wait for element visible is also used.'
WebUI.waitForElementVisible(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/div_PayGradeList', [('payGrade') : payGrade]), 
    0)

WebUI.verifyElementPresent(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/div_PayGradeList', [('payGrade') : payGrade]), 
    0)

WebUI.verifyElementText(findTestObject('OrangeHRM-AddPayGrade/Page_OrangeHRM/div_PayGradeList', [('payGrade') : payGrade]), 
    payGrade)

WebUI.closeBrowser()

