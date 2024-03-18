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

import java.io.File;
import java.util.List;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraMgmt {

	private JiraClient Jira;

	private String project;

	private String JiraUrl;

	public JiraMgmt(String JiraUrl, String username, String password, String project) {

		this.JiraUrl=JiraUrl;

		// create basic authentication object

		BasicCredentials creds = new BasicCredentials(username, password);

		// initialize the Jira client with the url and the credentials

		Jira = new JiraClient(JiraUrl, creds);

		this.project = project;
	}

	def createJiraIssue(String issueType, String summary, String description, List<String> attachmentPathList) {

		try {

			//Avoid Creating Duplicate Issue

			Issue.SearchResult sr = Jira.searchIssues("summary ~ \""+summary+"\"");

			if(sr.total!=0) {

				println("Same Issue Already Exists on Jira");

				return;
			}

			//Create issue

			FluentCreate fluentCreate = Jira.createIssue(project, issueType);

			fluentCreate.field(Field.SUMMARY, summary);

			fluentCreate.field(Field.DESCRIPTION, description);

			Issue newIssue = fluentCreate.execute();

			println("********************************************");

			println("New issue created in Jira with ID : " + newIssue.getKey());

			println("New issue URL is : " + JiraUrl + "browse/" + newIssue.getKey());

			println("*******************************************");

			Issue issue = Jira.getIssue(newIssue.getKey());

			if (!attachmentPathList.isEmpty()) {

				for (String attachmentPath : attachmentPathList) {

					issue.addAttachment(new File(attachmentPath));

					println("An attachment is added for issue : " + newIssue.getKey());
				}
			}
		} catch (JiraException je) {

			println("JiraException je = " + je.getMessage());
			je.printStackTrace();
		} catch (Exception e) {

			println("Exception e = " + e.getMessage());
			e.printStackTrace();
		}
	}
}
