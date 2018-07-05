package com.grimm.maven.selenium.mantis.operation;

import org.openqa.selenium.By;

public class ElementOperation {

	private static float timeout = 30;

	 /**
     * 获取页面元素（不需要可以显示的），使用默认超时时间
     * @param locator 定位器
     * @return
     */
	public boolean isElementPresent(By locator, float timeout) {
		return isElementPresent(locator, timeout);
	}
	
	/**
     * 获取控件文本信息,使用默认超时时间
     * @param locator 定位器
     * @return
     */
	public String getElementText(By locator, float timeout) {
		return getElementText(locator, timeout);

	}
}
