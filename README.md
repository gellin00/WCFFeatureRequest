# Java/Web Developer Project
This is a project that we use for evaluating the technical skills of potential team members.

## Feature Request App
This repo contains a web application that allows a user to manage "feature requests". 

Within, you'll find two main directories, 'Backend' and 'Frontend'.

'Backend' contains a spring-boot RESTful webservice. It's configured to build an executible jar file which will launch
an embedded tomcat server and an H2 in-memory database to provide data for the application. 

'Frontend' contains a fairly simple Angular application which communicates with the above mentioned RESTful service and provides
a means for a user to interact with that data.

## Launching the application
First off you'll need to clone or download the repository to a location of your choice on a machine with maven and angular cli installed. 

### The REST webservice
Start by opening a terminal of your choice and navigating to the /WCFFEatureRequest/Backend directory at the location you cloned the repo.
You may build the application and execute the resulting jar if you like, or simply run the 'mvn spring-boot:run' command.
After which you should see spring boot load and launch the webservice. Leave this terminal open while you use the rest of the application.
You can test that the service is running successfully by
visiting http://localhost:8080/wcfFeatureRequest/api/rest/test in a web browser. 

If you would like to view the default test
data loaded by the H2 database, visit http://localhost:8080/h2-console
When prompted to login, ensure the driver class is set to 'org.h2.Driver' and the JDBC URL is 'jdbc:h2:mem:testdb'. Enter a 
user name of 'sa' and no password. Click the 'connect' button. You'll be shown the console where you may execute queries against
the data in the in-memory database.

### The Angular application
Open another terminal of your choice (leaving the first running) and navigate to /WCFFeatureRequest/Frontend/FeatureRequest.
Once there, run the 'ng serve --o' command. This will build the web application and open a browser window to 
http://localhost:4200/featureRequests

You should see a page displaying several Feature Request items. Here you can add a new feature request item, 
click any of the existing items to edit, or delete an item with the 'X' button on a given row.