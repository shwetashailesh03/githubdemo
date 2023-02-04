package com.Neostox.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Neostox.Base.BasePage;
import com.Neostox.Utilities.CommonActions;

public class DashboardPage extends BasePage {
	
   WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="menu-toggle")
	public WebElement buttonExpandCollpase;
	
	@FindBy(id="home")
	public WebElement panelWatchList;
	
	@FindBy(xpath="//a[text()='Watchlist']")
	public WebElement buttonWatchlist;
	
	@FindBy(id="txt_instruments1")
	private WebElement textboxSearchInstruments;
	
	@FindBy(xpath="//ul[contains(@id,'ui-id')]")
	private WebElement panelSearchInstruments;
	
	public void select_share_from_dropdown(String share) {
		CommonActions commonActions = new CommonActions();
		commonActions.enters_data(share, textboxSearchInstruments);
		commonActions.visibilityOfelement(panelSearchInstruments);
		panelSearchInstruments.findElement(By.xpath("//a[text()='"+share+"']")).click();
		
	}
}
