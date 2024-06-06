package rahulshettyacademy.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.AbstractComponents.AbstractComponent;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.landingPage;
@Test(retryAnalyzer=Retry.class)
public class submitOrderTest extends BaseTest{
	//String productName = "ZARA COAT 3";
		@Test(dataProvider="getData", groups= {"Purchase"})
		public void submitOrder(HashMap <String, String> input) throws IOException, InterruptedException{
		ProductCatalogue productCatalogue = LandingPage.loginApplication(input.get("email"), input.get("password"));
		//AbstractComponent abstractComponent = new AbstractComponent(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		Thread.sleep(5000);
		CartPage cartPage = productCatalogue.gotToCartPage();
		cartPage.getCartProducts();
		cartPage.matchWithCartProducts(input.get("productName"));
		Boolean match = cartPage.matchWithCartProducts(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOut();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.verifyOrder();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		confirmationPage.getOrderID();	
//		ProductCatalogue productCatalogue = LandingPage.loginApplication("ssssdddd@xyz.com", "ssssdddd@xyz.com");
//		OrdersPage ordersPage = productCatalogue.gotToOrdersPage();
//		Assert.assertTrue(ordersPage.verifyOrderDisplayed(productName));
		
	}
		
		@Test(dependsOnMethods= {"submitOrder"})
		
		public void OrderHistoryTest() throws InterruptedException
		{
			String productName = "ZARA COAT 3";
			ProductCatalogue productCatalogue = LandingPage.loginApplication("ssssdddd@xyz.com", "ssssdddd@xyz.com");
			OrdersPage ordersPage = productCatalogue.gotToOrdersPage();
			Assert.assertTrue(ordersPage.verifyOrderDisplayed(productName));
			
		}
		
		
		
		@DataProvider
		public Object[][] getData() throws IOException
		{
			
			List<HashMap<String, String>> data = getJsonDataToMap("C:\\Users\\souvi\\eclipse-workspace\\SeleniumFrameWorkDesign\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
			return new Object [][] {{data.get(0)}, {data.get(1)}};
			
//		 	HashMap<String,String> map = new HashMap<String,String>();
//			map.put("email", "ssssdddd@xyz.com");
//			map.put("password", "ssssdddd@xyz.com");
//			map.put("productName", "ZARA COAT 3");
//			
//			HashMap<String,String> map1 = new HashMap<String,String>();
//			map1.put("email", "ssssdddd@xyz.com");
//			map1.put("password", "ssssdddd@xyz.com");
//			map1.put("productName", "ADIDAS ORIGINAL");
			
		}
		// Maven commands
		// mvn test -PRegression -> to run the testng.xml in command prompt.
		// mvn test -PRegression -Dbrowser=firefox -> to select firefox browser in run time dynamically
}
