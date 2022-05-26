package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import models.City;

public class CityDao extends MySQLConnection{

	public CityDao() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		super(); 
	}
	

	public static CityDao getInstance()  {
		try {
			return new CityDao();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<City> findAll() {
		ArrayList<City> list=new ArrayList<>();
		try {
			resultSet = statement.executeQuery("SELECT * FROM CITIES");
			
			while (resultSet.next()) {
				list.add(new City(resultSet.getInt(1),resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4)));
			}
			
		} catch (SQLException e) {
			return list;
		}
		
		
		return list;
	}
	
	public City findByName(String name) {
		City c=null;
		
		String sql ="SELECT * FROM CITIES WHERE NAME='"+name+"'";
		try {
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			c=new City(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4));
			
		} catch (SQLException e) {
			return c;
		}
		return c;
	}
	
	public City getCityById(int id)  {
		
		try {
			resultSet=statement.executeQuery("SELECT * FROM CITIES WHERE ID="+id);
			resultSet.next();
			return new City(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<City> finds(String name){
		ArrayList<City> list=new ArrayList<>();
		try {
			resultSet = statement.executeQuery("SELECT * FROM CITIES WHERE NAME LIKE '%"+name+"%' LIMIT 5");
			
			while (resultSet.next()) {
				list.add(new City(resultSet.getInt(1),resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4)));
			}
			
		} catch (SQLException e) {
			return list;
		}
		
		
		return list;
	}
}
