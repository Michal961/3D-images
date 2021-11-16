package Geometries;


import java.awt.Color;
import java.util.List;

import Primitives.*;

public class Triangle extends Geometry {
	
	private Point3D p1;
	private Point3D p2;
	private Point3D p3;
	
	public Triangle() {
		this.p1=new Point3D(new Coordinate(1),new Coordinate(),new Coordinate());
		this.p2=new Point3D(new Coordinate(),new Coordinate(1),new Coordinate());
		this.p3=new Point3D(new Coordinate(),new Coordinate(),new Coordinate(1));
		
	}
	public Triangle(Point3D p1,Point3D p2,Point3D p3,Color _emission) {
		super(_emission);
		boolean pointsCheck=((p1.equals(p2))||p1.equals(p3)||p2.equals(p3)); //check if there are 2 equal points
		
		boolean xCheck=(p1.getX().equals(p2.getX()) && p1.getX().equals(p3.getX())); //check if all the X are equal
		boolean yCheck=(p1.getY().equals(p2.getY()) && p1.getY().equals(p3.getY())); //check if all the y are equal
		boolean zCheck=(p1.getZ().equals(p2.getZ()) && p1.getZ().equals(p3.getZ())); //check if all the z are equal
		
		
		//Check if there are 2 equal axis at all points or there are 2 equal points---> illegal
		if((xCheck&&yCheck)||(xCheck&&zCheck)||(yCheck&&zCheck)||(pointsCheck)) {
			
			throw new IllegalArgumentException("invalid points");
		}
		else {
			this.p1=p1;
			this.p2=p2;
			this.p3=p3;
		}
		
	}
	
	public Triangle(Triangle triangle) {
		super(new Color(triangle.get_emission().getRGB()),triangle.get_material());
		this.p1 = new Point3D(triangle.getP1());
		this.p2 = new Point3D(triangle.getP1());
		this.p3 = new Point3D(triangle.getP1());
	}
	
	public Point3D getP1() {
		return p1;
	}
	public void setP1(Point3D p1) {
		this.p1 = p1;
	}
	public Point3D getP2() {
		return p2;
	}
	public void setP2(Point3D p2) {
		this.p2 = p2;
	}
	public Point3D getP3() {
		return p3;
	}
	public void setP3(Point3D p3) {
		this.p3 = p3;
	}
	
	
	@Override
	public List <Point3D> findIntersections(Ray ray){
		
		 Plane Plan =new Plane(this.p1,this.p2,this.p3);
		 
		 Vector v1=this.p1.subtract(ray.getPOO());
		 Vector v2=this.p2.subtract(ray.getPOO());
		 Vector v3=this.p3.subtract(ray.getPOO());
		 Vector N1=v1.crossProduct(v2).normalize();
		 Vector N2=v2.crossProduct(v3).normalize();
		 Vector N3=v3.crossProduct(v1).normalize();
		 
		 double vN1=ray.getDirection().dotProduct(N1);
		 double vN2=ray.getDirection().dotProduct(N2);
		 double vN3=ray.getDirection().dotProduct(N3);
		 
		 if ((vN1>0&&vN2>0&&vN3>0)||(vN1<0&&vN2<0&&vN3<0)) {

			 return Plan.findIntersections(ray);
		 }
		 
		 else {
			return null;
		} 
	}
	
	@Override
	public Vector getNormal(Point3D p) {
		
		Plane nPlane=new Plane(p1, p2, p3);
	
		return nPlane.getNormal(p);
	}

	@Override
	public String toString() {
		return p1 + "," + p2 + "," + p3;
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
		else if (this.p1.equals(((Triangle)obj).getP1())&&
			this.p2.equals(((Triangle)obj).getP2())&&
			this.p3.equals(((Triangle)obj).getP3())&&
			this._emission.equals(((Triangle)obj).get_emission()))
			{	 
			isEqual=true;
		}

		return isEqual;		
	}

	
}
