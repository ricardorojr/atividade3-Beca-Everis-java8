package atividade3.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import atividade3.core.Driver;
import atividade3.pages.FormularioPage;
import atividade3.pages.InicioPage;

public class CT01 {
	WebDriver driver;
	InicioPage inicioPage;
	FormularioPage formularioPage;
	
	@Before
	public void before() {
		driver = new Driver().getDriver();
		Driver.acessoURL(driver, "https://www.kabum.com.br/");
		inicioPage = new InicioPage(driver);
		formularioPage = new FormularioPage(driver);
	}
	
	@Test
	public void test() {
		formularioPage.preencherFormulario();
		formularioPage.validarMensagemSucesso();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@After	
	public void after() {
		Driver.close(driver);
	}
}
