package com.grimm.maven.selenium.mantis.tools;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.grimm.maven.selenium.mantis.driver.BrowserEngine;
import com.grimm.maven.selenium.mantis.pageobject.HomePage;
import com.grimm.maven.selenium.mantis.pageobject.LoginPage;

public class Login {
	public WebDriver driver;

	// 获取浏览器类型，打开浏览器，打开测试网站
	public void initSetup() throws IOException {
		BrowserEngine browser = new BrowserEngine();
		browser.initConfigData();
		driver = browser.getBrowser();
	}

	public void loginValid() {
		HomePage homepge = PageFactory.initElements(driver, HomePage.class);
		// 点击主页上的登录链接
		homepge.clickLoginLnk();
		// 跳转到登录页面，初始化登录界面的元素
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login("", "");
	}
}
