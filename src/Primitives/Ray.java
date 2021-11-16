package Primitives;

public class Ray {
	private Point3D POO;
	private Vector direction;
	
	
	public Ray() {
		this.POO=new Point3D();
		this.direction=new Vector();
	}
	

	public Ray(Point3D poo,Vector direction) {
		this.POO=poo;
		this.direction=direction;
	}
	
	public Ray(Ray rey) {
		this.POO=new Point3D(rey.getPOO());
		this.direction=new Vector(rey.getDirection());

	}

	public Vector getDirection() {
		return direction;
	}


	public void setDirection(Vector direction) {
		this.direction = direction;
	}


	public Point3D getPOO() {
		return POO;
	}

	public void setPOO(Point3D pOO) {
		POO = pOO;
	}


	public boolean equals(Object obj) {
		boolean isEqual=false;
		if(this==obj) {
			isEqual=true;
		}
		else if (obj == null || this.getClass()!= obj.getClass()) {
			isEqual=false;
			
		}
		else if(this.direction.equals(((Ray)obj).getDirection())&&
		   this.POO.equals(((Ray)obj).getPOO())) {
			isEqual=true;
		}
		return isEqual;		
	}


	@Override
	public String toString() {
		return POO + "," + direction;
	}

	
}
