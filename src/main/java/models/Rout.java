package models;
 

public class Rout {
	
	
	private int id;
	private String name;
	
	private City source;
	private City target;
	private double distance;
	private double distanceTotal;
	private Rout prev;
	private Rout next;
	
	public Rout(City source,City target,double distance) {
		name = source.getName()+" - "+target.getName();
		this.source=source;
		this.target=target;
		this.distance =distance;
		this.distanceTotal=distance;
	}
	
	public Rout(int id, City source, City target, double distance) {
		this(source,target,distance);
		this.id=id;
	}

	public City getSource() {
		return source;
	}

	public City getTarget() {
		return target;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	public double getHeuristic(City target) {
		
		double lat1 = this.target.getX();
		double long1  = this.target.getY();
		double lat2 = target.getX();
		double long2 = target.getY();
		
		double _eQuatorialEarthRadius = 6378.1370D;
		double _d2r = (Math.PI / 180D);
		
		double dx = source.getX()-target.getX();
		double dy = source.getY()-target.getY();

		 double dlong = (long2 - long1) * _d2r;
	        double dlat = (lat2 - lat1) * _d2r;
	        double a = Math.pow(Math.sin(dlat / 2D), 2D) + Math.cos(lat1 * _d2r) * Math.cos(lat2 * _d2r)
	                * Math.pow(Math.sin(dlong / 2D), 2D);
	        double c = 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
	        double d = _eQuatorialEarthRadius * c;
	       
		    return d;
	}
	
	
	
		public String time() {
			double d = getDistance();
			double v=60.0;
			double t = d/v*60;// min
			
			String hh =String.valueOf((int) t/60);
			int k = (int) (t/60);
			
			int m = (int) (t-k*60);
			
			String mm =String.valueOf(m);
			

			if(mm.length()==1)mm="0"+mm;
			if(hh.length()==1)hh="0"+hh;
			
			return " "+hh+"h"+mm;
			
		}
		
	public double getHeuristic() {
		
		double lat1 = source.getX();
		double long1  = source.getY();
		double lat2 = target.getX();
		double long2 = target.getY();
		
		double _eQuatorialEarthRadius = 6378.1370D;
		double _d2r = (Math.PI / 180D);
		
		double dx = source.getX()-target.getX();
		double dy = source.getY()-target.getY();

		 double dlong = (long2 - long1) * _d2r;
	        double dlat = (lat2 - lat1) * _d2r;
	        double a = Math.pow(Math.sin(dlat / 2D), 2D) + Math.cos(lat1 * _d2r) * Math.cos(lat2 * _d2r)
	                * Math.pow(Math.sin(dlong / 2D), 2D);
	        double c = 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
	        double d = _eQuatorialEarthRadius * c;
	       
		    return d;
		
	}

	public double getDistance() {
		return distance;
	}

	public int getId() {
		return id;
	}
	
	public double f(City target) {
		return distance + getHeuristic(target);
	}
	
	public Rout next() {
		return next;
	}
	
	public void next(Rout rout) {
		this.next=rout;
	}

	public Rout prev() {
		return prev;
	}
	
	public void prev(Rout rout) {
		this.prev=rout;
	}

	public void addDistance(double d) {
		this.distanceTotal+=d;
	}
}
