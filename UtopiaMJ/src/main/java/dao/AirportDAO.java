package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Airport;

public class AirportDAO extends BaseDAO<Airport> {
	public AirportDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("insert into airport VALUES (?,?)", new Object[] { airport.getIata_id(), airport.getCity() });
	}

	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("update airport set city = ? where Iata_id = ?", new Object[] { airport.getCity(), airport.getIata_id() });

	}

	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("delete from airport where Iata_id = ?", new Object[] { airport.getIata_id() });

	}

	public List<Airport> readAllAirport() throws ClassNotFoundException, SQLException {
		return read("Select * from airport", null);

	}

	public List<Airport> readAirportsByCityName(String cityName) throws ClassNotFoundException, SQLException {
		cityName = "%" + cityName + "%";
		return read("Select * from airport where city like ?", new Object[] { cityName });
	}
	
	public List<Airport> readAirportsByID(String id) throws ClassNotFoundException, SQLException {
		return read("Select * from airport where iata_id like ?", new Object[] {id});
	}

	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		while (rs.next()) {
			Airport a = new Airport();
			a.setIata_id(rs.getString("iata_id"));
			a.setCity(rs.getString("city"));
			airports.add(a);
		}
		return airports;
	}
}
