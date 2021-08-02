package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Airplane;

public class AirplaneDAO extends BaseDAO<Airplane> {
	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	public void addAirplane(Airplane Airplane) throws ClassNotFoundException, SQLException {
		save("insert into Airplane VALUES (?,?)", new Object[] { Airplane.getId(), Airplane.getType_id() });
	}

	public void updateAirplane(Airplane Airplane) throws ClassNotFoundException, SQLException {
		save("update Airplane set type_id = ? where id = ?", new Object[] { Airplane.getType_id(), Airplane.getId() });

	}

	public void deleteAirplane(Airplane Airplane) throws ClassNotFoundException, SQLException {
		save("delete from Airplane where id = ?", new Object[] { Airplane.getId() });

	}

	public List<Airplane> readAllAirplane(Airplane Airplane) throws ClassNotFoundException, SQLException {
		return read("Select * from Airplane", null);

	}

	public List<Airplane> readAirplaneByID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Airplane where id like ?", new Object[] { id });
	}

	public List<Airplane> readAirplaneByTypeID(int type) throws ClassNotFoundException, SQLException {
		return read("Select * from Airplane where type_id like ?", new Object[] { type });
	}

	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> Airplanes = new ArrayList<>();
		while (rs.next()) {
			Airplane a = new Airplane();
			a.setId(rs.getInt("id"));
			a.setType_id(rs.getInt("Type_id"));
			Airplanes.add(a);
		}
		return Airplanes;
	}
}
