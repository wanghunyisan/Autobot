package com.grimm.maven.selenium.mantis.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grimm.maven.selenium.mantis.driver.BrowserEngine;
import com.grimm.maven.selenium.mantis.pageobject.BasePage;

public class Try {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {
		BrowserEngine.initConfigData();
		driver = BrowserEngine.getBrowser();
	}

	@Test(invocationCount = 1, threadPoolSize = 1) // invocationCount：调用次数，threadPoolSize：线程数
	public void test1() {
		new BasePage(driver);
		BasePage.getCurrentPageTitle();
		BasePage.getCurrentPageUrl();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		BrowserEngine.tearDown();
	}
}