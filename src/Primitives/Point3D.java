package Primitives;
import java.lang.Math;


public class Point3D {
	private Coordinate x;
	private Coordinate y;
	private Coordinate z;
	
	static Point3D ZERO=new Point3D(0,0,0);
	
	public Point3D() {
		this.x=new Coordinate();
		this.y=new Coordinate();
		this.z=new Coordinate();
	}
	
	public Point3D(double x, double y, double z) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
		}

	
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point3D(Point3D point3d) {
		this.x=new Coordinate(point3d.getX());
		this.y=new Coordinate(point3d.getY());
		this.z=new Coordinate(point3d.getZ());
	
	}

	public Coordinate getX() {
		return x;
	}

	public void setX(Coordinate x) {
		this.x = x;
	}

	public Coordinate getY() {
		return y;
	}

	public void setY(Coordinate y) {
		this.y = y;
	}

	public Coordinate getZ() {
		return z;
	}

	public void setZ(Coordinate z) {
		this.z = z;
	}
	
	
	public Point3D add(Vector v) {
		double currentX=this.getX().get_coordinate()+v.getHead().getX().get_coordinate();
		double currentY=this.getY().get_coordinate()+v.getHead().getY().get_coordinate();
		double currentZ=this.getZ().get_coordinate()+v.getHead().getZ().get_coordinate();
		
		return(new Point3D( new Coordinate(currentX),new Coordinate(currentY),new Coordinate(currentZ)));
		
	}
	
	
	public Vector subtract(Point3D other) {
		if (this.equals(other)) {
			throw new IllegalArgumentException("Add v plus -v must throw exception");
		}
		else {
		double currentX=this.getX().get_coordinate()-other.getX().get_coordinate();
		double currentY=this.getY().get_coordinate()-other.getY().get_coordinate();
		double currentZ=this.getZ().get_coordinate()-other.getZ().get_coordinate();
		return(new Vector(new Point3D(new Coordinate(currentX),new Coordinate(currentY),new Coordinate(currentZ))));
		}
	}

	
	public double distance(Point3D other) {
		
		double currentX=Math.pow(other.getX().get_coordinate()-this.getX().get_coordinate(),2);
		double currentY=Math.pow(other.getY().get_coordinate()-this.getY().get_coordinate(),2);
		double currentZ=Math.pow(other.getZ().get_coordinate()-this.getZ().get_coordinate(),2);
		
		return Math.sqrt(currentX+currentY+currentZ);

	}
	

	@Override
	public String toString() {
		
		return "("+this.getX()+","+this.getY()+","+this.getZ()+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEqual=false;
		if(this==obj) {
			isEqual=true;
		}
		else if (obj == null || this.getClass()!= obj.getClass()) {
			isEqual=false;
			
		}
		else if(this.x.equals(((Point3D)obj).getX())&&
		  (this.y.equals(((Point3D)obj).getY()))&&
		  (this.z.equals(((Point3D)obj).getZ()))) {
			
			isEqual=true;
		}
		
		
		return isEqual;
		
	}
	
	

}
