package models;

public class City {


	private int id ;
	private String name;
	private double x;
	private double y;
	
	
	
	public City(String name,double x,double y) {
		this.name=name;
		this.x=x;
		this.y=y;
	}

	
	public City(int id,String name,double x,double y) {
		this.setId(id);
		this.name=name;
		this.x=x;
		this.y=y;
	}

	public City(City c) {
		this.name = c.getName();
		this.x=c.getX();
		this.y= c.getY();
		this.id=c.getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	

	public boolean equals(City c) {
		if(this.id == c.getId() && this.x==c.getX() && this.y==c.getY() ) return true;	
		return false;
	}
	
	
	@Override
	public String toString() {
		return String.format("[id: %d , name: %s]", id,name);
	}
	
	

}
