package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//ul/li/div/div/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//div/ul/li/button")
	WebElement checkoutEle;
	
	public List<WebElement> getCartProducts()
	{
	return cartProducts;
	
	}
	
	public Boolean matchWithCartProducts(String productName)
	{
	Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	return match;
	
	}
	
	public CheckoutPage goToCheckOut()
	{
		checkoutEle.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	}
