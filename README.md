# AutoCamp 2022 Java Testing repo
Learning basics of automation testing

## Technologies used
- Java
- Maven
- Selenide 
- JUnit
- Assertj
- Jenkins
- Selenium grid
- Cucumber/Gherkin

## Project Configuration
- open pages
  - [JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
  - [Selenide](https://mvnrepository.com/artifact/com.codeborne/selenide)
  - [Maven - Surefire](https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html)
  - [Assertj](https://mvnrepository.com/artifact/org.assertj/assertj-core)
  - [Selenium grid](https://mvnrepository.com/artifact/org.seleniumhq.selenium.grid/selenium-grid-hub)
  - [Cucumber/Gherkin](https://mvnrepository.com/artifact/io.cucumber)
- select latest version
- go to: pom.xml file
- add dependencies
- click Maven(top right corner) -> Reload All Maven Projects
- You may want to add surefire plugin configuration:
`                   <configuration>
                        <testFailureIgnore>true</testFailureIgnore>
                        <includes>
                            <include>**/*Test.class</include>
                            <include>**/*test.class</include>
                            <include>**/*Tests.class</include>
                        </includes>
                    </configuration>`
