package com.grimm.maven.selenium.mantis.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
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

		browserName = p.getProperty("browserName");
		Logger.Output(LogType.LogTypeName.INFO, "测试浏览器：" + browserName);
		serverURL = p.getProperty("URL");
		Logger.Output(LogType.LogTypeName.INFO, "测试URL：" + serverURL);
		ips.close();
	}

	public WebDriver getBrowser() {
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\CloudStation\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			Logger.Output(LogType.LogTypeName.INFO, "启动Firefox……");
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\CloudStation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			Logger.Output(LogType.LogTypeName.INFO, "启动Chrome……");
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\CloudStation\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Logger.Output(LogType.LogTypeName.INFO, "启动IE……");
		}
		driver.get(serverURL);
		driver.manage().window().maximize();
		callWait(5);
		return driver;
	}

	/*
	 * 关闭并退出浏览器
	 */
	public void tearDown() throws InterruptedException {
		Logger.Output(LogType.LogTypeName.INFO, "关闭浏览器……");
		driver.quit();
		Thread.sleep(3000);
	}

	/*
	 * 
	 */
	public void callWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		Logger.Output(LogType.LogTypeName.INFO, "等待" + time + "秒");
	}

	/*
	 * private WebDriver createFireFoxDriver() {
	 * 
	 * WebDriver driver = null; FirefoxProfile firefoxProfile = new
	 * FirefoxProfile();
	 * 
	 * firefoxProfile.setPreference("prefs.converted-to-utf8", true); // set
	 * download folder to default folder: TestDownload
	 * firefoxProfile.setPreference("browser.download.folderList", 2);
	 * firefoxProfile.setPreference("browser.download.dir", ".\\TestDownload");
	 * 
	 * try { driver = new FirefoxDriver(firefoxProfile); } catch (Exception e) {
	 * Logger.Output(LogType.LogTypeName.ERROR, e.getMessage());
	 * Logger.Output(LogType.LogTypeName.ERROR,
	 * "Failed to initilize the Firefox driver"); } return driver; }
	 */
}