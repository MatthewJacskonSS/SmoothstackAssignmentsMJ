package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {
	public BookingGuestDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBookingGuest(BookingGuest BookingGuest) throws ClassNotFoundException, SQLException {
		save("insert into Booking_Guest VALUES (?,?,?)", new Object[] { BookingGuest.getBooking_id(), BookingGuest.getContact_email(), BookingGuest.getContact_phone() });
	}

	public void updateBookingGuest(BookingGuest BookingGuest) throws ClassNotFoundException, SQLException {
		save("update Booking_Guest set contact_email = ? and contact_phone = ? where id = ?", new Object[] { BookingGuest.getContact_email(), BookingGuest.getContact_phone(), BookingGuest.getBooking_id() });

	}

	public void deleteBookingGuest(BookingGuest BookingGuest) throws ClassNotFoundException, SQLException {
		save("delete from Booking_Guest where booking_id = ?", new Object[] { BookingGuest.getBooking_id() });

	}

	public List<BookingGuest> readAllBookingGuest(BookingGuest BookingGuest) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_Guest", null);

	}

	public List<BookingGuest> readBookingGuestByID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_Guest where Booking_id like ?", new Object[] { id });
	}

	public List<BookingGuest> readBookingGuestByPhone(String code) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_Guest where contact_phone like ?", new Object[] {code});
	}

	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> BookingGuests = new ArrayList<>();
		while (rs.next()) {
			BookingGuest a = new BookingGuest();
			a.setBooking_id(rs.getInt("booking_id"));
			a.setContact_email(rs.getString("contact_email"));
			a.setContact_phone(rs.getString("contact_phone"));
			BookingGuests.add(a);
		}
		return BookingGuests;
	}
}
