package com.grimm.maven.selenium.mantis.test;

import org.testng.annotations.Test;

import com.grimm.maven.selenium.mantis.driver.BrowserBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Try {
	private BrowserBase driver=null;

	@BeforeMethod
	public void setUp() {
		driver.setBrowserType(1);
	}

	@Test
	public void test1() {
		driver.open("http://www.baidu.com");
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}