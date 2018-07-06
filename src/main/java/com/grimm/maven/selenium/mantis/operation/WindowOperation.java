package com.grimm.maven.selenium.mantis.operation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
//		Log.info("刷新页面");
	}

	/**
	 * 离开当前Frame,返回默认Frame
	 */
	public void leaveFrame() {
		driver.switchTo().defaultContent();
//		Log.info("返回默认Frame");
	}

	/**
	 * 清除输入框内容，然后输入，自带超时时间
	 * 
	 * @param locator 定位器
	 * @param text    输入的文本
	 */
	public void type(By locator, String text, float timeout) {
		type(locator, text, timeout);
	}

	/**
	 * 点击页面元素，自带默认点击前获取元素的超时时间
	 * 
	 * @param locator 定位器
	 */
	public void click(By locator, float timeout) {
		click(locator, timeout);
	}

	/**
	 * 选择某个选项,使用默认超时时间
	 * 
	 * @param locator 定位器
	 * @param option  选项
	 */
	public void select(By locator, String option, float timeout) {
		select(locator, option, timeout);
	}

	/**
	 * 检查chkbox是否勾选
	 * 
	 * @param locator 定位器
	 * @return
	 */
	public boolean checkChkBoxStatus(By locator) {
		return false;
	}

	/**
	 * 切换页面，无父页面
	 * 
	 * @param currentWindow 当前窗口
	 * @return
	 */
	public WebDriver switchToWindow(String currentWindow) {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			WebDriver window = driver.switchTo().window(it.next());
			return window;
		}
//		Log.info("没有弹出窗口");
		return driver;
	}

	/**
	 * 切换页面，有父页面
	 * 
	 * @param parantWindow  父页面
	 * @param currentWindow 当前页面
	 * @return (2/2)
	 */
	public WebDriver switchToWindow(String parentWindow, String currentWindow) {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			if (parentWindow == it.next()) {
				continue;
			}
			WebDriver window = driver.switchTo().window(it.next());
			return window;
		}
//		Log.info("没有弹出窗口");
		return driver;
	}

	/**
	 * 检测是否有弹出框,使用默认超时时间
	 * 
	 * @return
	 */
	public boolean alertExists(float timeout) {
		return alertExists(timeout);
	}

	/**
	 * 获取弹出框,使用默认超时时间
	 * 
	 * @return
	 */
	public Alert getAlert(float timeout) {
		return getAlert(timeout);
	}

	/**
	 * 点击弹出框内确认按钮,使用默认超时时间
	 * 
	 * @return
	 */
	public boolean acceptAlert(float timeout) {
		return acceptAlert(timeout);
	}

	/**
	 * 点击弹出框内的取消按钮,使用默认超时时间
	 * 
	 * @return
	 */
	public boolean cancelAlert(float timeout) {
		return cancelAlert(timeout);
	}
}