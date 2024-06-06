package rahulshettyacademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.AbstractComponents.AbstractComponent;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.landingPage;

public class ErrorValidations extends BaseTest{

		@Test(groups= {"ErrorHandling"})
		public void loginErrorValidation() throws IOException, InterruptedException{
		LandingPage.loginApplication("ssssdddd@xyz.com", "ssssdddd.com");
		Assert.assertEquals("Incorrect email or password.", LandingPage.getErrorMessage());
	}
		
		@Test(retryAnalyzer=Retry.class)
		public void productErrorValidation() throws IOException, InterruptedException{
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = LandingPage.loginApplication("ssssdddd@xyz.com", "ssssdddd@xyz.com");
		//AbstractComponent abstractComponent = new AbstractComponent(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		Thread.sleep(5000);
		CartPage cartPage = productCatalogue.gotToCartPage();
		//cartPage.getCartProducts();
		//cartPage.matchWithCartProducts(productName);
		Boolean match = cartPage.matchWithCartProducts(productName);
		Assert.assertTrue(match);	
	}
}
