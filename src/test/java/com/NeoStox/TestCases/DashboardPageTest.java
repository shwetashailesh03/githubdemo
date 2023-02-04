package com.NeoStox.TestCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Neostox.Base.BasePage;
import com.Neostox.Pages.DashboardPage;
import com.Neostox.Utilities.CommonActions;


public class DashboardPageTest extends BasePage{

	DashboardPage dashboardpage;
	CommonActions commonactions;
	
	@Test()
	public void ExpandAndCollapse() {
		dashboardpage =  new DashboardPage(driver);
		commonactions = new CommonActions();
		Assert.assertTrue(dashboardpage.buttonWatchlist.isDisplayed());
		commonactions.click_on_Element(dashboardpage.buttonExpandCollpase);
		Assert.assertFalse(dashboardpage.buttonWatchlist.isDisplayed());
		commonactions.click_on_Element(dashboardpage.buttonExpandCollpase);
	}
	
	@Test(dataProvider="getData", dataProviderClass=com.Neostox.Utilities.DataProviderUtils.class)
	public void watchlist(Map<String, String>data) {
		dashboardpage =  new DashboardPage(driver);
		dashboardpage.select_share_from_dropdown(data.get("Share"));
	}
}
