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
//		Log.info("ˢ��ҳ��");
	}

	/**
	 * �뿪��ǰFrame,����Ĭ��Frame
	 */
	public void leaveFrame() {
		driver.switchTo().defaultContent();
//		Log.info("����Ĭ��Frame");
	}

	/**
	 * �����������ݣ�Ȼ�����룬�Դ���ʱʱ��
	 * 
	 * @param locator ��λ��
	 * @param text    ������ı�
	 */
	public void type(By locator, String text, float timeout) {
		type(locator, text, timeout);
	}

	/**
	 * ���ҳ��Ԫ�أ��Դ�Ĭ�ϵ��ǰ��ȡԪ�صĳ�ʱʱ��
	 * 
	 * @param locator ��λ��
	 */
	public void click(By locator, float timeout) {
		click(locator, timeout);
	}

	/**
	 * ѡ��ĳ��ѡ��,ʹ��Ĭ�ϳ�ʱʱ��
	 * 
	 * @param locator ��λ��
	 * @param option  ѡ��
	 */
	public void select(By locator, String option, float timeout) {
		select(locator, option, timeout);
	}

	/**
	 * ���chkbox�Ƿ�ѡ
	 * 
	 * @param locator ��λ��
	 * @return
	 */
	public boolean checkChkBoxStatus(By locator) {
		return false;
	}

	/**
	 * �л�ҳ�棬�޸�ҳ��
	 * 
	 * @param currentWindow ��ǰ����
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
//		Log.info("û�е�������");
		return driver;
	}

	/**
	 * �л�ҳ�棬�и�ҳ��
	 * 
	 * @param parantWindow  ��ҳ��
	 * @param currentWindow ��ǰҳ��
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
//		Log.info("û�е�������");
		return driver;
	}

	/**
	 * ����Ƿ��е�����,ʹ��Ĭ�ϳ�ʱʱ��
	 * 
	 * @return
	 */
	public boolean alertExists(float timeout) {
		return alertExists(timeout);
	}

	/**
	 * ��ȡ������,ʹ��Ĭ�ϳ�ʱʱ��
	 * 
	 * @return
	 */
	public Alert getAlert(float timeout) {
		return getAlert(timeout);
	}

	/**
	 * �����������ȷ�ϰ�ť,ʹ��Ĭ�ϳ�ʱʱ��
	 * 
	 * @return
	 */
	public boolean acceptAlert(float timeout) {
		return acceptAlert(timeout);
	}

	/**
	 * ����������ڵ�ȡ����ť,ʹ��Ĭ�ϳ�ʱʱ��
	 * 
	 * @return
	 */
	public boolean cancelAlert(float timeout) {
		return cancelAlert(timeout);
	}
}