package tests;

import helpers.HelperDriver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.HomePage;


public class DesafioRunnerTest {

    HomePage homePage = new HomePage();

    @BeforeClass()
    public static void setup(){
        HelperDriver.inicializar();
    }

    @Test
    public void desafioCorreios(){

        if(homePage.validarBotaoAceitoVisible())
                homePage.clicarAceito();

        homePage.digitarCEP("80700000");
        homePage.clicarPesquisarCEP();
        HelperDriver.trocarPagina(1);
        Assert.assertEquals("Não há dados a serem exibidos", homePage.mensagemResultadoPesquisa());
        homePage.fecharGuia();
        HelperDriver.trocarPagina(0);
        homePage.limparCampoCep();
        homePage.digitarCEP("01013001");
        homePage.clicarPesquisarCEP();
        HelperDriver.trocarPagina(1);
        Assert.assertEquals("Rua Quinze de Novembro - lado ímpar", homePage.textoEnderecoSucesso());
        homePage.fecharGuia();
        HelperDriver.trocarPagina(0);
        homePage.preencherRastreamento("121212");
        homePage.clicarRastreamento();
        HelperDriver.trocarPagina(1);
        homePage.clicarPesquisarRastreamento();
        Assert.assertEquals("Código de objeto, CPF ou CNPJ informado não está válido", homePage.mensagemCatpcha());

    }

    @AfterClass
    public static void tearDown(){
        HelperDriver.finalizar();
    }

}
