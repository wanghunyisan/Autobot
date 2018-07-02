package com.grimm.maven.selenium.mantis.driver;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.grimm.maven.selenium.mantis.tools.ReadXml;

public class CreateChromeDriver implements ICreateDriver {
	private WebDriver driver;
	private ArrayList<String> attritubes;
	private ArrayList<String> values;
	private ArrayList<String> options = new ArrayList<String>();

	public WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\CloudStation\\driver\\chromedriver.exe");
		getOptions();
		ChromeOptions option = new ChromeOptions();
		option.addArguments(options);
		driver = new ChromeDriver(option);
		return driver;

	}

	// 取config.xml中chrome浏览器的启动参数
	private void getOptions() {
		attritubes = ReadXml.getNodeAttributes("parameter", "name");
		values = ReadXml.getNodeValues("parameter");
		for (int i = 0; i < values.size(); i++) {
			options.add(attritubes.get(i) + values.get(i));
		}
	}
}