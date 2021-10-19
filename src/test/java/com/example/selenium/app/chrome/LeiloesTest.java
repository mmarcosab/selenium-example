package com.example.selenium.app.chrome;

import com.example.selenium.app.chrome.page.CadastroLeilaoPage;
import com.example.selenium.app.chrome.page.LeiloesPage;
import com.example.selenium.app.chrome.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


class LeiloesTest {

	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private CadastroLeilaoPage cadastroLeilaoPage;


	@BeforeEach
	public void init(){
		loginPage = new LoginPage();
	}

	@Test
	public void testCadastrarLeilaoComSucesso() {
		loginPage.goToLoginForm();
		loginPage.fillForm("fulano", "pass");
		leiloesPage = loginPage.submitForm();
		// indo pra pagina de cadastro
		cadastroLeilaoPage = leiloesPage.goToLeilaoForm();
		LocalDate data = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataAbertura = data.format(dateTimeFormatter);
		String nome = "teste " + dataAbertura;
		String valorInicial = "100.00";
		cadastroLeilaoPage.fillForm(nome, valorInicial, dataAbertura);
		// voltando pra lista de leiloes
		leiloesPage = cadastroLeilaoPage.submitForm();
		var result = leiloesPage.isCadastrado(nome, valorInicial, dataAbertura);
		assertTrue(result);
	}

	@Test
	public void testCadastrarLeilaoComFalha() {
		loginPage.goToLoginForm();
		loginPage.fillForm("", "");
		leiloesPage = loginPage.submitForm();
		// indo pra pagina de cadastro
		cadastroLeilaoPage = leiloesPage.goToLeilaoForm();
		LocalDate data = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataAbertura = data.format(dateTimeFormatter);
		String nome = "teste " + dataAbertura;
		String valorInicial = "100.00";
		cadastroLeilaoPage.fillForm(nome, valorInicial, "");
		// voltando pra lista de leiloes
		leiloesPage = cadastroLeilaoPage.submitForm();
		//TODO - terminar esse teste
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
