package atividade3.pages;

import org.openqa.selenium.WebDriver;

import atividade3.uimaps.InicioMap;

public class InicioPage {
	WebDriver driver;

	public InicioPage(WebDriver driver) {
		this.driver = driver;
	}

	InicioMap inicioMap = new InicioMap(driver);
	
	public void selecionarTipoFormulario() {
		
	}
}
