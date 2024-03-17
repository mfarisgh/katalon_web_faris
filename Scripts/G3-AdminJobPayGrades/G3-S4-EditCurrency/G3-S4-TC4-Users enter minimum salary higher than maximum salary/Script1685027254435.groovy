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

'Verify currency to edit'
WebUI.verifyElementPresent(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/div_Currency_List_Name', [('currency') : currency]), 
    0)

WebUI.verifyElementText(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/div_Currency_List_Name', [('currency') : currency]), 
    currency)

'Parameterized currency to select based on specified currency'
WebUI.click(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/button_Currency_Edit_oxd-icon-button oxd-table-cell-action-space', 
        [('currency') : currency]))

WebUI.waitForPageLoad(0)

'Somehow Clear Text does not work for input fields in OrangeHRM. \r\nWorkaround of sending keys Ctrl + a then Backspace is used to clear text in input fields.'
WebUI.sendKeys(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/input_Currency_Minimum Salary_oxd-input oxd-input--focus'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/input_Currency_Minimum Salary_oxd-input oxd-input--focus'), 
    Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/input_Currency_Minimum Salary_oxd-input oxd-input--focus'), 
    minSalary)

'Get Text from max salary field to compare whether the value is suitable to trigger prompt min salary is higher than max salary.'
maxSalary = WebUI.getAttribute(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/input_Currency_Maximum Salary_oxd-input oxd-input--focus'), 
    'value')

println('Max salary value captured : ' + maxSalary)

'If comparison of min and max salary not met, it will fail the step with reason text in console.'
statusText = CustomKeywords.'payGrade.calcSalary.compareMinMaxSalary'(minSalary, maxSalary)

println('Comparison status : ' + statusText)

WebUI.waitForPageLoad(0)

'Click on any element to trigger prompt'
WebUI.click(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/button_Currency_Save'))

WebUI.waitForPageLoad(0)

WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/p_Currency_Prompt_Successfully Updated'), 
    0)

WebUI.verifyElementPresent(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/span_Currency_Prompt_Should be higher than Minimum Salary'), 
    0)

WebUI.verifyElementText(findTestObject('OrangeHRM-EditCurrency/Page_OrangeHRM/span_Currency_Prompt_Should be higher than Minimum Salary'), 
    'Should be higher than Minimum Salary')

WebUI.closeBrowser()

