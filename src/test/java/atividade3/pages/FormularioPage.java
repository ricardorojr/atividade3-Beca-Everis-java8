package atividade3.pages;

import java.util.ArrayList;

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
		try {
			Thread.sleep(4000);
			formularioMap.preencheCep.sendKeys(driver, "38413108");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		formularioMap.btnFrete.click(driver);
		formularioMap.frete1.getValue();
		formularioMap.frete2.getValue();
		formularioMap.frete3.getValue();
	}

	public void validarMensagemSucesso() {//"R$ 51,79""R$ 40,97""R$ 23,39"
		ArrayList valores = new ArrayList(); 
		valores.add("R$ 51,79");
		valores.add("R$ 40,97");
		valores.add("R$ 23,39");
		ArrayList lista = new ArrayList();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete1.getValue())));
			lista.add(driver.findElement(By.xpath(formularioMap.frete1.getValue())).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete2.getValue())));
			lista.add(driver.findElement(By.xpath(formularioMap.frete2.getValue())).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete3.getValue())));
			lista.add(driver.findElement(By.xpath(formularioMap.frete3.getValue())).getText());
			System.out.println(lista);
			valores.equals(lista);
			
			System.out.println("Sucesso");
		} catch (Exception e) {
			System.out.println("Falha");
		}
	}
}