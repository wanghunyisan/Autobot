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
		Log.info("ˢ��ҳ��");
	}

	public void leaveFrame() {
		driver.switchTo().defaultContent();
		Log.info("����Ĭ��Frame");
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
	 * ѡ��ĳ��ѡ��,ʹ��Ĭ�ϳ�ʱʱ��
	 * @param locator ��λ��
	 * @param option  ѡ�� (1/2)
	 */
	public void select(By locator, String option, float timeout) {
		select(locator, option, timeout);
	}

	/**
     * ���chkbox�Ƿ�ѡ
     * @param locator ��λ��
     * @return
     */
	public boolean checkChkBoxStatus(By locator) {
		return false;
	}

	
	public void get(String url) {
		driver.get(url);
		Log.info("ָ�����ӣ�" + url);
	}
}