package atividade3.pages;

import java.util.ArrayList;

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

		// preenche para buscar o produto
		formularioMap.preenchebusca.sendKeys(driver, "Capa Targus Ipad Mini Rotating Versavu THZ668 Grafite");

		// clica no botao buscar
		formularioMap.btnBuscar.click(driver);

		// clica link do produto
		formularioMap.linkProduto.click(driver);
		try {
			Thread.sleep(2000);

		// preenche o cep
		formularioMap.preencheCep.sendKeys(driver, "38413-108");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// clica no botao frete
		formularioMap.btnFrete.click(driver);
		
		//pega valor do frete
		formularioMap.frete("23,17");
		formularioMap.frete("40,75");
		formularioMap.frete("51,67");
		
		
	}

	// compara os valores da lista de exercicio com os valores do frete da pagina
	public void validarMensagemSucesso() {
		ArrayList valores = new ArrayList();
		valores.add("R$ 23,17");
		valores.add("R$ 40,75");
		valores.add("R$ 51,67");
		ArrayList lista = new ArrayList();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete("23,17").getValue())));
			lista.add(driver.findElement(By.xpath(formularioMap.frete("23,17").getValue())).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete("40,75").getValue())));
			lista.add(driver.findElement(By.xpath(formularioMap.frete("40,75").getValue())).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.frete("51,67").getValue())));
			lista.add(driver.findElement(By.xpath(formularioMap.frete("51,67").getValue())).getText());
			for (int i = 0; i<lista.size(); i++) {
			System.out.println(lista.get(i));
			}
			valores.equals(lista);

			System.out.println("Sucesso");
		} catch (Exception e) {
			System.out.println("Falha");
		}
	}
}