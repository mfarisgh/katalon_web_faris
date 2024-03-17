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
CustomKeywords.'common.navigateMenu.navigateUsersMenu'()

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('OrangeHRM-UsersManagement/Page_OrangeHRM/button_Add'))

WebUI.waitForPageLoad(0)

'Use custom keyword to convert plain text passwords to encrypted text passwords'
encryptedPass = CustomKeywords.'common.managePasswords.encryptTextPassword'(pass)

WebUI.setEncryptedText(findTestObject('OrangeHRM-AddUser/Page_OrangeHRM/input_Password_oxd-input oxd-input--focus'), encryptedPass)

'Use custom keyword to convert plain text passwords to encrypted text passwords'
encryptedConfirmPass = CustomKeywords.'common.managePasswords.encryptTextPassword'(confirmPass)

WebUI.setEncryptedText(findTestObject('OrangeHRM-UsersManagement/Page_OrangeHRM/input_Confirm Password_oxd-input oxd-input--focus'), 
    encryptedConfirmPass)

WebUI.waitForPageLoad(0)

WebUI.verifyElementPresent(findTestObject('OrangeHRM-AddUser/Page_OrangeHRM/span_Prompt_Passwords do not match'), 0)

WebUI.verifyElementText(findTestObject('OrangeHRM-AddUser/Page_OrangeHRM/span_Prompt_Passwords do not match'), GlobalVariable.promptPasswordsNotMatch)

WebUI.closeBrowser()

