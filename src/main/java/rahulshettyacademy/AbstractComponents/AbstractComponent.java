package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement ordersHeader;
	//button[@routerlink='/dashboard/myorders']
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	
	}
	
	public CartPage gotToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrdersPage gotToOrdersPage()
	{
		ordersHeader.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}

}
