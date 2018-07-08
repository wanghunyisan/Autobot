package com.grimm.maven.selenium.mantis.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.grimm.maven.selenium.mantis.driver.BrowserEngine;

public class Try {
	public WebDriver driver;

	@BeforeClass
	public void setUp() throws IOException {
		BrowserEngine browserEngine = new BrowserEngine();
		browserEngine.initConfigData();
		driver = browserEngine.getBrowser();
	}

	@Test
	public void getTitle() {
		System.out.println(driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}