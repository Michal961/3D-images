package Primitives;

public class Vector {
	protected Point3D head;
	
	public Vector() {
		this.head=new Point3D();
	}


	public Vector(Point3D head) {
		if (Point3D.ZERO.equals(head))
			throw new IllegalArgumentException("Zero vector is not allowed");
		this.head = head;
	}
	
	public Vector(Vector vector) {
		
		this.head = new Point3D(vector.getHead());
	}
	
	public Vector(double x, double y, double z) {
		head = new Point3D(x, y, z);
		if (Point3D.ZERO.equals(head))
			throw new IllegalArgumentException("Zero vector is not allowed");
	}
	


	public Point3D getHead() {
		return head;
	}

	public void setHead(Point3D head) {
		this.head = head;
	}
	
	
	public double length() {
		return this.getHead().distance(new Point3D());	
	}
	
	
	public Vector normalize() {
		double currentLength=this.length();
		double currentX=this.getHead().getX().get_coordinate()/currentLength;
		double currentY=this.getHead().getY().get_coordinate()/currentLength;
		double currentZ=this.getHead().getZ().get_coordinate()/currentLength;
		return new Vector(new Point3D(new Coordinate(currentX),new Coordinate(currentY),new Coordinate(currentZ)));
	}
	
	public Vector add(Vector other) {
		
		
		if(this.getHead().getX().get_coordinate()+other.getHead().getX().get_coordinate()==0 &&
		   this.getHead().getY().get_coordinate()+other.getHead().getY().get_coordinate()==0 &&
		   this.getHead().getZ().get_coordinate()+other.getHead().getZ().get_coordinate()==0)
		{
			throw new IllegalArgumentException("Add v plus -v must throw exception");
		}
		else {
			
		
		return new Vector(this.getHead().add(other));
		}
	}
	
	public Vector subtract(Vector other) {
		if (this.equals(other)) {
			throw new IllegalArgumentException("Add v plus -v must throw exception");
		}
		else
		return new Vector(this.getHead().subtract(other.getHead()));		
	}
	
	public Vector scale(double scalar) {
		if (scalar==0) { 
			throw new IllegalArgumentException("Scale by 0 must throw exception");
		}
		else
		return new Vector(new Point3D(new Coordinate(this.getHead().getX().get_coordinate()*scalar),
				new Coordinate(this.getHead().getY().get_coordinate()*scalar),
				new Coordinate(this.getHead().getZ().get_coordinate()*scalar)));
	}
	
	
	public Vector crossProduct(Vector other) {
		
		if(this.parallelCheck(other)) {
			throw new IllegalArgumentException("crossProduct() for parallel vectors does not throw an exception");
			
		}
		else {
		double currentX=this.getHead().getY().get_coordinate()*other.getHead().getZ().get_coordinate()-this.getHead().getZ().get_coordinate()*other.getHead().getY().get_coordinate();
		
		double currentY=this.getHead().getZ().get_coordinate()*other.getHead().getX().get_coordinate()-this.getHead().getX().get_coordinate()*other.getHead().getZ().get_coordinate();
		
		double currentZ=this.getHead().getX().get_coordinate()*other.getHead().getY().get_coordinate()-this.getHead().getY().get_coordinate()*other.getHead().getX().get_coordinate();
				
				return new Vector(new Point3D(new Coordinate(currentX),new Coordinate(currentY),new Coordinate(currentZ)));
		}
	
	}
	
	public double dotProduct(Vector other) {
		double currentX=this.getHead().getX().get_coordinate()*other.getHead().getX().get_coordinate();
		double currentY=this.getHead().getY().get_coordinate()*other.getHead().getY().get_coordinate();
		double currentZ=this.getHead().getZ().get_coordinate()*other.getHead().getZ().get_coordinate();
		
		return currentX+currentY+currentZ;
		
	}
	
	
	private boolean parallelCheck(Vector other) {
		boolean parallel=false;
		double x=this.getHead().getX().get_coordinate()/other.getHead().getX().get_coordinate();
		double y=this.getHead().getY().get_coordinate()/other.getHead().getY().get_coordinate();
		double z=this.getHead().getZ().get_coordinate()/other.getHead().getZ().get_coordinate();
		
		if((x==y)&&(x==z)) {
			parallel=true;
		}
		
		return parallel;
	}

	@Override
	public String toString() {
		return ""+head;
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
		else if (this.head.equals(((Vector)obj).getHead())) {
			isEqual=true;
		}

		return isEqual;		
	}

}
