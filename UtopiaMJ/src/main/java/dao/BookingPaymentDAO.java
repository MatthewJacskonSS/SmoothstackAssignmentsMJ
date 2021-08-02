package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment> {
	public BookingPaymentDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBookingPayment(BookingPayment BookingPayment) throws ClassNotFoundException, SQLException {
		save("insert into Booking_Payment VALUES (?,?,?)", new Object[] { BookingPayment.getBooking_id(), BookingPayment.getStripe_id(), BookingPayment.isRefunded() });
	}

	public void updateBookingPayment(BookingPayment BookingPayment) throws ClassNotFoundException, SQLException {
		save("update Booking_Payment set is_refunded = ? where booking_id = ?", new Object[] { BookingPayment.isRefunded(), BookingPayment.getBooking_id() });

	}

	public void deleteBookingPayment(BookingPayment BookingPayment) throws ClassNotFoundException, SQLException {
		save("delete from Booking_Payment where booking_id = ?", new Object[] { BookingPayment.getBooking_id() });

	}

	public List<BookingPayment> readAllBookingPayment(BookingPayment BookingPayment) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_Payment", null);

	}

	public List<BookingPayment> readBookingPaymentByID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_Payment where booking_id like ?", new Object[] { id });
	}

	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> BookingPayments = new ArrayList<>();
		while (rs.next()) {
			BookingPayment a = new BookingPayment();
			a.setBooking_id(rs.getInt("booking_id"));
			a.setStripe_id(rs.getString("stripe_id"));
			a.setRefunded(rs.getBoolean("refunded"));
			BookingPayments.add(a);
		}
		return BookingPayments;
	}
}
