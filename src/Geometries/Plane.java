package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;



import Primitives.*;

public class Plane extends Geometry {
	private Point3D q;
	private Vector n;
	
	
	public Plane() {
		this.q=new Point3D();
		this.n=new Vector();
		
	}
	public Plane(Point3D q,Vector n,Color _emission,Material _material) {
		super(_emission,_material);
		this.q=q;
		this.n=n.normalize();
		
	}
	
	public Plane(Plane plane) {
		super(new Color(plane.get_emission().getRGB()),plane.get_material());
		this.q = new Point3D(plane.getQ());
		this.n = new Vector(plane.getN());
		
	}
	
	
	public Plane(Point3D p1, Point3D p2, Point3D p3) {
        // if p1=p2 or p1=p3 - an exception will be thrown
        Vector v1 = p1.subtract(p2);
        Vector v2 = p1.subtract(p3);

// if the points are in the same line - X-product will throw an exception
        n = v1.crossProduct(v2).normalize();
        q = new Point3D(p1);
    }



	public Point3D getQ() {
		return q;
	}
	public void setQ(Point3D q) {
		this.q = q;
	}
	public Vector getN() {
		return n;
	}
	public void setN(Vector n) {
		this.n = n;
	}
	
	
	@Override
	public List <Point3D> findIntersections(Ray ray){
		List<Point3D> pointList=new ArrayList<Point3D>();
		 Point3D P=new Point3D();
		 if(this.q.equals(ray.getPOO())){
			 return null;
		 }

		 else {
			 double tNumerator=this.n.dotProduct(this.q.subtract(ray.getPOO()));
			 double tDenominator=this.n.dotProduct(ray.getDirection().normalize());
			 
			
			 if (tNumerator==0 || tDenominator==0) {
				 return null;
			 
			 }
			 double t= tNumerator/ tDenominator;
			 if(t<0) {
				 return null;
			 }

			else {
				 P=ray.getPOO().add(ray.getDirection().normalize().scale(t));
				
			 }
		 }
		// System.out.println( pointList);
	     pointList.add(P);
		return pointList;
		 
	}
	
	
	@Override
	public Vector getNormal(Point3D p) {
		return this.n;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Plane:" + q + "," + n;
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
		else if (this.q.equals(((Plane)obj).getQ())&&
			this.n.equals(((Plane)obj).getN()) &&
			this._emission.equals(((Plane)obj).get_emission()))
		{	 
			isEqual=true;
		}

		return isEqual;		
	}
	
	

}
