package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.landingPage;

public class BaseTest {
	
	public WebDriver driver;
	public landingPage LandingPage;
	
	public WebDriver initializeDriver() throws IOException
	{	
		
		//Properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
//		prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
	
		ChromeOptions options = new ChromeOptions(); // for headless operations
		
		WebDriverManager.chromedriver().setup(); 
		
		if(browserName.contains("headless"))
		{
		options.addArguments("headless");
		}
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900)); // full screen run
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\souvi\\Downloads\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
//			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//Firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\souvi\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			//Edge
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//Read JSON to String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//String to HashMap Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\souvi\\eclipse-workspace\\SeleniumFrameWorkDesign\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return "C:\\Users\\souvi\\eclipse-workspace\\SeleniumFrameWorkDesign\\reports\\" + testCaseName + ".png";
		//return file;
	}
	
		@BeforeTest(alwaysRun = true)
		public landingPage lunchApplication() throws IOException
		{	
			driver = initializeDriver();
			LandingPage =  new landingPage(driver);
			LandingPage.goTo();
			return LandingPage;
		}
		
		@AfterTest(alwaysRun = true)
		public void tearDown()
		{
			driver.close();
		}

}
