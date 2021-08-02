package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Flight;

public class FlightDAO extends BaseDAO<Flight> {
	public FlightDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addFlight(Flight Flight) throws ClassNotFoundException, SQLException {
		save("insert into Flight VALUES (?,?,?,?,?,?)", new Object[] { Flight.getId(), Flight.getRoute_id(), Flight.getAirplane_id(), Flight.getDeparture_time(), Flight.getReserved_seat(), Flight.getSeat_price() });
	}

	public void updateFlight(Flight Flight) throws ClassNotFoundException, SQLException {
		save("update Flight set departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?", new Object[] {Flight.getDeparture_time(), Flight.getReserved_seat(), Flight.getSeat_price(), Flight.getId() });

	}

	public void deleteFlight(Flight Flight) throws ClassNotFoundException, SQLException {
		save("delete from Flight where id = ?", new Object[] { Flight.getId() });

	}

	public List<Flight> readAllFlight() throws ClassNotFoundException, SQLException {
		return read("Select * from Flight", null);

	}

	public List<Flight> readFlightByID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Flight where id like ?", new Object[] { id });
	}

	public List<Flight> readFlightByRouteID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Flight where route_id like ?", new Object[] { id });
	}

	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> Flights = new ArrayList<>();
		while (rs.next()) {
			Flight a = new Flight();
			a.setId(rs.getInt("id"));
			a.setRoute_id(rs.getInt("route_id"));
			a.setAirplane_id(rs.getInt("airplane_id"));
			a.setDeparture_time(rs.getDate("departure_time"));
			a.setReserved_seat(rs.getInt("reserved_seats"));
			a.setSeat_price(rs.getFloat("seat_price"));
			Flights.add(a);
		}
		return Flights;
	}
}

