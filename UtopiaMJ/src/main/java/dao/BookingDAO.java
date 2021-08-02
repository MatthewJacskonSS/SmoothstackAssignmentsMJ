package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Booking;

public class BookingDAO extends BaseDAO<Booking> {
	public BookingDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public Integer addBooking(Booking Booking) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into Booking VALUES (?, ?,?)", new Object[] {0, Booking.isIs_active(), Booking.getConfirmation_code() });
		
	}

	public void updateBooking(Booking Booking) throws ClassNotFoundException, SQLException {
		save("update Booking set is_active = ? where id = ?", new Object[] { Booking.isIs_active(), Booking.getId() });

	}

	public void deleteBooking(Booking Booking) throws ClassNotFoundException, SQLException {
		save("delete from Booking where id = ?", new Object[] { Booking.getId() });

	}

	public List<Booking> readAllBooking(Booking Booking) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking", null);

	}

	public List<Booking> readBookingByID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking where id like ?", new Object[] { id });
	}

	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> Bookings = new ArrayList<>();
		while (rs.next()) {
			Booking a = new Booking();
			a.setId(rs.getInt("id"));
			a.setIs_active(rs.getBoolean("is_active"));
			a.setConfirmation_code(rs.getString("confirmation_code"));
			Bookings.add(a);
		}
		return Bookings;
	}
}
