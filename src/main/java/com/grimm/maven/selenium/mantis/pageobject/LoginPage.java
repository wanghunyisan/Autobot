package com.grimm.maven.selenium.mantis.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// 点击登录链接
	@FindBy(xpath = "")
	WebElement loginType_byAccount;

	// 用户名
	@FindBy(id = "")
	WebElement login_userName;

	// 密码
	@FindBy(id = "")
	WebElement login_passWord;

	// 登录按钮
	@FindBy(id = "")
	WebElement login_submitBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage login(String username, String password) {
		click(loginType_byAccount);
		type(login_userName, username);
		type(login_passWord, password);
		click(login_submitBtn);
		return new HomePage(driver);
	}
}
