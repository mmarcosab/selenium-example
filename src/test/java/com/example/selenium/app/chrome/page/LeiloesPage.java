package com.example.selenium.app.chrome.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;


public class LeiloesPage {

    private WebDriver browser;

    public LeiloesPage(WebDriver browser) {
        this.browser = browser;
    }

    public void goToLoginForm(){
        browser.navigate().to("http://localhost:8080/login");
    }

    public void fillForm(String username, String password){
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void submitForm(){
        browser.findElement(By.id("btn-submit")).click();
    }

    public void quit() {
        browser.quit();
    }

    public String getUserLogged(){
        try{
            return browser.findElement(By.id("nome-usuario")).getText();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public String getCurrentUrl(){
        return browser.getCurrentUrl();
    }

    public boolean pageContains(String message){
        return browser.getPageSource().contains(message);
    }

    public void goToLeiloesPage(){
        browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public CadastroLeilaoPage goToLeilaoForm(){
        browser.findElement(By.id("novo_leilao_link")).click();
        return new CadastroLeilaoPage(browser);
    }

    public boolean isCadastrado(String nome, String valorInicial, String dataAbertura) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3"));

        return colunaNome.getText().equals(nome)
            && colunaValorInicial.getText().equals(valorInicial)
            && colunaDataAbertura.getText().equals(dataAbertura);

    }
}
