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
CustomKeywords.'common.navigateMenu.navigateJobCategoriesMenu'()

WebUI.waitForPageLoad(0)

'Parameterized jobCategoryName to select based on specified job category'
WebUI.click(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/button_JobCategory_Delete_oxd-icon-button oxd-table-cell-action-space', 
        [('jobCategoryName') : jobCategoryName]))

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/button_JobCategory_Confirm_Yes, Delete'))

WebUI.verifyElementPresent(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/p_JobCategory_Prompt_Successfully Deleted'), 
    0)

WebUI.verifyElementText(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/p_JobCategory_Prompt_Successfully Deleted'), 
    GlobalVariable.promptDeleteSuccess)

WebUI.waitForPageLoad(0)

'Verify whether table no longer contains deleted job category'
WebUI.verifyElementNotPresent(findTestObject('OrangeHRM-DeleteJobCategory/Page_OrangeHRM/div_JobCategory_Name_List', [('jobCategoryName') : jobCategoryName]), 
    0)

WebUI.closeBrowser()

