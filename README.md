To run this project:
Run command mvn clean test

Before running,change the driver_location in config.properties to point to your local chromedriver location

The approach for the framework:
The SecurePayTest.feature file follows BDD method and contains the acceptance criteria in understandable format.
The step definitions for the SecurePayTest.feature file are provided in the "stepDefinition" java package.
The pageRepository package contains methods involved in different pages like Google Search page,SecurePay Home page and Contact Us page.
config.properties contains the config required to run the tests.