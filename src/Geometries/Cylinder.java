
package Geometries;
import java.util.List;

import Primitives.*;

public class Cylinder extends Geometry{
	private Ray axis;
	private double radius;
	private double heigth;
	
	public Cylinder() {
		this.axis=new Ray();
		this.radius=5;
		this.heigth=5;
		
	}
	public Cylinder(Ray axis,double radius,double heigth) {
		this.axis=axis; 
		if(radius<=0) {
			throw new IllegalArgumentException("radius must be positive");
		}
		else {
			this.radius=radius;
		}
		if(heigth<=0) {
			throw new IllegalArgumentException("heigth must be positive");
		}
		else {
			this.heigth=heigth;
		}
	}
	
	public Cylinder(Cylinder cylinder) {
		this.axis=new Ray(cylinder.getAxis());
		this.radius=cylinder.getRadius();
		this.heigth=cylinder.getHeigth();
	}
	
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Ray getAxis() {
		return axis;
	}
	public void setAxis(Ray axis) {
		this.axis = axis;
	}
	public double getHeigth() {
		return heigth;
	}
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
	@Override
	public String toString() {
		return "Cylinder: axis - " + axis + ", radius = " + radius + ", heigth = " + heigth;
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
		else if (this.axis.equals(((Cylinder)obj).getAxis())&&
			this.radius==((Cylinder)obj).getRadius()&&
			this.heigth==((Cylinder)obj).getHeigth()){	 
			isEqual=true;
		}

		return isEqual;		
	}
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vector getNormal(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
