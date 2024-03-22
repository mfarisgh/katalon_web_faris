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
5. [Jenkins](https://www.jenkins.io/doc/book/installing/linux/) or [CircleCI](https://circleci.com/), if you intend to use the project with CI (I've only tested these two, you may experiment with others at your own risk). [Get to know more about CI.](https://www.techtarget.com/searchsoftwarequality/definition/continuous-integration)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

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
6. If you use Jira and enabled Jira in `local.properties`, all the failed Test Cases will be recorded as a Bug in your Jira Backlog.

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
4. You can refer to the sample `jenkins_pipeline_katalon.txt` to assign respective values such as the directory of KRE, project folder, etc. Copy the contents (in the txt file) to your Jenkins job settings -> Pipeline (Pipeline script).
5. If your first time build is failed, consider moving/copying the KRE folder into the Jenkins workspace folder.
   ```sh
   sudo cp -r /home/<your OS username>/kre /var/lib/jenkins/workspace/<name of job>/kre
   sudo chmod -R 777 /var/lib/jenkins/workspace/<name of job>/kre
   ```

*Side note: I have tried running Jenkins in 1GB RAM and 1 core CPU Linux virtual machine using VirtualBox, it works!*
*Although AWS EC2 Free Tier has almost the same specs (t2.micro with 1GB RAM, 1 core CPU, Linux OS), it doesn't work! No need to waste your time. It freezes on my Free Tier EC2 instances.*
*Just get a higher paid t2 instances to be able to run Jenkins properly.*
*[Explanation 1](https://stackoverflow.com/questions/57991172/aws-ec2-t2-micro-unlimited-jenkins-maven-very-slow-build-hangs), [Explanation 2](https://stackoverflow.com/questions/71038504/when-jenkins-job-in-running-ip-gets-frozen-and-inaccessible), [Explanation 3](https://serverfault.com/questions/932544/ec2-instance-freezes)*

#### B. CircleCI (Not for the faint of heart!)

1. CircleCI is intended to be used with projects that is already committed to your own GitHub repository. The behaviour is not the same as Jenkins. With Jenkins, you can checkout any compatible public repositories.
2. To use CircleCI, you may fork my repository to your own GitHub repository. Proceed with any changes as desired in your own repository.
3. Ensure that you have [linked your GitHub account to your CircleCI account](https://circleci.com/docs/getting-started/). You will be able to see your GitHub projects in CircleCI and follow it.
4. Since the project has already included the `.circleci/config.yml` file, you should be able to [configure the pipeline](https://circleci.com/docs/config-editor/) straight away without the need to go through the first time configuration wizard. Otherwise, click on where it says "Skip ... bla3". If there is a button where it says "Use existing config", click it. Then, click "Start building".
5. You will be presented with an in-app configuration editor. You may remove the following line of code to be able to run the pipeline using CircleCI's provided runner, click "Save and Run". If it fails, proceed to step 9. Otherwise, if you want to set-up your own runner using your Linux server, proceed to step 6.
   ```sh
   resource_class: mfarisgh/faris-self-hosted
   ```
6. If you want to self-host a runner using your Linux server without the usage of Docker images, ensure that OpenJDK, a browser and Katalon Runtime Engine (KRE) have been installed. Follow step 2 in A. Jenkins.
7. [Set-up your own runner (Part 1).](https://circleci.com/docs/local-cli/)
8. [Set-up your own runner (Part 2).](https://circleci.com/docs/install-machine-runner-3-on-linux/)
9. [Set environment variables in your project.](https://circleci.com/docs/set-environment-variable/#set-an-environment-variable-in-a-project) Put the following environment variables and respective values.
    ```sh
    <Name> = <Value>
    KRE_HOME = '<your Katalon Runtime Engine folder location>'
    PROJECT_PATH = '/var/lib/circleci-runner/workdir/OrangeFaris.prj'
    TS_PATH='Test Suites/AutomationSuite'
    BROWSER_TYPE='Chrome (headless)' #it is better to use headless as we will run it on a non-GUI Linux server
    EXEC_PROFILE='DemoLive'
    KAT_API_KEY='<your Katalon API key>' #refer to this website on how to get them https://docs-dev.katalon.com/katalon-platform/administer/settings/katalon-api-keys-in-katalon-studio#gsc.tab=0
    JIRA_ENABLED='true' #true or false
    JIRA_URL='<your Jira URL with ending slash>' #You may leave it blank if false
    JIRA_USERNAME='<your Jira email address>' #You may leave it blank if false
    JIRA_TOKEN='<your Jira Token>' #You may leave it blank if false
    JIRA_PROJ='<your Jira project code>' #You may leave it blank if false
    ```
10. If you use self-hosted runner. In your CircleCI project, select branch 'master' and click "Edit Config". Replace the following line of code with your resource class name for your self-hosted runner.
    ```sh
    resource_class: #your resource class name for your self-hosted runner
    ```
11. Click "Save and Run" if you are from the in-app configuration editor. Otherwise, click "Trigger Pipeline" if you are in the project page.
12. Keep in mind that every changes in your GitHub repo automatically triggers the pipeline. So, if you use CircleCI and constantly making changes to your GitHub repo. You will need to monitor your CircleCI project's pipeline to ensure there are no unwanted running jobs. Especially if you are using self-hosted runner, where if your runner is shut down and you are still making changes to your GitHub repo, you will need to manually cancel the running job in CircleCI project's pipeline.

*Side note: Yeah, I know the steps are confusing/cumbersome at first. Just use Jenkins, it will be a bit easier for starters.*
*Like Jenkins, the CircleCI self-hosted runner works on a 1GB RAM and 1 core CPU Linux virtual machine using VirtualBox but not in AWS EC2 Free Tier instances despite the almost same specs.*

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
