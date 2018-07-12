package com.grimm.maven.selenium.mantis.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// 登录链接
	@FindBy(xpath = "")
	WebElement login_lnk;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickLoginLnk() {
		click(login_lnk);
		return new LoginPage(driver);
	}
}
