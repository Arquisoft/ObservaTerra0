package es.uniovi.asw.buscador;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;


public class BuscadorSteps {
	
	WebDriver driver = new HtmlUnitDriver();
	WebElement element ;
	
	@Dado("^que estoy en la página (.+)$")
	public void que_estoy_en_la_página(String uri) throws Throwable {
		driver.get("http://www.google.com");
	}

	@Cuando("^tecleo (.+)$")
	public void tecleo(String str) throws Throwable {
		element = driver.findElement(By.name("q"));
		element.sendKeys(str);
        element.submit();
	}

	@Entonces("^obtengo una página que contiene (.+)$")
	public void obtengo_resultados_con_el_texto(String txt) throws Throwable {
		assertTrue("Page must contain " + txt, driver.getPageSource().contains(txt));
	}
}