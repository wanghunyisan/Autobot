package com.grimm.maven.selenium.mantis.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementOperation {

	private static float timeout = 30;

	/**
	 * �ж�Ԫ���Ƿ���ڣ��ȴ�����ʱʱ�䣬���ʱʱ���������ļ��ж���,Ԫ����Ҫ������ʾ
	 * 
	 * @param locator ��λ��
	 * @return Ԫ���Ƿ���ڵ�booleanֵ
	 */
	public boolean isElementPresent(By locator, float timeout) {
		return isElementPresent(locator, timeout);
	}

	/**
	 * ��ȡҳ��Ԫ�أ�����Ҫ������ʾ�ģ���ʹ��Ĭ�ϳ�ʱʱ��
	 * 
	 * @param locator ��λ��
	 * @return
	 */
	public WebElement getElement(By locator, float timeout) {
		return getElement(locator, timeout);
	}

	/**
	 * ��ȡ�ؼ��ı���Ϣ,ʹ��Ĭ�ϳ�ʱʱ��
	 * 
	 * @param locator ��λ��
	 * @return
	 */
	public String getElementText(By locator, float timeout) {
		return getElementText(locator, timeout);

	}
}
