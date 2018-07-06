package com.grimm.maven.selenium.mantis.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.grimm.maven.selenium.mantis.tools.*;

public class BrowserEngine {
	public String browserName;
	public String serverURL;
	public WebDriver driver;

	public void initConfigData() throws IOException {
		Properties p = new Properties();
		InputStream ips = new FileInputStream(".\\resource\\config.properties");
		p.load(ips);

		Logger.Output(LogType.LogTypeName.INFO, "开始从属性文件中选择浏览器");
		browserName = p.getProperty("browserName");
		Logger.Output(LogType.LogTypeName.INFO, "所选浏览器为：" + browserName);
		serverURL = p.getProperty("URL");
		Logger.Output(LogType.LogTypeName.INFO, "被测试网址为：" + serverURL);
		ips.close();
	}

	public WebDriver getBrowser() {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\CloudStation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			Logger.Output(LogType.LogTypeName.INFO, "启动Chrome……");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.bin", "D:\\CloudStation\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			Logger.Output(LogType.LogTypeName.INFO, "启动Firefox……");
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\CloudStation\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Logger.Output(LogType.LogTypeName.INFO, "启动IE……");
		}
		driver.get(serverURL);
		driver.manage().window().maximize();
		pause(5);
		return driver;
	}

	/**
	 * 暂停浏览器操作
	 *
	 * @param time 暂停时间,单位为秒
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