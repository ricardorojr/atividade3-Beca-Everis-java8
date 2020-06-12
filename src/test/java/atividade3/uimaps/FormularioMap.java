package atividade3.uimaps;

import org.openqa.selenium.WebDriver;

import atividade3.core.Element;
import atividade3.enums.ByValue;

public class FormularioMap {
	WebDriver driver;

	public FormularioMap(WebDriver driver) {
		this.driver = driver;

	}

	public Element preenchebusca = new Element(driver, ByValue.XPATH, "//input[@class='sprocura']");
	public Element btnBuscar = new Element(driver, ByValue.ID, "bt-busca");
	public Element linkProduto = new Element(driver, ByValue.XPATH, "//div[@class='sc-fzozJi dIEkef']//a");
	public Element preencheCep = new Element(driver, ByValue.ID, "calc_cep");
	public Element btnFrete = new Element(driver, ByValue.XPATH, "//input[@class='button-calcula-cep']");
	public Element frete1 = new Element(driver, ByValue.XPATH, "//td[text()='até 11 dias úteis']//following-sibling::td");
	public Element frete2 = new Element(driver, ByValue.XPATH, "//td[text()='até 5 dias úteis']//following-sibling::td");
	public Element frete3 = new Element(driver, ByValue.XPATH, "//td[text()='até 6 dias úteis']//following-sibling::td");
	
}