This is a simple web application implemented to perform create , read , update and delete student profile details.
I used these technologies for this web application.
Java (JEE, Spring) ,
Javascript ( AngularJS) ,
Bootstrap for styling ,
RESTful Spring Controller ,
NoSQL Database (MongoDB) ,
Maven 3.2.2 to build and package ,
JBoss AS 7 or Tomcat to deploy.

Please follow this steps to deploy the web application.

1. Clone the git repository or download the zip.

2. Extract the zip file if needed and build the project using maven ( mvn clean install -Dmaven.test.skip=true )

3. Navigate to the folder ( studentlist-master) which contains the pom.xml file and find the ROOT.war inside the target folder.

4. Now you need to add the MongoDB database details appropriately.
com.studentlist.config package >> ApplicationConfig class >> mongoTemplate() - ( https://github.com/udesh/studentlist/blob/master/src/main/java/com/studentlist/config/ApplicationConfig.java )
Add relevant details that need to access the MongoDB database.
Build and package the project and get the ROOT.war inside the target folder.

5.The web application can be deploy in jboss 7 or Tomcat as needed.

6. When deployed successfully access the web application http://localhost:8080/#/
