package dao;

import java.sql.SQLException;


import models.User;

public class UserDao extends MySQLConnection {

	public UserDao() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		super();
	}

	public static UserDao getInstance()  {
		try {
			return new UserDao();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public User login(String username,String password) {
		
	
		return null;	
	}
	
	
	public User findByUserName(String username) {

		return null;
	}
	
	public User save(User user) {


		return user;
	}
	
}
