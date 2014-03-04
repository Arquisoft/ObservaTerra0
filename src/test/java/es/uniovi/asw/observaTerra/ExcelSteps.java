package es.uniovi.asw.observaTerra;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;


public class ExcelSteps {

private final ExcelReader reader = new ExcelReader();

private InputStream input;
private ObservationList obsList;

@Dado("^que obtengo la hoja excel (.+)$")
public void que_obtengo_la_hoja_excel(String xlsFile) throws Throwable {
	input = new ExcelSteps().getClass().getClassLoader()
			.getResourceAsStream(xlsFile);
}

@Cuando("^leo las observaciones$")
public void leo_las_observaciones() throws Throwable {
	obsList = reader.read(input);
}

@Entonces("^el número de observaciones es (\\d+)$")
public void el_número_de_observaciones_es(int expected) throws Throwable {
    assertEquals(obsList.length(),expected);   
}

@Entonces("^el valor medio es (.+)$")
public void el_valor_medio_es_(Double expected) throws Throwable {
	assertEquals(obsList.average(),expected,0.001);
}

}