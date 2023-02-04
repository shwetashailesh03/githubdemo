package com.Neostox.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Neostox.Base.BasePage;
import com.Neostox.Utilities.CommonActions;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@aria-label='mobilenumber']")
	private WebElement textboxMobileNumber;
	
	@FindBy(id="lnk_signup1")
	private WebElement buttonSignUp;
	
	@FindBy(id="txt_accesspin")
	private WebElement textboxPin;
	
	@FindBy(id="lnk_submitaccesspin")
	private WebElement buttonSubmit;
	
	@FindBy(id="lbl_username")
	private WebElement labelUserName;
	
	@FindBy(xpath="//a[text()='OK'  and @class='btn btn-sm neobutton']")
	private WebElement buttonOk;
	
	public void Login() {
		CommonActions commonaction = new CommonActions();
		commonaction.enters_data("9604154175", textboxMobileNumber);
		commonaction.click_on_Element(buttonSignUp);
		
		commonaction.enters_data("2812" , textboxPin);
		commonaction.click_on_Element(buttonSubmit);
		
		if (buttonOk.isDisplayed()) {
			commonaction.click_on_Element(buttonOk);
		}
		
		
	}
	
	public String getTextofUser() {
		return labelUserName.getText();
	}
}
