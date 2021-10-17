package com.example.selenium.app;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;


class LoginTests {

	private WebDriver browser;

	@BeforeAll
	public static void setWebDriver(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	}

	@BeforeEach
	public void init(){
		browser = new ChromeDriver();
	}

	@Test
	public void testLoginValido(){
		browser.navigate().to("http://localhost:8080/login");
		//geralmente se usa o id dos elementos da tela para encontrar algo na tela
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("btn-submit")).click();
		assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		assertEquals("fulano", browser.findElement(By.id("nome-usuario")).getText());
	}

	@Test
	public void testLoginInvalido(){
		browser.navigate().to("http://localhost:8080/login");
		//geralmente se usa o id dos elementos da tela para encontrar algo na tela
		browser.findElement(By.id("username")).sendKeys("fulano2");
		browser.findElement(By.id("password")).sendKeys("pass2");
		browser.findElement(By.id("btn-submit")).click();
		assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		assertTrue(browser.getPageSource().contains("Usuário e senha inválidos"));
		assertThrows(NoSuchElementException.class, ()-> browser.findElement(By.id("nome-usuario")).getText());
	}

	@Test
	public void naoDeveAcessarPaginaLeiloesSemLogin(){
		browser.navigate().to("http://localhost:8080/leiloes/2");
		assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		assertFalse(browser.getPageSource().contains("Dados do Leilão"));
	}

	@AfterEach
	public void quit(){
		browser.quit();
	}

}
