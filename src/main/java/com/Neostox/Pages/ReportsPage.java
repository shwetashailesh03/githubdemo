package com.Neostox.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Neostox.Base.BasePage;

public class ReportsPage extends BasePage{
	
   WebDriver driver;
	
	public ReportsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//td[contains(text(),'Margin Used')])[1]")
	public WebElement labelMarginUsed;
	
	@FindBy(xpath="//div[@id='reportsdropdown']")
	public WebElement ReportsDropdown;
		
	
	@FindBy(xpath="//a[@id='lnk_userdashboard']")
	public WebElement ButtonDashboard ;
	
	
	@FindBy(xpath="(//td[contains(text(),'Running Trades')])[1]")
	public WebElement labelRunningTrades;
	
	@FindBy(xpath="(//td[contains(text(),'PendingOrders')])[1]")
	public WebElement labelPendingOrders;
	
	@FindBy(xpath="//td[text()='Completed Trades']")
	public WebElement labelCompletedTrades;

}
