package es.uniovi.asw.observaTerra;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ObservationListTest {
	
	@Test
	public void emptyObservationList_has_no_elements() {
		ObservationList obsList = new ObservationList();
	    assertThat(obsList.length()).isEqualTo(0);
	  }

	@Test
	public void averageObservationListWithOneElement_is_value() {
		ObservationList obsList = new ObservationList();
		Double value = 3.2 ;
		obsList.addObservation(new Country("Spain"),value);
	    assertThat(obsList.average()).isEqualTo(value);
	  }
}
