package com.grimm.maven.selenium.mantis.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grimm.maven.selenium.mantis.driver.BrowserEngine;

public class Try {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		BrowserEngine browserBase = new BrowserEngine();
	}

	@Test
	public void test1() throws InterruptedException {
		driver.get("http://www.baidu.com");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}