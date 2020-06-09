package com.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class OpenApplication {
public static WebDriver driver;
@BeforeMethod
public void configBC() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://10.10.11.90:9998/index.html#/login");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
@AfterMethod
public void closeApp() {
	driver.quit();
}
}
