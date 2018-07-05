package com.grimm.maven.selenium.mantis.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.grimm.maven.selenium.mantis.tools.Log;

public class BrowserBase {
	protected WebDriver driver;
	public ChromeDriverService chromService;

	public WebDriver getBrowserDriver() {
		return driver;
	}

	/**
	 * @param ������������� type 1=chrome 2=firefox 3=ie
	 */
	public void setBrowserType(int type) {
		switch (type) {
		case 1:// chrome:1
			System.setProperty("webdriver.chrome.driver", "D:\\CloudStation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			Log.info("ʹ��Chrome");
			driver.manage().window().maximize();
			break;
		case 2:// firefox:2
			System.setProperty("webdriver.firefox.bin", "D:\\CloudStation\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			Log.info("ʹ��Firefox");
			driver.manage().window().maximize();
			break;
		case 3:// ie:3
			System.setProperty("webdriver.ie.driver", "D:\\CloudStation\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Log.info("ʹ��IE");
			driver.manage().window().maximize();
			break;
		default:
			Log.error("��������������");
			break;
		}
	}
	/*
	 * public void CreateChromeDriver() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "D:\\CloudStation\\driver\\chromedriver.exe"); driver = new ChromeDriver();
	 * Log.info("ʹ��Chrome"); driver.manage().window().maximize(); }
	 * 
	 * public void CreateFirefoxDriver() {
	 * System.setProperty("webdriver.firefox.bin",
	 * "D:\\CloudStation\\driver\\geckodriver.exe"); driver = new FirefoxDriver();
	 * Log.info("ʹ��Firefox"); driver.manage().window().maximize(); }
	 * 
	 * public void CreateIEDriver() { System.setProperty("webdriver.ie.driver",
	 * "D:\\CloudStation\\driver\\IEDriverServer.exe"); driver = new
	 * InternetExplorerDriver(); Log.info("ʹ��IE");
	 * driver.manage().window().maximize(); }
	 */

	public void open(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.info("������" + url);
	}

	/**
	 * ��ͣ���������
	 *
	 * @param time ��ͣʱ��,��λΪ��
	 */
	public void pause(float time) {
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep((int) time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void quit() {
		driver.quit();

		/*
		 * if (GlobaSettings.browserType == 1) { chromeService.stop(); }
		 */

		Log.info("�˳������");
	}

	public void maxWindow() {
		driver.manage().window().maximize();
		Log.info("��������");
	}
}