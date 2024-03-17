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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.navUrl)

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('OrangeHRM-ResetPassword/Page_OrangeHRM/p_Forgot your password'))

WebUI.waitForPageLoad(0)

WebUI.setText(findTestObject('OrangeHRM-ResetPassword/Page_OrangeHRM/input_Username_username'), userName)

WebUI.click(findTestObject('OrangeHRM-ResetPassword/Page_OrangeHRM/button_Reset Password'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0)

'OrangHRM latest version allow enter any username in reset password eventhough username not exist'
WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-ResetPassword/Page_OrangeHRM/h6_Reset Password link sent successfully'), 
    0)

WebUI.closeBrowser()

