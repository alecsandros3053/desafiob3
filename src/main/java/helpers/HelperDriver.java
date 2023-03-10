package helpers;

import webdriver.Driver;

import java.util.ArrayList;
import java.util.List;

public class HelperDriver {

    public static void inicializar() {
        Driver.getDriver().get(HelperLerProperties.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
    }

    public static void finalizar() {
        if (Driver.getDriver() != null) {
            Driver.getDriver().quit();
            Driver.setDriver(null);
        }
    }

    public static void trocarPagina(int janela){
        List<String> abas = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(abas.get(janela));
    }
}
