package Elements;

import Primitives.*;


public class Camera {
	
	Point3D po;
	Vector vUp;
	Vector vRight;
	Vector vTo;


	public Camera() {
	
	this.po=new Point3D();
	this.vUp=new Vector(new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0)));
	this.vRight=new Vector(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0)));
	this.vTo=new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1)));
	
	}
	
	public Camera(Point3D po,Vector vTo,Vector vUp) {
	
	this.po=po;
	this.vUp=vUp;
	this.vTo=vTo;
	this.vRight=vTo.crossProduct(vUp);
	
	}

	public Point3D getPo() {
		return po;
	}

	public void setPo(Point3D po) {
		this.po = po;
	}

	public Vector getvUp() {
		return vUp;
	}

	public void setvUp(Vector vUp) {
		this.vUp = vUp;
	}

	public Vector getvRight() {
		return vRight;
	}

	public void setvRight(Vector vRight) {
		this.vRight = vRight;
	}

	public Vector getvTo() {
		return vTo;
	}

	public void setvTo(Vector vTo) {
		this.vTo = vTo;
	}
	
	public Ray constructRayThroughPixel(int nX, int nY, int j, int i,
            double screenDistance, double screenWidth, double screenHeight) {
		
		Point3D pC=new Point3D();
		pC=po.add(vTo.scale(screenDistance));

		double rY=screenHeight/nY;
		double rX=screenWidth/nX;

		double yI=((i-((nY-1)/2.0))*rY);
		double xJ=((j-((nX-1)/2.0))*rX);

		
		Point3D pIJ=new Point3D(pC);
	    if (xJ!=0 && yI!=0) {
		
	    	pIJ=pC.add((vRight.scale(xJ)).subtract(vUp.scale(yI)));
	     } 
	
	    else if (xJ!=0) {
	    	pIJ = pIJ.add(vRight.scale(xJ));
			
		}
	    
	    else if (yI!=0) {
	    	pIJ=pIJ.add(vUp.scale(-yI));
		}
	    
		Vector vIJ=pIJ.subtract(po);
		return new Ray(po, vIJ.normalize());
		
	}

	
	@Override
	public String toString() {
		return "vUp="+vUp+"vTo"+vTo+"vRight"+vRight;
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
		else if (this.vRight.equals(((Camera)obj).getvRight()) 
				&& (this.vUp.equals(((Camera)obj).getvUp()))
				&& this.vTo.equals(((Camera)obj).getvTo())){
			isEqual=true;
		}
		return isEqual;		
	}

}
	


	


