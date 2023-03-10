package pages;

import helpers.HelperDriver;
import helpers.HelperWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.Driver;

public class HomePage {

    @FindBy(id = "btnCookie")
    private WebElement btnAceito;

    @FindBy(id = "relaxation")
    private WebElement txtCep;

    @FindBy(id = "mensagem-resultado")
    private WebElement mensagemResultado;

    @FindBy(xpath = "//*[@id='resultado-DNEC']/tbody/tr/td[1]")
    private WebElement linhaEnderecoPesquisa;

    @FindBy(id = "objetos")
    private WebElement rastreamento;

    @FindBy(id = "b-pesquisar")
    private WebElement pesquisarRastreamento;

    @FindBy(className = "mensagem")
    private WebElement mensagemCaptcha;


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clicarAceito(){
        btnAceito.click();
    }

    public void digitarCEP(String valor){
       txtCep.sendKeys(valor);
    }

    public void clicarPesquisarCEP(){
        txtCep.sendKeys(Keys.ENTER);
    }

    public void clicarRastreamento(){
        rastreamento.sendKeys(Keys.ENTER);
    }

    public void fecharGuia(){
        Driver.getDriver().close();
    }

    public void limparCampoCep(){
        txtCep.clear();
    }

    public boolean validarBotaoAceitoVisible(){
        return (HelperWait.waitVisible(btnAceito, 10) != null);
    }

    public String mensagemResultadoPesquisa(){
        HelperWait.waitPresenceOfElement(mensagemResultado, 10);
        return mensagemResultado.getText();
    }

    public String textoEnderecoSucesso(){
        HelperWait.waitPresenceOfElement(linhaEnderecoPesquisa, 10);
        return linhaEnderecoPesquisa.getText();
    }

    public void preencherRastreamento(String texto){
        rastreamento.sendKeys(texto);
    }

    public void clicarPesquisarRastreamento(){
        HelperWait.waitClicable(pesquisarRastreamento, 10);
        pesquisarRastreamento.click();
    }

    public String mensagemCatpcha(){
        HelperWait.waitVisible(mensagemCaptcha, 10);
        return mensagemCaptcha.getText();
    }
}
