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
	}

	public void leaveFrame() {
		driver.switchTo().defaultContent();
	}

	public void type(By locator, String text, float timeout) {
		type(locator, text, timeout);
	}

	public void click(By locator, float timeout) {
		click(locator, timeout);
	}

	public void select(By locator, String option, float timeout) {
		select(locator, option, timeout);
	}

	public boolean checkChkBoxStatus(By locator) {
		return false;
	}

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
		return driver;
	}

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
		return driver;
	}

	public boolean alertExists(float timeout) {
		return alertExists(timeout);
	}

	public Alert getAlert(float timeout) {
		return getAlert(timeout);
	}

	public boolean acceptAlert(float timeout) {
		return acceptAlert(timeout);
	}

	public boolean cancelAlert(float timeout) {
		return cancelAlert(timeout);
	}
}