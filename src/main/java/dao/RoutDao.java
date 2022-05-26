package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import models.City;
import models.Rout;

public class RoutDao extends MySQLConnection{
	private static CityDao cityDao = CityDao.getInstance();

	public RoutDao() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		super();
	}
	
	public static RoutDao getInstance()  {
		try {
			return new RoutDao();
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
	
	
	public Rout findRout(City c1 ,City c2) {
		Rout rout = null;
		String sql = String.format("SELECT * FROM ROUTES WHERE (city1=%d AND city2=%d) OR (city1=%d AND city2=%d)",c1.getId(),c2.getId(),c2.getId(),c1.getId());
 		try {
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			rout = new Rout(resultSet.getInt(1),c1,c2,resultSet.getDouble(4));
			
		} catch (SQLException e) {
			return rout;
		}
		
		return rout;
		
	}
	
	public ArrayList<Rout> findRouts(City c ) {
		ArrayList<Rout> routs = new ArrayList<>();
		
		String sql = String.format("SELECT * FROM ROUTES WHERE city1=%d OR city2=%d",c.getId(),c.getId());
 		try {
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				City c1 = cityDao.getCityById(resultSet.getInt(3));
				City c2 = cityDao.getCityById(resultSet.getInt(2));
				
				if( c.equals(c1) ) 	routs.add(new Rout(resultSet.getInt(1),c1, c2,resultSet.getDouble(4)));	
				else routs.add(new Rout(resultSet.getInt(1),c2, c1,resultSet.getDouble(4)));
				
				
			}
			
		} catch (SQLException e) {
			return routs;
		}
		
		return routs;
		
	}
	
	
	public ArrayList<City> findTargetsCities(City c){
		
		ArrayList<City> cities = new ArrayList<>();
		ArrayList<Rout> routs = this.findRouts(c);;
 		for(Rout rout:routs) cities.add(rout.getTarget());
			

		return cities;
	}
	
	public ArrayList<Rout> findAll() {
		ArrayList<Rout> routs = new ArrayList<>();
		
		String sql = "SELECT * FROM ROUTES";
 		try {
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				

				routs.add(new Rout(resultSet.getInt(1),cityDao.getCityById(resultSet.getInt(2)),cityDao.getCityById(resultSet.getInt(3)),resultSet.getDouble(4)));
				
			}
			
		} catch (SQLException e) {
			return routs;
		}
		
		return routs;
		
	}
	
	
	

}
