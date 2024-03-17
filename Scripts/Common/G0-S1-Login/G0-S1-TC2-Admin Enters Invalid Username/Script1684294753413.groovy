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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

WebUI.waitForPageLoad(0)

WebUI.setText(findTestObject('OrangeHRM-UsersManagement/Page_OrangeHRM/input_LoginPage_Username_username'), username)

'Use custom keyword to convert plain text passwords to encrypted text passwords'
encryptedPass = CustomKeywords.'common.managePasswords.encryptTextPassword'(GlobalVariable.passGlobal)

WebUI.setEncryptedText(findTestObject('OrangeHRM-UsersManagement/Page_OrangeHRM/input_LoginPage_Password_password'), encryptedPass)

WebUI.click(findTestObject('OrangeHRM-UsersManagement/Page_OrangeHRM/button_LoginPage_Login'))

WebUI.waitForPageLoad(0)

WebUI.verifyElementPresent(findTestObject('OrangeHRM-UsersManagement/Page_OrangeHRM/p_LoginPage_Prompt_Invalid credentials'), 
    0)

WebUI.verifyElementText(findTestObject('OrangeHRM-UsersManagement/Page_OrangeHRM/p_LoginPage_Prompt_Invalid credentials'), 
    GlobalVariable.promptInvalidCrid)

WebUI.closeBrowser()

