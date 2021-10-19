package com.example.selenium.app.chrome.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;


public class CadastroLeilaoPage {

    private WebDriver browser;

    public CadastroLeilaoPage(WebDriver browser) {
        this.browser = browser;
    }

    public void goToLoginForm(){
        browser.navigate().to("http://localhost:8080/login");
    }

    public void fillForm(String username, String valor, String dataAbertura){
        browser.findElement(By.id("nome")).sendKeys(username);
        browser.findElement(By.id("valorInicial")).sendKeys(valor);
        browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
    }

    public LeiloesPage submitForm(){
        browser.findElement(By.id("button-submit")).click();
        return new LeiloesPage(browser);
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

    public void goToLeilaoForm(){
        browser.findElement(By.id("novo_leilao_link")).click();
    }

}
