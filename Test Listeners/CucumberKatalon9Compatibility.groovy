import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import com.kms.katalon.core.cucumber.keyword.internal.CucumberGlueGenerator

import common.CentralVars as CentralVars
import common.DateTimeMgmt as DateTimeMgmt
import common.JiraMgmt as JiraMgmt
import common.PropFileMgmt as PropFileMgmt

class CucumberKatalon9Compatibility {

	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {

		CucumberGlueGenerator.addDefaultPackages();

		println testCaseContext.getTestCaseId();
		println testCaseContext.getTestCaseVariables();
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {

		println(testCaseContext.getTestCaseId());
		println(testCaseContext.getTestCaseStatus());
		println(testCaseContext.getMessage());

		String getPropJiraEnabledStatus = PropFileMgmt.getPropertyValue(CentralVars.PropNameJiraEnabled);
		
		println("Is Jira enabled = " + getPropJiraEnabledStatus)
		
		if (testCaseContext.getTestCaseStatus().equalsIgnoreCase("FAILED") && getPropJiraEnabledStatus.equalsIgnoreCase("true")) {
			try {
				StringBuilder screenshotSb = new StringBuilder();
				screenshotSb.append(CentralVars.ProjectPath);
				screenshotSb.append('/img/');
				screenshotSb.append(DateTimeMgmt.getTodayDateTimeStr(CentralVars.DateTimeFilePattern));
				screenshotSb.append('_');
				screenshotSb.append(testCaseContext.getTestCaseId());
				screenshotSb.append('.png');

				String screenshotPath = screenshotSb.toString();

				WebUI.takeScreenshot(screenshotPath)

				List<String> screenshotPathList = new ArrayList()

				screenshotPathList.add(screenshotPath)

				JiraMgmt JiraServiceProvider = new JiraMgmt(PropFileMgmt.getPropertyValue(CentralVars.PropNameJiraUrl), PropFileMgmt.getPropertyValue(
						CentralVars.PropNameJiraUsername), PropFileMgmt.getPropertyValue(CentralVars.PropNameJiraToken), PropFileMgmt.getPropertyValue(
						CentralVars.PropNameJiraProject))

				StringBuilder issueDescSb = new StringBuilder();
				issueDescSb.append('Failure Reason from Automation Testing\n\n');
				issueDescSb.append(testCaseContext.getMessage());
				issueDescSb.append('\n');

				String issueDescription = issueDescSb.toString();

				StringBuilder issueSummarySb = new StringBuilder();
				issueSummarySb.append(UUID.randomUUID());
				issueSummarySb.append('-');
				issueSummarySb.append(testCaseContext.getTestCaseId());
				issueSummarySb.append(' Failed in Automation Testing');

				String issueSummary = issueSummarySb.toString()

				println('issueSummary = ' + issueSummary)

				println('issueDescription = ' + issueDescription)

				JiraServiceProvider.createJiraIssue('Bug', issueSummary, issueDescription, screenshotPathList)
			}
			catch (Exception e) {
				println('Exception e = ' + e.getMessage())
			}
		}
	}
}