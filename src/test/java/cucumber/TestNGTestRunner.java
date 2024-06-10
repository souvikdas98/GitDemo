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
		System.out.println("postjira4");
		System.out.println("postjira5");
		System.out.println("postjira6");
		System.out.println("postjira7");
		System.out.println("postjira8");
		System.out.println("postjira9");
		
		
		
		
		
		
		
	}
	
	public void QuickPrint()
	{
		System.out.println("quick prinitng machine");
	}
	
	public void IOS()
	{
		System.out.println("quick prinitng machine");
	}
	
	public void Android()
	{
		System.out.println("quick prinitng machine");
	}
	public void Symbian()
	{
		System.out.println("quick prinitng machine");
	}
}
