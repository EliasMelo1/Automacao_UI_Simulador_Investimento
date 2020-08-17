# Simples estrutura de automação para ecommerce

## Ferramentas utilizadas:
- [VSCode](https://code.visualstudio.com/ "VSCode") / [IntelliJ CE](https://www.jetbrains.com/idea/download/ "IntelliJ CE")
- [Junit](https://mvnrepository.com/artifact/junit/junit/4.12 "Junit")
- [Selenium JAVA](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java "Selenium JAVA")
- [webdriver-manager](https://www.npmjs.com/package/webdriver-manager "webdriver-manager")

## Recursos utilizados no projeto
- **Selenium:**
    - WebElement
    - click
    - ExpectedConditions
    - findElement(s)
    - getText
    - sendKeys
- **Java:**
    - Junit 4.13

## Estrutura de pastas

```
📦ecommerce-simple-automation
 ┣ 📂src
 ┃ ┣ 📂test
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┣ 📂pageObjects
 ┃ ┃ ┃ ┃ ┣ 📜BasePage.java
 ┃ ┃ ┃ ┃ ┣ 📜SimuladorInvestimentoPage.java
 ┃ ┃ ┃ ┣ 📂tests
 ┃ ┃ ┃ ┃ ┣ 📜BaseTest.java
 ┃ ┃ ┃ ┃ ┗ 📜SimuladorInvestimento.java
 ┃ ┃ ┃ ┣ 📂utils
 ┃ ┃ ┃ ┃ ┣ 📜Browser.java
 ┃ ┃ ┃ ┃ ┗ 📜Utils.java
 ┣ 📜.gitignore
 ┣ 📜README.md
 ┣ 📜pom.xml
 ┗ 📜simulador_investimento.iml
```

## Tutorial, Instalação e execução

**Ter previamente instalado:**
- JAVA
- NodeJS
- Maven (mvn)

#### Instalar o webdriver-manager
Em uma nova aba ou janela de seu terminal, executar os seguintes comandos: 
- `npm install -g webdriver-manager`
- `webdriver-manager update`
- `webdriver-manager start`

#### Abrir o projeto no editor de texto de sua preferência
No terminal de seu editor de texto, executar os seguintes comandos:
- `mvn clean test`

Chegou a hora de poupar! Mas quanto? Em quanto tempo? Como posso saber?
Nosso associado gostaria de simular o investimento na poupança para descobrir qual o valor ideal e quanto ele vai poupar no prazo que escolher.

Vamos construir um simulador de investimentos?

## História
Com o propósito de Simular um Investimento na Poupança como um Associado, eu gostaria de preencher o formulário de simulação
e ver a tabela de resultado com Mês e Valor.

#### Critério de aceitação:
- O associado preencher todos os campos corretamente e visualizar o formulário de simulação
- O associado preencher o valor inferior a “R$ 20.00” e receber a mensagem de orientação “Valor mínimo de R$ 20.00”.
- Url: https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/