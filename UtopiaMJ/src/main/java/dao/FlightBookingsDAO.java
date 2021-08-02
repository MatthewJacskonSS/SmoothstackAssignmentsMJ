
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.FlightBookings;

public class FlightBookingsDAO extends BaseDAO<FlightBookings> {
	public FlightBookingsDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addFlightBookings(FlightBookings FlightBookings) throws ClassNotFoundException, SQLException {
		//save("insert into Flight_Bookings VALUES (?,?)", new Object[] { FlightBookings.getFlight_id(), FlightBookings.getBooking_id() });
	}

	public void updateFlightBookings(FlightBookings FlightBookings) throws ClassNotFoundException, SQLException {
		//save("update Flight_Bookings set type_id = ? where id = ?", new Object[] { FlightBookings.getType_id(), FlightBookings.getId() });

	}

	public void deleteFlightBookings(FlightBookings FlightBookings) throws ClassNotFoundException, SQLException {
		save("delete from Flight_Bookings where id = ?", new Object[] { FlightBookings.getFlight_id() });

	}

	public List<FlightBookings> readAllFlightBookings(FlightBookings FlightBookings) throws ClassNotFoundException, SQLException {
		return read("Select * from Flight_Bookings", null);

	}

	public List<FlightBookings> readFlightBookingsByFlightID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Flight_Bookings where flight_id like ?", new Object[] { id });
	}

	public List<FlightBookings> readFlightBookingsByTypeBookingID(int type) throws ClassNotFoundException, SQLException {
		return read("Select * from Flight_Bookings where booking_id like ?", new Object[] { type });
	}

	public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBookings> FlightBookingss = new ArrayList<>();
		while (rs.next()) {
			FlightBookings a = new FlightBookings();
			a.setFlight_id(rs.getInt("flight_id"));
			a.setBooking_id(rs.getInt("booking_id"));
			FlightBookingss.add(a);
		}
		return FlightBookingss;
	}
}
