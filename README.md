# swapi
I built a simple yet robust framework in Java to test a RestWebservice using swapi application and RestAssured library in IntelliJ. 
With this project, I share that framework with you.

# Website : https://swapi.co/ 

Project itself is build using Maven in IntelliJ.
# FRAMEWORK :
In the framework, the key components are:
# PROJECT CONFIGURATION: 
Keep a test environment class to maintain project configuration. 
Note: You dont need it here since you have access to only one version of swapi (The production version) but in a real life project, you would want to use the same framework to test in System Test environment, Chain test environment and say pre-production environment (or more). Thus its a good practicse to store your project variables and endpoint urls at one place for each test env to keep the framework flexible enough to work in all test enviroments and avoid hardcodig in classes (say in ST, Chain test, pre prod).
# TEST DATABASE: 
Generally, when I am working on a project, I have access to the test environment database. I create my expected results based on this test environment, which is also used by the real application under test. Since I didnt had access to swapi's database, I created a class that will parse each page data of all APIs under SWAPI and create a restful page database for me. In a real life project, I would later replace this with the actual database connection. For now, this helps me create more flexible and robust general domain functions that I will use for my testing. The form of funtion would also make it easier for me to migrate with minimum changes (if i have access to the real datbase in a project). Also it seperates my test data from script, making my fucntions really mainteable and powerful. Also in future if swapi adds, tons of other information, or udpate it for a new movies, my scripts would need no changes ;-).

# TEST EXECUTION: 
For this, 
    -> In Main: I create general purpose functions that contains generic code that I can use in multiple tests.
    -> In Test: I create all my Junit tests, that can use the above generic code and the data from test database, to create simple yet powerful tests.
    
# TEST REPORT : 
I use the inbuilt test reports options in IntelliJ to generate my log results into txt file. I do this using Run -> Edit Configuration 
-> Select "Configuraiton" at Class level (or at method level), give a name of file and location under "Logs" section. 

# VERSION CONTROL : 
I use the inbuilt function in intelliJ to add a GIT repository for version control using (VCS -.GIT.). Once done, I push the changes to remote using command line to my github repository (https://github.com/PramodKumarYadav/swapi/)
 
# Happy learning! 
With all this, you have a solid framework that you can enhance upon to add sort of tests and functions that you want to build upon for testing Swapi. Happy learning. 
