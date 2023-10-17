# VisionVault

VisionVault is a web-based application designed to cater to the needs of photo industry professionals, facilitating
secure, efficient management and delivery of their work. The application's front end is built with React: a JavaScript
library well-known for its flexibility and efficiency in building interactive user interfaces.
The application's back end uses Java and Spring Boot framework. The use of Spring Boot provides many benefits: it makes
the application easy to set up, improve, scale, and maintain because of the extensive set of various libraries and tools
developed by the Java/Spring Boot community over the years.
Postgres database system was chosen for the project. Postgres offers a wide range of tools for storing and managing
extensive data sets with powerful security features, making it an ideal choice for VisionVault.
The application uses REST API for the communication between the front-end and back-end because of its simplicity,
scalability, and reliability.

# Setup

Follow the steps below to set up and run VisionVault on your local machine for development and maintenance purposes:

1. Get the Project
   Clone the repository using Git or extract the project from the provided zip file into your desired directory.

2. Set Up the Database
   Open the application.properties file found in the src/main/resources directory and update the following fields with
   your Postgres database details:

spring.datasource.url=<your-database-url>
spring.datasource.username=<your-database-username>
spring.datasource.password=<your-database-password>

3. Install npm and mvn
   You need npm (Node Package Manager) for the front-end and Maven (mvn) for the back-end. If you don't have these
   installed, you can do it with Homebrew by running:
   brew install npm mvn


4. Install Front-End Dependencies
   Navigate to the root of the project folder and install the necessary Node.js dependencies for the front-end by
   running:
   npm i ./src/main/UI/

5. Build the Project
   Still from the root of the project folder, build the project with Maven by running:
   mvn package

6. Start the Server
   Start the Spring Boot server by running:
   mvn spring-boot:run

7. Start the Client
   Finally, navigate to the front-end directory and start the React client by running:
   cd ./src/main/UI/
   npm run start

Now VisionVault should be up and running on your local machine. Please ensure the server and client are running for the
application to function correctly. Repeat the build and start steps as necessary for any modifications or updates.
 