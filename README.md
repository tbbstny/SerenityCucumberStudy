# This page needs updated!
For now, working through issues with upgrading from 1.1.40 to 1.2.2-rc.2
Can run these maven commands to generate reports against either version for comparison:<br/>
`mvn clean install -PSerenity` <br/>
`mvn clean install -PSerenity1.1.40`

<table>
    <tr>
        <th>Use Case</th>
        <th>1.1.40</th>
        <th>1.2.2-rc.2</th>
    </tr>
    <tr>
        <td>Pending & Subsequent Feature: Within an epic, if a feature is marked as @pending, subsequent features are also being treated as pending.</td>
        <td><ul>
            <li>"Subsequent Feature Test Scenario" executed as expected, BUT steps are marked as pending.</li>
        </ul></td>
        <td><ul>
            <li>"Pending Epic" missing from Epics tab</li>
            <li>"Pending Feature should be Skipped" missing from Features tab</li>
            <li>"Subsequent Feature should Execute" missing from Features tab</li>
            <li>(Features are available on home page under "Tests"; Possibly missing from tabs due to something with having scenario descriptions)</li>
            <li>"Subsequent Feature should Execute" was NOT executed</li>
        </ul></td>
    </tr>
</table>

# Serenity + Cucumber-JVM Study
A study in Maven, Cucumber and Serenity

This demo project demonstrates:
* [Serenity @driver tag to force use of specifc browser](#driver)
* [Pending/Skipping Scenarios in Serenity Cucumber](#dontrun) (*[Outstanding](https://groups.google.com/forum/#!topic/thucydides-users/7FOewIrMWU8 "Pending/Skipping Scenarios in Serenity Cucumber")*)
* [Running Cucumber Tests in Parallel](#parallel)
* [Running Cucumber Tests from a ~~test-jar~~ Test Project](#testjar)

To run (the easy, straing forward way): <br />
`mvn clean install -PSerenity`  (using Serenity v 1.2.2-rc.2)
`mvn clean install -PSerenity1.1.40` (using Serenity v 1.1.40)


## <a name="driver"></a> Serenity @driver tag to force use of specifc browser
Serenity recognizes the @driver tag used to force Cucumber Features/Scenarios to use a specific browser: <br />
@driver:chrome, @driver:firefox, @driver:iexplorer, @driver:phantomjs


## <a name="dontrun"></a> Pending/Skipping Scenarios in Serenity Cucumber
Serenity recognizes the following tags, and should report on Cucumber Features/Scenarios without actually executing them: <br />
@ignore, @pending, @skip, @wip, @manual
v 1.1.40 - Didn't skip @ignore, @ignored; Also didn't skip code in Cucumber Step Definitions, only code in Serenity Step Libraires.
v 1.2.2-rc.2 - Handles @ignore, @ignored; Skips Cucumber Step Definitions code now too!


## <a name="parallel"></a> Running Cucumber Tests in Parallel
This project uses the `maven-failsafe-plugin` to run tests in parallel, as opposed to the sereinity.properties configuration.  The highlights:
* Need multiple test runners in order to run tests in parallel, use a standard naming convention <br />
(this project uses `*FeatureTest.java`)
* The pom files uses a regular expression to tell failsafe what runners to include:
```xml
<testrunner.prefixes></testrunner.prefixes>
<failsafe.testrunner>%regex[.*(${testrunner.prefixes})FeatureTest.class]</failsafe.testrunner>
```
  * testrunner.prefixes defaults to empty (All), but can be a piped list of test runner prefixes.
  * %regex[.*()FeatureTest.class] - Runs all test runners
  * %regex[.*(Driver)FeatureTest.class] - Runs only the *DriverFeatureTest runners <br />
  (tests @driver tag to force specific browsers)
  * %regex[.*(Driver|DoNotRunTags)FeatureTest.class] - Runs both Driver and DoNotRunTags test runners


## <a name="testjar"></a> Running Cucumber Tests from a ~~test-jar~~ Test project
From the start, I've kept acceptance tests in their own project.  For various reasons, the team initially kept this acceptance 'test code' in `src/test/java`.  This forced the issue of creating and working with a `test-jar`.  We've changed our minds, and are now following Maven's recommendations for test projects to put the code in `src\main\java`.  This has forced other issues, like needing to tell `failsafe` where to find the code, but overall has been easier to work with.  All of this is taken care of in the pom files.

This project includes two pom files:
* pom.xml   - main pom used for CI at check-in time; builds the test project jar
* pomIT.xml - test runner pom; pulls the test project jar from artifactory, unpacks it, and launches the tests

This requires a two step process to first build the test project jar, then launch the tests.
This is useful for setting up a test runner so business and testers can run on demand. <br />

1. `mvn clean install`  (pom.xml; builds the jar and in CI deploys to artifactory)
2. `mvn -f pomIT.xml verify` (pomIT.xml; launches the tests)

