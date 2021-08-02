package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.AirplaneType;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {
	public AirplaneTypeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addAirplaneType(AirplaneType AirplaneType) throws ClassNotFoundException, SQLException {
		save("insert into Airplane_Type VALUES (?,?)",
				new Object[] { AirplaneType.getId(), AirplaneType.getMax_capacity() });
	}

	public void updateAirplaneType(AirplaneType AirplaneType) throws ClassNotFoundException, SQLException {
		save("update Airplane_Type set max_capacity = ? where id = ?",
				new Object[] { AirplaneType.getMax_capacity(), AirplaneType.getId() });

	}

	public void deleteAirplaneType(AirplaneType AirplaneType) throws ClassNotFoundException, SQLException {
		save("delete from Airplane_Type where Iata_id = ?", new Object[] { AirplaneType.getId() });

	}

	public List<AirplaneType> readAllAirplaneType(AirplaneType AirplaneType)
			throws ClassNotFoundException, SQLException {
		return read("Select * from Airplane_Type", null);

	}

	public List<AirplaneType> readAirplaneTypesById(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Airplane_Type where id like ?", new Object[] { id });
	}

	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> AirplaneTypes = new ArrayList<>();
		while (rs.next()) {
			AirplaneType a = new AirplaneType();
			a.setId(rs.getInt("id"));
			a.setMax_capacity(rs.getInt("max_capacity"));
			AirplaneTypes.add(a);
		}
		return AirplaneTypes;
	}
}
