package com.grimm.maven.selenium.mantis.operation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.grimm.maven.selenium.mantis.tools.LogType;
import com.grimm.maven.selenium.mantis.tools.Logger;

public class BasePage {
	public static WebDriver driver;
	public static String pageTitle;
	public static String pageUrl;

	/*
	 * 构造方法
	 */
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
	}

	/*
	 * 在文本框内输入字符
	 */
	protected void type(WebElement element, String text) {
		try {
			if (element.isEnabled()) {
				element.clear();
				element.sendKeys(text);
			}
		} catch (Exception e) {
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage() + ".");
		}
	}

	protected void click(WebElement element) {
		try {
			if (element.isEnabled()) {
				element.click();
			}
		} catch (Exception e) {
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage() + ".");
		}
	}

	/*
	 * 在文本输入框执行清除操作
	 */
	protected void clean(WebElement element) {
		try {
			if (element.isEnabled()) {
				element.clear();
			}
		} catch (Exception e) {
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage() + ".");
		}
	}

	/*
	 * 判断一个页面元素是否显示在当前页面
	 */
	protected void verifyElementIsPresent(WebElement element) {
		try {
			if (element.isDisplayed()) {

			}
		} catch (Exception e) {
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage() + ".");
		}
	}

	/*
	 * 获取页面的标题
	 */
	protected String getCurrentPageTitle() {
		pageTitle = driver.getTitle();
		Logger.Output(LogType.LogTypeName.INFO, "当前页面标题：" + pageTitle);
		return pageTitle;
	}

	/*
	 * 获取页面的url
	 */
	protected String getCurrentPageUrl() {
		pageUrl = driver.getCurrentUrl();
		Logger.Output(LogType.LogTypeName.INFO, "当前页面URL：" + pageUrl);
		return pageUrl;
	}

	/*
	 * 处理多窗口之间切换
	 */
	public void switchWindow() {
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		Logger.Output(LogType.LogTypeName.INFO, "当前窗口数量：" + handles.size());
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			try {
				driver.close();// 关闭旧窗口
				WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口
			} catch (Exception e) {
				Logger.Output(LogType.LogTypeName.ERROR, "" + e.getMessage());
			}
		}
	}
}
