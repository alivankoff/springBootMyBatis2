# Rest webservice using Spring boot, Mybatis and Mysql
 
 # Intial setup
 - Install and configure mysql db locally
 - For example purpose I have created username as spring and table name as COURSE
 - Scripts directory has the sql for creating COURSE table and also some seed data
 
 ### Running the code
 
 - After cloning the repo please change in application.yml datasource username and password accordingly
 - In the project directory run ```mvn clean install```
 - Jar will be generated in the target directory, now run ```java -jar <jar path>```
 - Api's are up and running 
 
 ### Verifying
 
 - In the browser try to run ```http://localhost:9000/v1/courses```, you should be seeing the response bacl
