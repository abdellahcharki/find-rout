package util;

import java.util.ArrayList;
import java.util.PriorityQueue;

import dao.CityDao;
import dao.RoutDao;
import models.City; 


public class Astart  {
 
	
	public static CityDao cityDao = CityDao.getInstance();
	public static RoutDao routDao = RoutDao.getInstance();

	private City source,target;
	
	public Astart(City source, City target) {
		 this.source=source;
		 this.target=target;
	}



	public ArrayList<Node> findPath() {
		Node source = new Node(this.source);
		Node target = new Node(this.target);
		
		Pile p=new Pile();
		ArrayList<Node> list =new ArrayList<>();
		list.add(source);
		
		Node node = new Node(source,target);
		
		while (node.h()>0) {
			
			Node n = node.pop();// mozer
			list.add(n);
			p.push(node.pile());
			
			node = new Node(n,target);
			p.push(node.pile());
 

		
		}
		
	 
		 return list;
	}


}
