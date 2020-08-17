package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimuladorInvestimentoPage extends BasePage {

    @FindBy(css = "div.campoObrigatorio > input[value=paraEmpresa]")
    public WebElement radioEmpresa;

    @FindBy(id = "valorAplicar")
    public  WebElement inputAplicarValor;

    @FindBy(id = "valorInvestir")
    public WebElement inputPouparValor;

    @FindBy(id = "tempo")
    public  WebElement inputPouparTempo;

    @FindBy(className = "simular")
    public WebElement btnSimulador;

    @FindBy(css = ".btn .seta")
    public WebElement btnCheckList;

    @FindBy(css = "ul.listaSelect > li:nth-child(2)")
    public WebElement listaAno;

    @FindBy(id= "valorAplicar-error")
    public  WebElement erroAplicar;

    @FindBy(id = "valorInvestir-error")
    public WebElement erroPoupar;

    @FindBy(id="tempo-error")
    public WebElement errorTempo;

    @FindBy(className = "btnRefazer")
    public WebElement refazerBtn;

    @FindBy(css = ".texto > strong")
    public WebElement txtMeses;

    public String textMeses(){return txtMeses.getText().trim();}

    public void fillFieldInvestir(String investimento){inputAplicarValor.sendKeys(investimento);}

    public void fillFieldPoupar(String poupar){inputPouparValor.sendKeys(poupar);}

    public void fillFIedlTempo(String tempo){inputPouparTempo.sendKeys(tempo);}

    public void clickSimulador(){btnSimulador.click();}

    public void clickEmpresa(){radioEmpresa.click();}

    public boolean valorVisivel(){return waitElement("css", ".valor");}

    public boolean tabelaResultadoVisivel(){
        return waitElement("css", "div.maisOpcoes > table");
    }

    public boolean btnRefazerClicavel(){
        return  waitElement("click", ".btnRefazer");
    }

    public void selecionarAnos(){
        btnCheckList.click();
        waitElement("css", "ul.listaSelect > li:nth-child(2)");
        listaAno.click();
    }

    public String textErrorValorAplicado(){
        waitElement("id", "valorAplicar-error");
        return erroAplicar.getText().trim();
    }

    public String textErrorValorPoupado(){
        waitElement("id", "valorInvestir-error");
        return erroPoupar.getText().trim();
    }

    public String txtErrorTempo(){
        waitElement("id","tempo-error");
        return errorTempo.getText().trim();
    }
}
