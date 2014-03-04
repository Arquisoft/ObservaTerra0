package es.uniovi.asw.observaTerra;

public class Country implements Comparable<Country>{
	private final String name;
	
	public Country(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int compareTo(Country other) {
       return name.compareTo(other.name);
    }
}
