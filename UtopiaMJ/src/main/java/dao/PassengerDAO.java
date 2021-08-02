package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {
	public PassengerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addPassenger(Passenger Passenger) throws ClassNotFoundException, SQLException {
		save("insert into Passenger VALUES (?,?,?,?,?,?,?)", new Object[] {0, Passenger.getBooking_id(), Passenger.getGiven_name(), Passenger.getFamily_name(), Passenger.getDob(), Passenger.getGender(), Passenger.getAddress() });
	}

	public void updatePassenger(Passenger Passenger) throws ClassNotFoundException, SQLException {
		save("update Passenger set given_name = ? and family_name = ? and dob = ? and gender = ? and address = ? where id = ?", new Object[]  {Passenger.getGiven_name(), Passenger.getFamily_name(), Passenger.getDob(), Passenger.getGender(), Passenger.getAddress(), Passenger.getId() });

	}

	public void deletePassenger(Passenger Passenger) throws ClassNotFoundException, SQLException {
		save("delete from Passenger where id = ?", new Object[] { Passenger.getId() });

	}

	public List<Passenger> readAllPassenger(Passenger Passenger) throws ClassNotFoundException, SQLException {
		return read("Select * from Passenger", null);

	}

	public List<Passenger> readPassengerByID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Passenger where id like ?", new Object[] { id });
	}

	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> Passengers = new ArrayList<>();
		while (rs.next()) {
			Passenger a = new Passenger();
			a.setId(rs.getInt("id"));
			a.setBooking_id(rs.getInt("booking_id"));
			a.setGiven_name(rs.getString("given_name"));
			a.setFamily_name(rs.getString("family_name"));
			a.setDob(rs.getDate("dob"));
			a.setGender(rs.getString("gender"));
			a.setAddress(rs.getString("address"));
			Passengers.add(a);
		}
		return Passengers;
	}
}
