Coverage: 74%
# Inventory Management System

Inventory-management system capable of tracking & manipulating customer’s information, orders details and item data. Developed using mysql databases, Java as the programming language with JUnit and Mockito used for testing and maven as the build tool to package the application.

## Getting Started

Fork the repo and open as a maven project in your IDE or run from command line (see deployment).

### Prerequisites

To make changes, run or develope over this project you will need eclispe IDE and MYSQL.
Eclipse: https://www.eclipse.org/downloads/packages/installer#:~:text=5%20Steps%20to%20Install%20Eclipse%201%20Download%20the,available%20to%20Eclipse%20users.%20...%20More%20items...%20

MYSQL:
https://www.mysql.com/downloads/
once installed and set up, you will need to have a database called ims inorder for the application to work.

### Installing

To get a developement environment running after forking the repo:

1) Clone onto your PC and open in Eclipse (as maven project).
2) Run project as Java application to use the application.
3) Alternatively see deployment for details on how to run from command line.

## Running the tests

To run the automated tests:

1) Open project using eclipse IDE
2) Navigate to src\test\java\com\qa\ims
3) Open up persistance or controllers
4) Persistance contains the DAO class tests.
5) Controllers contains the mockito tests for the crud controllers of each entity.
6) open the DAO/ controller class you'd like to test.
7) Right click on the workspace and select run-> as Junit test.
8) You can also run the whole project as a JUnit test by doin step 7 but right clicking on the IMS-Starter folder instead of the worksapce.

### Unit Tests 

Persistance - Tests the DAO class and the functions they contain and ensure they output as expected for the project.
Controllers - Tests the crud ontroller classes of the project to see if the handle the mokced inputs in the appropriate way.


## Deployment

Fork repo, from the command line change directory to ->IMS-Starter\target and run the .jar file using: java -jar ims-0.0.1-jar-with-dependencies.jar
Use mvn clean package in IMS-Starter to build out application again.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Sangiv Giovanni Karunakaran** - *The Projcect* - https://github.com/Sangiv

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Nick for the support and for troubleshooting some of the testing with me
* Jordan for showing me fancy shortcuts and some slick lines of code
