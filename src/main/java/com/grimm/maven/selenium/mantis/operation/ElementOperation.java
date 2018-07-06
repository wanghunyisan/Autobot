package com.grimm.maven.selenium.mantis.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementOperation {

	private static float timeout = 30;

	/**
	 * 判断元素是否存在，等待到超时时间，最长超时时间在配置文件中定义,元素需要可以显示
	 * 
	 * @param locator 定位器
	 * @return 元素是否存在的boolean值
	 */
	public boolean isElementPresent(By locator, float timeout) {
		return isElementPresent(locator, timeout);
	}

	/**
	 * 获取页面元素（不需要可以显示的），使用默认超时时间
	 * 
	 * @param locator 定位器
	 * @return
	 */
	public WebElement getElement(By locator, float timeout) {
		return getElement(locator, timeout);
	}

	/**
	 * 获取控件文本信息,使用默认超时时间
	 * 
	 * @param locator 定位器
	 * @return
	 */
	public String getElementText(By locator, float timeout) {
		return getElementText(locator, timeout);

	}
}
