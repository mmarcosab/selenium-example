package com.example.selenium.app.chrome;

import com.example.selenium.app.chrome.page.LeiloesPage;
import com.example.selenium.app.chrome.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LeiloesTest {

	private LoginPage loginPage;
	private LeiloesPage leiloesPage;

	@BeforeEach
	public void init(){
		loginPage = new LoginPage();
	}

	@Test
	public void testCadastrarLeilao() {
		loginPage.goToLoginForm();
		loginPage.fillForm("fulano", "pass");
		leiloesPage = loginPage.submitForm();
		leiloesPage.goToLeiloesPage();
		System.out.println("");
		//TODO continue from here

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
