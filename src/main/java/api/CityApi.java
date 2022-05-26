package api;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import dao.CityDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.City;

public class CityApi extends  HttpServlet{
	private static final long serialVersionUID = 1L;

	CityDao cityDao = CityDao.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		ArrayList<City> list = cityDao.finds((String)req.getParameter("q"));
		String json = new Gson().toJson(list); 
		res.getWriter().print(json);
	}
}
