# How to create a new Java project in VSC
1. Go to Visual Studio Code
2. Start a new file
3. Select New Java Project
4. Select Maven 
5. Select maven-archetype-quickstart
6. Selection version 1.4
7. The group id should be named "com.example"
8. Enter the project name all lowercase (example: api-tutorial)
9. Select folder (Projects)
10. Answer questions
11. Open the project

# Project Purpose
In this project, we are going to call an external API (Application Programming Interface). APIs are from another person's code, and we call the API and return the results in the main program. 

In order to run the application, you need 

* an application key from https://home.openweathermap.org/
* sign up to Postman for testing https://web.postman.co/

The program will do 3 steps:

1. call the weather API
2. Parse JSON result
3. Extract and print weather.description