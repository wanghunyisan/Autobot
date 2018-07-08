package com.grimm.maven.selenium.mantis.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementOperation {

	private static float timeout = 30;

	public boolean isElementPresent(By locator, float timeout) {
		return isElementPresent(locator, timeout);
	}

	public WebElement getElement(By locator, float timeout) {
		return getElement(locator, timeout);
	}

	public String getElementText(By locator, float timeout) {
		return getElementText(locator, timeout);
	}
}
