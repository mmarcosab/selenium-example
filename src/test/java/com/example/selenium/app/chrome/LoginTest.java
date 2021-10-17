package com.example.selenium.app.chrome;

import com.example.selenium.app.chrome.page.LoginPage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class LoginTest {

	private LoginPage loginPage;

	@BeforeEach
	public void init(){
		loginPage = new LoginPage();
	}

	@Test
	public void testLoginValido(){
		loginPage.goToLoginForm();
		loginPage.fillForm("fulano", "pass");
		loginPage.submitForm();
		assertFalse(loginPage.getCurrentUrl().equals("http://localhost:8080/login"));
		assertEquals("fulano", loginPage.getUserLogged());
	}

	@Test
	public void testLoginInvalido(){
		loginPage.goToLoginForm();
		loginPage.fillForm("fulano2", "pass2");
		loginPage.submitForm();
		assertTrue(loginPage.getCurrentUrl().equals("http://localhost:8080/login?error"));
		assertTrue(loginPage.pageContains("Usuário e senha inválidos"));
		assertEquals(null, loginPage.getUserLogged());
	}

	@Test
	public void naoDeveAcessarPaginaLeiloesSemLogin(){
		loginPage.goToLeiloesPage();
		assertTrue(loginPage.getCurrentUrl().equals("http://localhost:8080/login"));
		assertFalse(loginPage.pageContains("Dados do Leilão"));
	}

	@AfterEach
	public void quit(){
		loginPage.quit();
	}

}
