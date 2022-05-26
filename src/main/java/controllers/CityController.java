package controllers;

import java.io.IOException;
import java.util.ArrayList;

import dao.CityDao;
import dao.RoutDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.City;
import models.Rout;

public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final RoutDao routDao = RoutDao.getInstance();
	private static final CityDao cityDao = CityDao.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		ArrayList<City> cities=cityDao.findAll();

		ArrayList<Rout> routs= routDao.findAll();
		req.setAttribute("cities",cities);
		req.setAttribute("routs",routs);
		req.getRequestDispatcher("cities.jsp").forward(req, res);
	}
	
	
}
