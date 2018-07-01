package com.grimm.maven.selenium.mantis.driver;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.grimm.maven.selenium.mantis.tools.ReadXml;

public class CreateChromeDriver implements ICreateDriver {
	private WebDriver driver;
	private ArrayList<String> attritubes;
	private ArrayList<String> valus;
	private ArrayList<String> options = new ArrayList<String>();

	public WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\CloudStation\\driver\\");
		getOptions();
		ChromeOptions option = new ChromeOptions();
		option.addArguments(options);
		driver = new ChromeDriver(option);
		return driver;

	}

	private void getOptions() {
		// TODO Auto-generated method stub
		attritubes=ReadXml.getNodeAttritubes();
	}
}
