package tests;


import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageObjects.SimuladorInvestimentoPage;
import utils.Browser;

import java.util.Random;


public class SimuladorInvestimentoTest extends BaseTest {
    @Test
    public void testSimularVoceMeses(){
        SimuladorInvestimentoPage investimentoPage = new SimuladorInvestimentoPage();
        PageFactory.initElements(Browser.getCurrentDriver(), investimentoPage);
        String tempoMeses = "23";

        investimentoPage.fillFIedlTempo(tempoMeses);
        investimentoPage.fillFieldInvestir("100000");
        investimentoPage.fillFieldPoupar("5000000");
        investimentoPage.clickSimulador();

        assertTrue(investimentoPage.tabelaResultadoVisivel());
        assertTrue(investimentoPage.btnRefazerClicavel());

        assertEquals(investimentoPage.textMeses(),tempoMeses + " meses");
        assertTrue(investimentoPage.valorVisivel());
    }

    @Test
    public void testSimularVoceAnos(){
        SimuladorInvestimentoPage investimentoPage = new SimuladorInvestimentoPage();
        PageFactory.initElements(Browser.getCurrentDriver(), investimentoPage);
        int tempoAnos = 5;
        int tempoMeses = 5 * 12;

        investimentoPage.fillFIedlTempo(String.format("%s", tempoAnos));
        investimentoPage.fillFieldInvestir("100000");
        investimentoPage.fillFieldPoupar("5000000");
        investimentoPage.selecionarAnos();
        investimentoPage.clickSimulador();

        assertTrue(investimentoPage.tabelaResultadoVisivel());
        assertTrue(investimentoPage.btnRefazerClicavel());
        assertEquals(investimentoPage.textMeses(),tempoMeses + " meses");
        assertTrue(investimentoPage.valorVisivel());
    }

    @Test
    public void testSimularEmpresaMeses(){
        SimuladorInvestimentoPage investimentoPage = new SimuladorInvestimentoPage();
        PageFactory.initElements(Browser.getCurrentDriver(), investimentoPage);
        String tempoMeses = "23";

        investimentoPage.clickEmpresa();
        investimentoPage.fillFIedlTempo(tempoMeses);
        investimentoPage.fillFieldInvestir("100000");
        investimentoPage.fillFieldPoupar("5000000");
        investimentoPage.clickSimulador();

        assertTrue(investimentoPage.tabelaResultadoVisivel());

        assertTrue(investimentoPage.btnRefazerClicavel());
        assertEquals(investimentoPage.textMeses(),tempoMeses + " meses");
        assertTrue(investimentoPage.valorVisivel());
    }

    @Test
    public void testSimularEmpresaAnos(){
        SimuladorInvestimentoPage investimentoPage = new SimuladorInvestimentoPage();
        PageFactory.initElements(Browser.getCurrentDriver(), investimentoPage);
        int tempoAnos = 5;
        int tempoMeses = 5 * 12;

        investimentoPage.clickEmpresa();
        investimentoPage.fillFIedlTempo(String.format("%s", tempoAnos));
        investimentoPage.fillFieldInvestir("100000");
        investimentoPage.fillFieldPoupar("5000000");
        investimentoPage.selecionarAnos();

        investimentoPage.clickSimulador();

        assertTrue(investimentoPage.tabelaResultadoVisivel());
        assertTrue(investimentoPage.btnRefazerClicavel());

        assertEquals(investimentoPage.textMeses(),tempoMeses + " meses");
        assertTrue(investimentoPage.valorVisivel());
    }

    @Test
    public void testValoresAbaixoMinimo(){
        SimuladorInvestimentoPage investimentoPage = new SimuladorInvestimentoPage();
        PageFactory.initElements(Browser.getCurrentDriver(), investimentoPage);
        Random random = new Random();

        double num = random.nextDouble() * 19.99;

        investimentoPage.fillFieldPoupar(String.format("%.2f", num));
        investimentoPage.fillFieldInvestir(String.format("%.2f", num));

        investimentoPage.clickSimulador();

        assertEquals(investimentoPage.textErrorValorAplicado(), "Valor mínimo de 20.00");
        assertEquals(investimentoPage.textErrorValorPoupado(), "Valor mínimo de 20.00");
        assertEquals(investimentoPage.txtErrorTempo(), "Obrigatório");
    }

    @Test
    public void testValoresAcimaMaximo(){
        SimuladorInvestimentoPage investimentoPage = new SimuladorInvestimentoPage();
        PageFactory.initElements(Browser.getCurrentDriver(), investimentoPage);

        investimentoPage.fillFieldPoupar("999.999.999.999.999.000,00");
        investimentoPage.fillFieldInvestir("999.999.999.999.999.000,00");
        investimentoPage.selecionarAnos();
        investimentoPage.fillFIedlTempo("100");

        investimentoPage.clickSimulador();

        assertEquals(investimentoPage.textErrorValorAplicado(), "Máximo de 9999999.00");
        assertEquals(investimentoPage.textErrorValorPoupado(), "Máximo de 9999999.00");
        assertEquals(investimentoPage.txtErrorTempo(), "Valor esperado não confere");
    }

}
