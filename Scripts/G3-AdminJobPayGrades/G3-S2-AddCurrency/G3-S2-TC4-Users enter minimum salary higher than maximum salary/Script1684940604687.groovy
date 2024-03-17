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

'Parameterized payGrade to select based on specified pay grade'
WebUI.click(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/button_PayGrade_Edit_oxd-icon-button oxd-table-cell-action-space', 
        [('payGrade') : payGrade]))

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/button_Currency_Add'))

WebUI.waitForPageLoad(0)

'Click before dropdown visible'
WebUI.click(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/div_Currency_OpenDropdown_-- Select --'))

'Click after dropdown visible | Parameterized currency'
WebUI.click(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/span_Currency_DropdownValue', [('currency') : currency]))

WebUI.setText(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/input_Currency_Minimum Salary_oxd-input oxd-input--focus'), 
    minSalary)

WebUI.setText(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/input_Currency_Maximum Salary_oxd-input oxd-input--focus'), 
    maxSalary)

WebUI.waitForPageLoad(0)

WebUI.verifyElementPresent(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/span_Currency_Prompt_Should be higher than Minimum Salary'), 
    0)

WebUI.verifyElementText(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/span_Currency_Prompt_Should be higher than Minimum Salary'), 
    'Should be higher than Minimum Salary')

WebUI.click(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/button_Currency_Save'))

WebUI.waitForPageLoad(0)

WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-AddCurrency/Page_OrangeHRM/p_Currency_Prompt_Successfully Saved'), 
    0)

WebUI.closeBrowser()

