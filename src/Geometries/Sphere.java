package Geometries;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Primitives.*;

public class Sphere extends Geometry{
	private Point3D center;
	private double radius;
	
	
	public Sphere() {
		this.center=new Point3D();
		this.radius=5;
		
	}
	public Sphere(double radius,Point3D center,Color _emission,Material _material) {
		super(_emission,_material);
		this.center=center;
		if (radius<=0) {
		throw new IllegalArgumentException("radius must be positive");
		}
		else {
				this.radius=radius;
		}
	}
	public Sphere(double radius,Point3D center,Color _emission) {
		super(_emission);
		this.center=center;
		if (radius<=0) {
		throw new IllegalArgumentException("radius must be positive");
		}
		else {
				this.radius=radius;
		}
	}
	
	public Sphere(Sphere sphere) {
		super(new Color(sphere.get_emission().getRGB()),sphere.get_material());
		this.center = new Point3D(sphere.getCenter());
		this.radius = sphere.getRadius();
	}
	

	public Point3D getCenter() {
		return center;
	}
	public void setCenter(Point3D center) {
		this.center = center;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	
	@Override
	public List <Point3D> findIntersections(Ray ray){
		List<Point3D> pointList=new ArrayList<Point3D>();
		Vector u=new Vector(this.center.subtract(ray.getPOO()));
		double tm=ray.getDirection().normalize().dotProduct(u);
		double d=Math.sqrt(Math.pow(u.length(), 2)-(Math.pow(tm, 2)));
		Double value =Double.parseDouble(new DecimalFormat("##.####").format(d - tm));

		if (d>this.radius || d<0 || value>Math.abs(tm)) {
			return null;
		}
		double th=Math.sqrt(Math.pow(radius, 2)-(Math.pow(d, 2)));
		double t1=tm+th;
		double t2=tm-th;
		Point3D P1=new Point3D();
		Point3D P2=new Point3D();
		if(t1<=0&&t2<=0) {
			return null;
		}
		if (t1>0) {
			P1=ray.getPOO().add(ray.getDirection().normalize().scale(t1));
			pointList.add(P1);
		}
		if (t2>0) {
			P2=ray.getPOO().add(ray.getDirection().normalize().scale(t2));
			 pointList.add(P2);
		}
	//	System.out.println( pointList);
		return pointList;
		 
	}
	
	
	@Override
	public Vector getNormal(Point3D p) {
		
		return p.subtract(center).normalize();
		
		
	}
	
	

	
	@Override
	public String toString() {
		return "center = " + center + ", radius = " + radius;
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
		else if (this.center.equals(((Sphere)obj).getCenter())&&
			this.radius==((Sphere)obj).getRadius()&&
			this._emission.equals(((Sphere)obj).get_emission()))
		{	 
			isEqual=true;
		}

		return isEqual;		
	}
	

}
