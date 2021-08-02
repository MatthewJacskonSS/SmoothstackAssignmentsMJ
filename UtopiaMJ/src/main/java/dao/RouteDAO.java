package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Route;

public class RouteDAO extends BaseDAO<Route> {
	public RouteDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addRoute(Route Route) throws ClassNotFoundException, SQLException {
		save("insert into Route VALUES (?,?,?)", new Object[] { Route.getId(), Route.getOrigin_id(), Route.getDestination_id()});
	}

	public void updateRoute(Route Route) throws ClassNotFoundException, SQLException {
		save("update Route set origin_id = ? and destination_id = ? where id = ?", new Object[] { Route.getOrigin_id(), Route.getDestination_id(), Route.getId() });

	}

	public void deleteRoute(Route Route) throws ClassNotFoundException, SQLException {
		save("delete from Route where id = ?", new Object[] { Route.getId() });

	}

	public List<Route> readAllRoute() throws ClassNotFoundException, SQLException {
		return read("Select * from Route", null);

	}

	public Route readRouteByID(int id) throws ClassNotFoundException, SQLException {
		return read("Select * from Route where id like ?", new Object[] { id }).get(0);
	}
	
	public List<Route> readRouteByOrigin(String id) throws ClassNotFoundException, SQLException {
		return read("Select * from Route where origin_id like ?", new Object[] { id });
	}

	public List<Route> readRouteByDestination(String id) throws ClassNotFoundException, SQLException {
		return read("Select * from Route where destination_id like ?", new Object[] { id });
	}
	
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> Routes = new ArrayList<>();
		while (rs.next()) {
			Route a = new Route();
			a.setId(rs.getInt("id"));
			a.setOrigin_id(rs.getString("origin_id"));
			a.setDestination_id(rs.getString("destination_id"));
			Routes.add(a);
		}
		return Routes;
	}
}
