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
You may clone it to your own environment and customize it further depending on your needs.

* [Get to know about Automation Testing](https://www.techtarget.com/searchsoftwarequality/definition/automated-software-testing)
* [Get to know Katalon](https://katalon.com/)

OrangeHRM is an open-source human resource management (HRM) software platform. It provides a comprehensive set of HR functionalities to businesses of all sizes, including features for personnel information management, attendance tracking, leave management, performance evaluation, and other HR-related tasks.

* [Get to know OrangeHRM](https://www.orangehrm.com/)
* [OrangeHRM Live Demo site](https://opensource-demo.orangehrmlive.com/)

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
2. Installed [Katalon Studio.](https://katalon.com/download)

Optional

3. [A Jira Cloud account.](https://www.atlassian.com/try/cloud/signup?bundle=jira-software&edition=free&skipBundles=true)
4. A Linux server (for usage with CI). I recommend using [VirtualBox](https://www.instructables.com/How-to-install-Linux-on-your-Windows/) for starters. You can also checkout on [AWS EC2 instances](https://aws.amazon.com/ec2/) for running CI on cloud server (you need credit card to register for them).
5. [Jenkins](https://www.jenkins.io/doc/book/installing/linux/), if you intend to use the project with CI (I've only tested this, you may experiment with others at your own risk). [Get to know more about CI.](https://www.techtarget.com/searchsoftwarequality/definition/continuous-integration)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Running the Automation Tests

1. Ensure that you have extracted or git-cloned the project folder into your local computer.
2. Open the project folder in Katalon Studio.
3. [Optional] If you want to utilize the Jira integration, look for `local.properties` in `Include/config`. Configure it as follows:
   
   ```sh
   jira.enabled=  # true or false
   jira.url=  # your Jira URL. Do not forget the ending slash! You may leave it blank if false.
   jira.username=  #  your Jira username (email address). You may leave it blank if false.
   jira.token=  # your Jira user token. You may leave it blank if false. Refer here on how to get them https://support.atlassian.com/atlassian-account/docs/manage-api-tokens-for-your-atlassian-account/
   jira.project=  # your Jira project code. e.g. STC. You may leave it blank if false.
   ```

4. Update WebDrivers: Tools -> Update WebDrivers -> Your preferred browser.
5. Choose and open by double-clicking any of the Test Cases or Test Suites in `Test Cases` or `Test Suites` folder.
6. Change profile/environment to `DemoLive` to be able to use all the variables/parameters specified in Test Cases. It is located on the top right, named "default".
7. Click the Play button on the top right.
8. If you use Jira and enabled Jira in `local.properties`, all the failed Test Cases will be recorded as a Bug in your Jira Backlog.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Running the Automation Tests using CI

#### A. Jenkins

1. I will be referring to the use case of Jenkins in a Linux server where the [job will run as a pipeline](https://www.jenkins.io/doc/book/pipeline/getting-started/) and not involving any Docker images.
2. If you are not using/stating any Docker images in your pipeline, your Linux server (where Jenkins was installed or where the Jenkins job will be running) must have the following installed:
   
   i. OpenJDK
   
   ```sh
   sudo apt install openjdk-17-jdk
   ```
   ii. Browser (I'll take Chrome as an example)
   
   ```sh
   wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
   sudo apt --fix-broken install ./google-chrome-stable_current_amd64.deb
   google-chrome --version
   ```
   iii. Katalon Runtime Engine (KRE)
   
   ```sh
   wget https://download.katalon.com/9.3.2/Katalon_Studio_Engine_Linux_64-9.3.2.tar.gz
   sudo tar xvzf ./Katalon_Studio_Engine_Linux_64-9.3.2.tar.gz
   sudo mv ./Katalon_Studio_Engine_Linux_64-9.3.2 ./kre
   sudo chmod -R 777 ./kre
   ```
3. You can refer to the sample `jenkins_pipeline_katalon.txt` to assign respective values such as the directory of KRE, project folder, etc. Copy the contents (in the txt file) to your Jenkins job settings -> Pipeline (Pipeline script).
4. If your first time build is failed, consider moving/copying the KRE folder into the Jenkins workspace folder.
   ```sh
   sudo cp -r /home/<your OS username>/kre /var/lib/jenkins/workspace/<name of job>/kre
   sudo chmod -R 777 /var/lib/jenkins/workspace/<name of job>/kre
   ```

*Side note: I have tried running Jenkins in 1GB RAM and 1 core CPU Linux virtual machine using VirtualBox, it works!*
*Although AWS EC2 Free Tier has almost the same specs (t2.micro with 1GB RAM, 1 core CPU, Linux OS), it doesn't work! No need to waste your time. It freezes on my Free Tier EC2 instances.*
*Just get a higher paid t2 instances to be able to run Jenkins properly.*
*[Explanation 1](https://stackoverflow.com/questions/57991172/aws-ec2-t2-micro-unlimited-jenkins-maven-very-slow-build-hangs), [Explanation 2](https://stackoverflow.com/questions/71038504/when-jenkins-job-in-running-ip-gets-frozen-and-inaccessible), [Explanation 3](https://serverfault.com/questions/932544/ec2-instance-freezes)*

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

M. Faris - [Facebook](https://fb.me/its.me.eff) - mfaris.official@gmail.com

GitHub : [mfarisgh](https://github.com/mfarisgh)

GitLab : [mfarisgl](https://gitlab.com/mfarisgl)

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
