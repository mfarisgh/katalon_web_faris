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

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.CentralVars

public class PropFileMgmt {

	public static String getPropertyValue(String propName) {

		String propValue = "";
		Properties properties = new Properties();
		try {
			InputStream inputStream = Files.newInputStream(Paths.get(CentralVars.ProjectPath + "/Include/config/local.properties"));
			properties.load(inputStream);

			propValue = properties.getProperty(propName);

			propValue = resolveEnvVars(propValue);

			//println(propValue)
		} catch (Exception e) {

			println("Exception e = " + e.getMessage());
		}

		return propValue;
	}

	/*
	 * Returns input string with environment variable references expanded, e.g. $SOME_VAR or ${SOME_VAR}
	 */
	public static String resolveEnvVars(String input) {
		if (null == input) {
			return null;
		}

		String regex = ~/\$\{(\w+)\}|\$(\w+)/

		// match ${ENV_VAR_NAME} or $ENV_VAR_NAME
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input); // get a matcher object
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			String envVarName = null == m.group(1) ? m.group(2) : m.group(1);

			String envVarValue = System.getenv(envVarName);

			m.appendReplacement(sb, null == envVarValue ? "" : envVarValue);
		}
		m.appendTail(sb);
		return sb.toString();
	}
}