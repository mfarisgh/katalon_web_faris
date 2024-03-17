package common

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
import com.kms.katalon.util.CryptoUtil

import internal.GlobalVariable

public class managePasswords {
	/**
	 * Automate encrypt passwords from plain text passwords
	 *
	 *
	 *
	 * @param pass password
	 * @return
	 */
	@Keyword(keywordObject = 'Encrypt Text Password')
	def encryptTextPassword(String pass) {
		String encryptedPass
		encryptedPass = CryptoUtil.encode(CryptoUtil.getDefault(pass))
		return encryptedPass
	}

	/**
	 * Automate decrypt passwords to plain text passwords
	 *
	 *
	 *
	 * @param pass password
	 * @return
	 */
	@Keyword(keywordObject = 'Decrypt Text Password')
	def decryptTextPassword(String encryptedPass) {
		String decryptedPass
		decryptedPass = CryptoUtil.decode(CryptoUtil.getDefault(encryptedPass))
		return decryptedPass
	}
}
