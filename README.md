# swapi
I built a simple yet robust framework in Java to test a RestWebservice using swapi application and RestAssured library in IntelliJ. 
With this project, I share that framework with you.

# Website : https://swapi.co/ 

Project itself is build using Maven in IntelliJ.
# FRAMEWORK :
In the framework, the key components are:
# PROJECT CONFIGURATION CLASS: 
Keep a test environment file to maintain project configuration (You dont need it here, but generally in projects, you have more than 
    one test environments and you would want your framework flexible enough to work in all of them (say in ST, Chain test, pre prod).
# TEST DATABASE CLASSS: 
Have a class to create expected datbase for all the available endpoint URLs. (In general , you would have access to the test env 
    and than I would use the same database that application uses to create my expected scripts. In this case, since I didnt had access
    to swapi database, I created a page database, using the output from actual application. This serves, two purposes, one seperates my
    test data from scripts, making my functions really flexibile and how I would bulid them if I have access to test env. Two, when I do
    have access, it will be easier to make minimum changes to my script for expected database parsing and let all asserts still work.
# COMPARE GENERAL FUNCTIONS: 
These functions contain the generic code in Main, that is used in Test to test all APIs.
# TEST REPORT : 
I use the inbuilt test reports options to generate my log results into txt files (Using Run -> Edit Configuration -> 
    Select "Configuraiton" at Class level (or at method level), give a name of file and location under "Logs" section. 
# VERSION CONTROL : 
I use the inbuilt function in intelliJ to add a GIT repository for version control using (VCS -.GIT.). Once done, 
    I push the changes to remote using command line to my github repository (https://github.com/PramodKumarYadav/swapi/)
