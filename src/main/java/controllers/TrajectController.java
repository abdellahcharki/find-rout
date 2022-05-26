package controllers;

import java.io.IOException;
import java.util.ArrayList;

import dao.CityDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.City;
import util.Astart;
import util.Node;



public class TrajectController extends  HttpServlet{
	private static final long serialVersionUID = 1L;
	private static CityDao cityDao = CityDao.getInstance();

	 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 		ArrayList<Node> cities = new ArrayList<>();
	 	
		String source = req.getParameter("source").toUpperCase();
		String target = req.getParameter("target").toUpperCase();
		req.setAttribute("title","Hi, World | "+source +" - "+target);

		City c1 = cityDao.findByName(source);
		City c2 = cityDao.findByName(target);
		
		if(c1!=null && c2!=null) {
			Astart astart = new Astart(c1, c2);
			cities = astart.findPath();
			
		}else {
			if(c1==null) System.out.println("[c1] Kein Stadt mit Name : "+source);
			
			if(c2==null) System.out.println("[c2] Kein Stadt mit Name : "+target);
					
				
			
		}
		
		req.setAttribute("target",target);
		req.setAttribute("source",source);
		req.setAttribute("routes",cities);
		
		
		req.getRequestDispatcher("traject.jsp").forward(req, res);
		
	}
	 


}
