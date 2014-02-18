package es.uniovi.asw.observaTerra;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Driver {

	public static void main(String[] args) throws Exception {
		final String xlsFile = "test.xlsx"; 
		InputStream is = new Driver().getClass().getClassLoader().getResourceAsStream(xlsFile);
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheetAt(0);
		 
		ObservationList observations = new ObservationList();

		for (Row row: sheet) {
			String countryName 	= "";
			Double value 		= 0.0;

			for (Cell cell : row) {
				if (cell.getColumnIndex() == 0) {
					countryName = cell.getStringCellValue();
				}
				if (cell.getColumnIndex() == 1 ) {
					value = cell.getNumericCellValue();
				}
			}
			if (!countryName.equals("")) 
				observations.addObservation(new Country(countryName), value);
		}
        System.out.println(observations.show());
		System.out.println("Average = " + observations.average());
		 
		
	}

}
