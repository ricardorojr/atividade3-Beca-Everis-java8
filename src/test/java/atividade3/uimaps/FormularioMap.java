package atividade3.uimaps;

import org.openqa.selenium.WebDriver;

import atividade3.core.Element;
import atividade3.enums.ByValue;

public class FormularioMap {
	WebDriver driver;

	public FormularioMap(WebDriver driver) {
		this.driver = driver;

	}	
	
	//mapeia a o campo busca
	public Element preenchebusca = new Element(driver, ByValue.XPATH, "//input[@class='sprocura']");
	
	//mapeia o botao buscar
	public Element btnBuscar = new Element(driver, ByValue.ID, "bt-busca");
	
	//mapeia o link do produto
	public Element linkProduto = new Element(driver, ByValue.XPATH, "//div[@class='sc-fzozJi dIEkef']//a");
	
	//mapeia o cep
	public Element preencheCep = new Element(driver, ByValue.ID, "calc_cep");
	
	//mapeia o botao do frete
	public Element btnFrete = new Element(driver, ByValue.XPATH, "//input[@class='button-calcula-cep']");
	
	//mapeia a primeira opcao de frete
	public Element frete1 = new Element(driver, ByValue.XPATH, "//td[text()='até 11 dias úteis']//following-sibling::td");
	
	//mapeia a segunda opcao de frete
	public Element frete2 = new Element(driver, ByValue.XPATH, "//td[text()='até 5 dias úteis']//following-sibling::td");
	
	//mapeia a terceira opcao de frete
	public Element frete3 = new Element(driver, ByValue.XPATH, "//td[text()='até 6 dias úteis']//following-sibling::td");	
	
}