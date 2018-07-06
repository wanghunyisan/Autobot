package com.grimm.maven.selenium.mantis.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grimm.maven.selenium.mantis.driver.BrowserEngine;

public class Try {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {
		BrowserEngine browserEngine = new BrowserEngine();
		browserEngine.initConfigData();
		driver = browserEngine.getBrowser();
	}

	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(2000);
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}