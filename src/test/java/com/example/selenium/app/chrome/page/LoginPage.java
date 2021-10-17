package com.example.selenium.app.chrome.page;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {

    private WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        browser = new ChromeDriver();
    }

    public void goToLoginForm(){
        browser.navigate().to("http://localhost:8080/login");
    }

    public void fillForm(String username, String password){
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage submitForm(){
        browser.findElement(By.id("btn-submit")).click();
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

}
