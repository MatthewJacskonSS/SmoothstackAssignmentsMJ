package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class UserDAO extends BaseDAO<User> {
	public UserDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addUser(User User) throws ClassNotFoundException, SQLException {
		save("insert into User VALUES (?,?,?)", new Object[] { User.getId(), User.getRole_id(), User.getGiven_name(), User.getFamily_name(), User.getUsername(), User.getEmail(), User.getEmail(), User.getPassword(), User.getPhone()});
	}

	public void updateUser(User User) throws ClassNotFoundException, SQLException {
		save("update User set given_name = ? and family_name = ? and username = ?, and email = ?, and password = ?, and phone = ? where id = ?", new Object[] {User.getGiven_name(), User.getFamily_name(), User.getUsername(), User.getEmail(), User.getEmail(), User.getPassword(), User.getPhone(), User.getId()});

	}

	public void deleteUser(User User) throws ClassNotFoundException, SQLException {
		save("delete from User where id = ?", new Object[] { User.getId() });

	}

	public List<User> readAllUser() throws ClassNotFoundException, SQLException {
		return read("Select * from User", null);

	}

	public User readUserByID(int id) throws ClassNotFoundException, SQLException {
		//Needs fixing to actually throw
		
		try {
			return read("Select * from User where id like ?", new Object[] { id }).get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<User> readUserByUsername(String un) throws ClassNotFoundException, SQLException {
		return read("Select * from User where username like ?", new Object[] { un });
	}

	public List<User> readUserByEmail(String Email) throws ClassNotFoundException, SQLException {
		return read("Select * from User where email like ?", new Object[] { Email });
	}
	
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> Users = new ArrayList<>();
		while (rs.next()) {
			User a = new User();
			a.setId(rs.getInt("id"));
			a.setRole_id(rs.getInt("role_id"));
			a.setGiven_name(rs.getString("given_name"));
			a.setFamily_name(rs.getString("family_name"));
			a.setUsername(rs.getString("username"));
			a.setEmail(rs.getString("email"));
			a.setPassword(rs.getString("password"));
			a.setPhone(rs.getString("phone"));
			Users.add(a);
		}
		return Users;
	}
}
