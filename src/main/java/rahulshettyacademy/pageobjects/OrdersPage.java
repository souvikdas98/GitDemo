package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	List<WebElement> orderProducts;
	
	public Boolean verifyOrderDisplayed(String productName)
	{
	Boolean match = orderProducts.stream().anyMatch(orderProduct -> orderProduct.getText().equalsIgnoreCase(productName));
	return match;
	
	}
	
	}
