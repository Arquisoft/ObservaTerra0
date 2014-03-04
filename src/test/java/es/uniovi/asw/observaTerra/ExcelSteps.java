package es.uniovi.asw.observaTerra;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import static org.junit.Assert.assertEquals;


public class ExcelSteps {

private final ExcelReader reader = new ExcelReader();

private ObservationList obsList;
private Double resultado;

@Dado("^que obtengo la hoja excel (.+)$")
public void que_obtengo_la_hoja_excel(String xlsFile) throws Throwable {
	obsList = reader.read(new ExcelSteps().getClass().getClassLoader()
				.getResourceAsStream(xlsFile));
}

@Cuando("^calculo el valor medio$")
public void calculo_el_valor_medio() throws Throwable {
	resultado = obsList.average();
}

@Entonces("^el resultado es (.+)$")
public void el_resultado_es(Double expected) throws Throwable {
	assertEquals(resultado,expected,0.001);
}

}