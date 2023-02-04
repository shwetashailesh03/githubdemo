package com.NeoStox.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Neostox.Base.BasePage;
import com.Neostox.Pages.LoginPage;

public class LoginPageTest extends BasePage{
	
	@Test()
	public void ValiduserLogin() {
		LoginPage loginpage = new LoginPage(driver);
		Assert.assertEquals(loginpage.getTextofUser(), "Hi adesh Khedkar");
	}

}
