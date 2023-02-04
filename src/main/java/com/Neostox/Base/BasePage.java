package com.Neostox.Base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.Neostox.Constant.AppConstant;
import com.Neostox.Pages.LoginPage;
import com.Neostox.Utilities.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	private Logger logger = LoggerFactory.getLogger(BasePage.class);
	
	@BeforeClass
	public WebDriver initializeDriver() throws IOException {
		
		String browserName = PropertiesReader.getValue("browserType");
			
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("headless")) {
			WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--headless");
		    options.addArguments("window-size=1500, 800");
		    driver = new ChromeDriver(options);
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		logger.info("Initializing " + browserName + " driver");
		driver.manage().window().maximize();
		driver.get(PropertiesReader.getValue("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Login();
		
		return driver;
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		logger.info("Closing driver");
	}
	
	@AfterSuite(alwaysRun=true)
	public void openReport() {
			try {
				File reportFile = new File(AppConstant.getsparkreportPath());
				Desktop desktop = Desktop.getDesktop();
				if(reportFile.exists()) {
				desktop.open(reportFile);}
				
				//Backing up current report file with current time-stamp
				LocalDateTime myDate = LocalDateTime.now();
				DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
				String dt = myDate.format(dateTime);
				
				File reportBackup = new File(AppConstant.getarcheiveSparkReportPath() + "_" + dt + ".html");
				
				FileUtils.copyFile(reportFile, reportBackup);
				
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("", e.getCause());
			}
		}
	
	
}
