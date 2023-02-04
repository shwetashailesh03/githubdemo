package com.Neostox.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Neostox.Base.BasePage;

public final class ScreenshotUtil extends BasePage{
	
	static WebDriver driver;
	
	public static String getBase64img(WebDriver driver) {
		ScreenshotUtil.driver = driver;
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}

}
