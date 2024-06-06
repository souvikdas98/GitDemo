package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber -> TestNG runner , junit runner.
@CucumberOptions(features = "src\\test\\java\\cucumber", glue="rahulshettyacademy.stepDefinations",
monochrome=true,tags= "@Regression", plugin= {"html:target\\cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
}
