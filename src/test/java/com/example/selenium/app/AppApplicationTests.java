package com.example.selenium.app;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AppApplicationTests {

	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.navigate().to("http://localhost:8080/leiloes");
		webDriver.quit();
	}


}
