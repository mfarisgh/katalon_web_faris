<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT LOGO -->
<br />
<div align="center">

<h3 align="center">Katalon (Web Testing) + Jira</h3>

  <p align="center">
    by M. Faris
    <br />
    <a href="https://github.com/mfarisgh/katalon_web_faris/issues"><strong>Report Issues »</strong></a>
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#test-scenarios">Test Scenarios</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#running-the-automation-tests">Running the Automation Tests</a></li>
        <li><a href="#running-the-automation-tests-using-ci">Running the Automation Tests using CI</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is a POC Groovy/Java project for Automation Testing using Katalon to test OrangeHRM website. 
The goal of this project is to demonstrate how an Automation Testing is done using various combination of tools/frameworks. 
Of course this project is not limited to its current conditions. 
You may fork it and customize it further depending on your needs.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With

* Katalon Studio v8 (then v9 for Jira integration)
* [Unofficial Jira Client 0.5](https://github.com/bobcarroll/jira-client)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Test Scenarios

* OrangeHRM Login (Positive & negative scenarios)
* OrangeHRM Password Reset (Positive & negative scenarios)
* OrangeHRM Username Search (Positive & negative scenarios)
* OrangeHRM Add New User Account (Positive & negative scenarios)
* OrangeHRM Delete User Account (Positive & negative scenarios)
* OrangeHRM Add New Job Title (Positive & negative scenarios)
* OrangeHRM Delete Job Title (Positive & negative scenarios)
* OrangeHRM Add Pay Grade (Positive & negative scenarios)
* OrangeHRM Add Currency (Positive & negative scenarios)
* OrangeHRM Delete Currency (Positive & negative scenarios)
* OrangeHRM Edit Currency (Positive & negative scenarios)
* OrangeHRM Add Employment Status (Positive & negative scenarios)
* OrangeHRM Delete Employment Status (Positive & negative scenarios)
* OrangeHRM Add Job Category (Positive & negative scenarios)
* OrangeHRM Delete Job Category (Positive & negative scenarios)
* OrangeHRM Add New Skill (Positive & negative scenarios)
* OrangeHRM Delete Skill (Positive & negative scenarios)
* OrangeHRM Edit Skill (Positive & negative scenarios)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

The following are the instructions on setting up your project locally.
To get a local copy up and running, follow these simple steps.

### Prerequisites

The following prerequisites that you will need to get started:

1. This repo of course! You may download it as a zip file or "git clone" it to your computer.
2. Installed Katalon Studio.
3. You're good to go! :)


### Running the Automation Tests

1. Ensure that you have extracted or git-cloned the project folder into your local computer.
2. Open the project folder in Katalon Studio.
3. [Optional] If you want to utilize the Jira integration, look for `local.properties` in `Include/config`. Configure it as follows:
   
   ```sh
     jira.enabled=  # true or false
     jira.url=  # your Jira URL. Do not forget the ending slash! You may leave it blank.
     jira.username=  #  your Jira username (email address). You may leave it blank.
     jira.token=  # your Jira user token. You may leave it blank.
     jira.project=  # your Jira project code. e.g. STC. You may leave it blank.
   ```
   
4. Choose and run any of the Test Cases or Test Suites in `Test Cases` or `Test Suites` folder.
5. Change profile/environment to `DemoLive` to be able to use all the variables/parameters specified in Test Cases.


### Running the Automation Tests using CI

* Coming soon ...

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

M. Faris - [Facebook](https://fb.me/its.me.eff) - mfaris.official@gmail.com

GitHub : [mfarisgh](https://github.com/mfarisgh)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgements

* [Katalon Docs](https://docs.katalon.com/katalon-studio/create-test-cases/test-fixtures-and-test-listeners-test-hooks-in-katalon-studio)
* [Lucas Wolfgramm (Katalon Community)](https://forum.katalon.com/t/how-can-i-add-action-when-test-fails/84239/5)
* [Tim Lewis (Stack Overflow)](https://stackoverflow.com/questions/2263929/regarding-application-properties-file-and-environment-variable)
* [Ganesh Hegde (BrowserStack)](https://www.browserstack.com/guide/how-to-integrate-jira-with-selenium)
* [Henrik René Høegh (GitHub)](https://github.com/bobcarroll/jira-client/issues/52)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
