### selenium-example


#### Documentacao
- https://www.selenium.dev/documentation/

#### Drivers
- https://chromedriver.chromium.org/downloads
- https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
- https://www.selenium.dev/selenium/docs/api/javascript/module/selenium-webdriver/firefox.html


#### Padrão Page Object
- https://www.selenium.dev/documentation/guidelines/page_object_models/

#### Lidando com requisições AJAX ou códigos JavaScript

O método manage() auxilia nisso. Exemplo: 

``` 
this.brouwser.manage().timeouts().implicitWait(5, TimeUnit.SECONDS).pageLoadTimeout(10, TimeUnit.SECONDS);
```


#### Algumas dicas retiradas da documentação do selenium
- usar page object
- cada teste deve rodar de maneira isolada, comece sempre do zero
- nomes dos métodos de teste devem ser algo próximo da linguagem de domínio do negócio
- cada teste deve abrir um novo navegador com novo estado