package com.grimm.maven.selenium.mantis.operation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.grimm.maven.selenium.mantis.tools.Log;

public class WindowOperation {
	protected WebDriver driver;
	private static float timeout = 30;

	protected WindowOperation(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPageLoad() {
		getDriver().manage().timeouts().pageLoadTimeout((int) timeout, TimeUnit.SECONDS);
	}

	public void refresh() {
		driver.navigate().refresh();
		Log.info("刷新页面");
	}

	public void leaveFrame() {
		driver.switchTo().defaultContent();
		Log.info("返回默认Frame");
	}

	public void type(By locator, String text, float timeout) {
		type(locator, text, timeout);
	}

	/*
	 * public void type() { WebElement we=getElement(); try{
	 * 
	 * }catch(){
	 * 
	 * }try{
	 * 
	 * }catch(){
	 * 
	 * } }
	 */

	public void click(By locator, float timeout) {
		click(locator, timeout);
	}

	/**
	 * 选择某个选项,使用默认超时时间
	 * @param locator 定位器
	 * @param option  选项 (1/2)
	 */
	public void select(By locator, String option, float timeout) {
		select(locator, option, timeout);
	}

	/**
     * 检查chkbox是否勾选
     * @param locator 定位器
     * @return
     */
	public boolean checkChkBoxStatus(By locator) {
		return false;
	}

	
	public void get(String url) {
		driver.get(url);
		Log.info("指定链接：" + url);
	}
}