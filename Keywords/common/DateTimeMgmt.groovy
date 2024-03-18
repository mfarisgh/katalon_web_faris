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

import internal.GlobalVariable

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeMgmt {

	static String getTodayDateTimeStr(String pattern) {

		try {

			// Get current date and time
			Date currentDate = new Date();

			// Create a SimpleDateFormat object with the specified pattern
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

			// Format the current date and time according to the pattern
			String formattedDateTime = dateFormat.format(currentDate);

			// Print the formatted date and time
			println("Formatted Date and Time: " + formattedDateTime);

			return formattedDateTime;
		} catch (Exception e) {

			println("Exception e = " + e.getMessage());

			return "";
		}
	}
}
