package com.grimm.maven.selenium.mantis.operation;

import org.openqa.selenium.By;

public class ElementOperation {

	private static float timeout = 30;

	 /**
     * ��ȡҳ��Ԫ�أ�����Ҫ������ʾ�ģ���ʹ��Ĭ�ϳ�ʱʱ��
     * @param locator ��λ��
     * @return
     */
	public boolean isElementPresent(By locator, float timeout) {
		return isElementPresent(locator, timeout);
	}
	
	/**
     * ��ȡ�ؼ��ı���Ϣ,ʹ��Ĭ�ϳ�ʱʱ��
     * @param locator ��λ��
     * @return
     */
	public String getElementText(By locator, float timeout) {
		return getElementText(locator, timeout);

	}
}
