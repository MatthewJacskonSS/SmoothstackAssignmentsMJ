package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookingAgent;

public class BookingAgentDAO extends BaseDAO<BookingAgent> {
	public BookingAgentDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBookingAgent(BookingAgent BookingAgent) throws ClassNotFoundException, SQLException {
		save("insert into Booking_Agent VALUES (?,?)", new Object[] { BookingAgent.getBooking_id(), BookingAgent.getAgent_id()});
	}

	public void updateBookingAgent(BookingAgent BookingAgent) throws ClassNotFoundException, SQLException {
		//save("update Booking_Agent set is_active = ? where id = ?", new Object[] { BookingAgent.isIs_active(), BookingAgent.getId() });

	}

	public void deleteBookingAgent(BookingAgent BookingAgent) throws ClassNotFoundException, SQLException {
		save("delete from Booking_Agent where id = ?", new Object[] { BookingAgent.getBooking_id() });

	}

	public List<BookingAgent> readAllBookingAgent(BookingAgent BookingAgent) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_Agent", null);

	}

	public List<BookingAgent> readBookingAgentByBookingID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_Agent where booking_id like ?", new Object[] { id });
	}

	public List<BookingAgent> readBookingAgentByAgentID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Booking_Agent where agent_id like ?", new Object[] {id});
	}

	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> BookingAgents = new ArrayList<>();
		while (rs.next()) {
			BookingAgent a = new BookingAgent();
			a.setBooking_id(rs.getInt("booking_id"));
			a.setAgent_id(rs.getInt("agent_id"));
			BookingAgents.add(a);
		}
		return BookingAgents;
	}
}
