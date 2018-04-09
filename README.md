# Topic Service

The topic service manages anything having to do with topics that a trainer wants to do.  It handles requests from the front-end using controllers, performs business logic to convert the requests in the java bean using services, and updates/queries the database using repositories.  Beans include Batch, Subtopic, SubtopicName, SubtopicStatus, SubtopicStatus, SubtopicType, TopicName, and TopicWeek.  Each bean represents a table in the Topic Service database.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java JDK 1.8
Spring Tool Suite (STS)

### Installing

Download OJDBC8.jar if you don't have it.
http://www.oracle.com/technetwork/database/features/jdbc/jdbc-ucp-122-3110062.html

Run maven install goal
Change Z:\Program Files\OJDBC\ojdbc8.jar to location of your jar. 
Don't move it after running!
mvn install:install-file -Dfile="Z:\Program Files\OJDBC\ojdbc8.jar" -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar

Either:
- Download the ZIP for the repo and unzip it
- Clone the repo
Import the existing Maven project in STS
Run it as a Spring Boot App

## Running the tests

There are none :)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Trevor Fortner** - *Code cleanup* - [trevorfortner](https://github.com/trevorfortner)
* **Kevin Green** - *Code cleanup* - [kevinsgreen](https://github.com/kevinsgreen)
* **Pooja Suresh** - *Code cleanup* - [ps763](https://github.com/ps763)
* **Nicole Nguyen** - *Code cleanup* - [nknguy](https://github.com/nknguy)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
