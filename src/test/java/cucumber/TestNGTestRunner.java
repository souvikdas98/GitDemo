package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber -> TestNG runner , junit runner.
@CucumberOptions(features = "src\\test\\java\\cucumber", glue="rahulshettyacademy.stepDefinations",
monochrome=true,tags= "@Regression", plugin= {"html:target\\cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	public void print()
	{
		System.out.println("postjira");
		System.out.println("postjira2");
		System.out.println("postjira3");
		
		
		
		
		
		
		
	}
}
