# Serenity + Cucumber-JVM Study

This is a maven project that includes two pom files:
* pom.xml - main pom used for CI at check-in time; builds test-jar
* pomIT.xml - test runner pom; scans test-jar and launches the tests

This requires a two step build process
* mvn clean install
* mvn -f pomIT.xml verify
