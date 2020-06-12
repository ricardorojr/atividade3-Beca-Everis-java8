package atividade3.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
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
		try {
			Thread.sleep(3000);
			formularioMap.preencheCep.sendKeys(driver, "38413108");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		formularioMap.btnFrete.click(driver);
		formularioMap.frete1.getValue();
		formularioMap.frete2.getValue();
		formularioMap.frete3.getValue();
	}

	public void validarMensagemSucesso() {
		List<String> ls = Arrays.asList("R$ 23,39", "R$ 40,97", "R$ 51,79" );
		List<String> resultado = Arrays.asList("");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete1.getValue())));
			resultado.add(driver.findElement(By.xpath(formularioMap.frete1.getValue())).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete2.getValue())));
			resultado.add(driver.findElement(By.xpath(formularioMap.frete2.getValue())).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete3.getValue())));
			resultado.add(driver.findElement(By.xpath(formularioMap.frete3.getValue())).getText());
			Assert.assertEquals(ls, resultado);
			System.out.println("Sucesso");
		} catch (Exception e) {
			System.out.println("Falha");
		}
	}
}