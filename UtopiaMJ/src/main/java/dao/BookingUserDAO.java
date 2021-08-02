package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookingUser;

public class BookingUserDAO extends BaseDAO<BookingUser> {
	public BookingUserDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBookingUser(BookingUser BookingUser) throws ClassNotFoundException, SQLException {
		save("insert into Booking_User VALUES (?,?)", new Object[] { BookingUser.getBooking_id(), BookingUser.getUser_id()});
	}

	public void updateBookingUser(BookingUser BookingUser) throws ClassNotFoundException, SQLException {
		//save("update BookingUser set is_active = ? where id = ?", new Object[] { BookingUser.isIs_active(), BookingUser.getId() });

	}

	public void deleteBookingUser(BookingUser BookingUser) throws ClassNotFoundException, SQLException {
		save("delete from Booking_User where id = ?", new Object[] { BookingUser.getBooking_id() });

	}

	public List<BookingUser> readAllBookingUser(BookingUser BookingUser) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_User", null);

	}

	public List<BookingUser> readBookingUserByBookingID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_User where booking_id like ?", new Object[] { id });
	}

	public List<BookingUser> readBookingUserByUserID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_User where User_id like ?", new Object[] {id});
	}

	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> BookingUsers = new ArrayList<>();
		while (rs.next()) {
			BookingUser a = new BookingUser();
			a.setBooking_id(rs.getInt("booking_id"));
			a.setUser_id(rs.getInt("User_id"));
			BookingUsers.add(a);
		}
		return BookingUsers;
	}
}
