package com.neethuManu.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGridTest {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeMethod
	public void setup() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		options.merge(capabilities);

		WebDriverManager.chromedriver().setup();
		try {
			driver.set(new RemoteWebDriver(new URL("http://10.0.0.156:4444"), capabilities));
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void verifyTest1() {
		driver.get().get("https://naveenautomationlabs.com/opencart/");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "Your Store", "Title is not matchingh");

	}

	@Test
	public void verifyTest2() {
		driver.get().get("https://mvnrepository.com/search?q=selenium");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "Maven Repository: selenium", "Title is not matchingh");

	}

	@Test
	public void verifyTest3() {
		driver.get().get("https://www.guru99.com/introduction-to-selenium-grid.html");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "Selenium Grid Tutorial: Setup a Hub and Node (Example)",
				"Title is not matchingh");

	}

	@Test
	public void verifyTest4() {
		driver.get().get("https://www.facebook.com/");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "Facebook - log in or sign up", "Title is not matchingh");

	}

	@Test
	public void verifyTest5() {
		driver.get().get("https://www.browserstack.com/guide/run-selenium-test-script");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "How to run first Selenium Test Script : Tutorial | BrowserStack",
				"Title is not matchingh");

	}

	@Test
	public void verifyTest6() {
		driver.get().get("https://www.demoblaze.com/");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "STORE", "Title is not matchingh");

	}

	@Test
	public void verifyTest7() {
		driver.get().get("https://demoqa.com/");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "ToolsQA", "Title is not matchingh");

	}

	@Test
	public void verifyTest8() {
		driver.get().get("https://www.amazon.ca/");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "Amazon.ca: Low Prices – Fast Shipping – Millions of Items",
				"Title is not matchingh");

	}

	@Test
	public void verifyTest9() {
		driver.get().get("https://github.com/github");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "GitHub · GitHub", "Title is not matchingh");

	}

	@Test
	public void verifyTest10() {
		driver.get().get("https://www.selenium.dev/documentation/webdriver/getting_started/");
		System.out.println(driver.get().getTitle());
		Assert.assertEquals(driver.get().getTitle(), "Getting started | Selenium", "Title is not matchingh");
	}

	@AfterMethod
	public void teardown() {
		driver.get().quit();
	}

}
