package com.grimm.maven.selenium.mantis.tools;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.grimm.maven.selenium.mantis.driver.BrowserEngine;

public class Login {
	public WebDriver driver;

	// 获取浏览器类型，打开浏览器，打开测试网站
	public void initSetup() throws IOException {
		BrowserEngine browser = new BrowserEngine();
		browser.initConfigData();
		driver = browser.getBrowser();
	}

	public void loginValid() {
	}
}
