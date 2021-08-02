package beans;

public class Airport {
	@Override
	public String toString() {
		return "Airport [iata_id=" + iata_id + ", city=" + city + "]";
	}

	private String iata_id;
	private String city;

	public Airport(String iata_id, String city) {
		super();
		this.iata_id = iata_id;
		this.city = city;
	}

	public Airport() {
	}

	public String getIata_id() {
		return iata_id;
	}

	public void setIata_id(String iata_id) {
		this.iata_id = iata_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
