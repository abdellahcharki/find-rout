package util;

import java.util.ArrayList;

import dao.RoutDao;
import models.City;
import models.Rout;

public class Node extends City  {
 
	private static RoutDao routDao = RoutDao.getInstance();
	
	
	private Node parent;
	private Node target;

	private Pile pile;
	
	public Node(City c) {
		super(c);
		pile = new Pile();
		parent=null;
		target=null;
	}
	
	public Node(Node node) {
		this((City) node);
		this.parent=node.parent;
		this.target=node.target;
	}


	public Node(Node root,Node target) {
		this(root);
		this.parent=root.parent;
		this.target=target;
		load();
	}
	
	
	public Rout getRout() {
		return routDao.findRout(this, parent);
	}
	
	public void target(Node target) {
		this.target=target;
	}
	
	public Node target() {
		return this.target;
	}
	
	public  void load() { 
		for(City c:routDao.findTargetsCities(this)) 
				add(c);	 
	}

	public void parent(Node parent) {
		this.parent=parent;
	}
	
	public Node parent() {
		return this.parent;
	}
	
	public Pile pile() {
		return this.pile;
	}
	
	public boolean isRoot() {	
		if(parent==null) return true;
		return true;
	}
	
 
	
	
	 
	public void add(City c) { 
	 		
		Node node = new Node(c);
		node.parent(this);
		node.target(target());
	
		
		if(this.parent == null ) {
			 pile.push(node);
		} else {
			 if(this.parent.getId()== node.getId()) return;
			 else pile.push(node);
		}
		
		
	
	
	}
	

	
	
	
	
	
	
	
	public Node pop() {
		return this.pile.pop();
	}
	
	public double cost() {
		double c=0;
		Node node = new Node(this);
		
		while(node.parent != null) {
			c+=node.d();
			node= node.parent;
		}
		return c;
	}
	
	public double h() {
		
		double lat1 = getX();
		double long1  = getY();
		double lat2 = target.getX();
		double long2 = target.getY();
		
		double _eQuatorialEarthRadius = 6378.1370D;
		double _d2r = (Math.PI / 180D);
		 

		 double dlong = (long2 - long1) * _d2r;
	        double dlat = (lat2 - lat1) * _d2r;
	        double a = Math.pow(Math.sin(dlat / 2D), 2D) + Math.cos(lat1 * _d2r) * Math.cos(lat2 * _d2r)
	                * Math.pow(Math.sin(dlong / 2D), 2D);
	        double c = 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
	        double d = _eQuatorialEarthRadius * c;
	       
		    return d;
		
	}
	
	public double f() {
		return h()+cost();
	}

	public double d() {
		if( this.parent==null ) return 0;
		return routDao.findRout(parent(),this).getDistance();
	}

 
	public void print() {
		String s="";
		for(Node n :pile().toArrayList()) s += " ["+n.getName()+"] " ;

		System.out.println("==================== "+getName()+"==================== ");
		System.out.println("Id        : "+getId());
		System.out.println("Distance  : "+d());
		System.out.println("Heuristic : "+h());
		System.out.println("Cost      : "+cost());
		System.out.println("Function : "+f());
		System.out.println("Parent    : "+parent);
		System.out.println("Target    : "+target);
		System.out.println("Childs    : "+pile().size() + " : " + s);
	}

 
}
