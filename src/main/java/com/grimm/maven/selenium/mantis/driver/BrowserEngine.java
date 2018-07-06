package com.grimm.maven.selenium.mantis.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserEngine {
	public String browserName;
	public String serverURL;
	public WebDriver driver;

	public void initConfigData() throws IOException {
		Properties p = new Properties();
		InputStream ips = new FileInputStream(".\\resource\\config.properties");
		p.load(ips);

		// Log.info();
		browserName = p.getProperty("browserName");
		serverURL = p.getProperty("URL");
		ips.close();
	}

	public WebDriver getBrowser() {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Grimm\\CloudStation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			// Log.info("使用Chrome");
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.bin", "C:\\Users\\Grimm\\CloudStation\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			// Log.info("使用Firefox");
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Grimm\\CloudStation\\driver\\.exe");
			driver = new InternetExplorerDriver();
			// Log.info("使用IE");
			driver.manage().window().maximize();
		}
		return driver;
	}

	public void open(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Log.info("打开链接" + url);
	}

	/**
	 * 暂停浏览器操作
	 *
	 * @param time
	 *            暂停时间,单位为秒
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

	public void close() {
		driver.close();
		// Log.info("窗口" + getTitle() + "关闭");
	}

	public void quit() {
		driver.quit();
		// Log.info("退出浏览器");
	}

	/**
	 * 获取当前窗口title
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	public void maxWindow() {
		driver.manage().window().maximize();
		// Log.info("最大化浏览器");
	}
}