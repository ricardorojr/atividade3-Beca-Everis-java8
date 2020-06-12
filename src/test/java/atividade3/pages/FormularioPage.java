package atividade3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atividade3.uimaps.FormularioMap;

public class FormularioPage {
	WebDriver driver;

	public FormularioPage(WebDriver driver) {
		this.driver = driver;
	}

	FormularioMap formularioMap = new FormularioMap(driver);

	public void preencherFormulario() {

		formularioMap.preenchebusca.sendKeys(driver, "Capa Targus Ipad Mini Rotating Versavu THZ668 Grafite ");
		formularioMap.btnBuscar.click(driver);
		formularioMap.linkProduto.click(driver);
		formularioMap.preencheCep.sendKeys(driver, "38413-108");
		formularioMap.btnFrete.click(driver);
		formularioMap.frete1.getValue();
		formularioMap.frete2.getValue();
		formularioMap.frete3.getValue();
	}

	public void validarMensagemSucesso() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete1.getValue())));
			String frete1 = driver.findElement(By.xpath(formularioMap.frete1.getValue())).getText();
			System.out.println(frete1);
			Assert.assertEquals("Erro ao ao validar botao da mensagem de sucesso!", "R$ 23,39", frete1);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete2.getValue())));
			String frete2 = driver.findElement(By.xpath(formularioMap.frete2.getValue())).getText();
			System.out.println(frete2);
			Assert.assertEquals("Erro ao ao validar botao da mensagem de sucesso!", "R$ 40,97", frete2);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete3.getValue())));
			String frete3 = driver.findElement(By.xpath(formularioMap.frete3.getValue())).getText();
			System.out.println(frete3);
			Assert.assertEquals("Erro ao ao validar botao da mensagem de sucesso!", "R$ 51,79", frete3);

			System.out.println("Sucesso");
		} catch (Exception e) {
			System.out.println("Falha");
		}
	}
}