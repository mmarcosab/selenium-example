package com.example.selenium.app;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AppApplicationTests {

	private WebDriver webDriver;

	@BeforeAll
	public static void setWebDriver(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	}

	@BeforeEach
	public void init(){
		webDriver = new ChromeDriver();
	}

	@Test
	public void test(){
		webDriver.navigate().to("http://localhost:8080/leiloes");
		webDriver.quit();
	}


}
