package Renderer;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;


import Elements.Light;
import Geometries.*;
import Primitives.*;
import Scene.Scene;

public class Renderer {
	private Scene _scene;
	private ImageWriter _imageWriter;
	private static final double EPS = 0.1;

	
	public Renderer(ImageWriter _imageWriter,Scene _scene){
		this._scene=_scene;
		this._imageWriter=_imageWriter;

	}
	
	
	public Scene get_scene() {
		return _scene;
	}
	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}
	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}
	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
	}
	
	
	
	private List<GeoPoint> getSceneRayIntersections(Ray ray){
		List<GeoPoint> intersectionPoints = new ArrayList<GeoPoint>();
		
		for  (Geometry geometry : _scene.getGeometrise()) {
			if (geometry.findIntersections(ray)!=null) {
			
			List<GeoPoint> geometryIntersectionPoints=new ArrayList<GeoPoint>();
			for (int i=0; i<geometry.findIntersections(ray).size();i++) {
				GeoPoint GO=new GeoPoint (geometry,geometry.findIntersections(ray).get(i));
				geometryIntersectionPoints.add(GO);
			}
			intersectionPoints.addAll(geometryIntersectionPoints);
			}
		}
		return intersectionPoints;

	}
	
	
	private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.getCamera().getPo();
		GeoPoint minDistancePoint = null;
		
		for (GeoPoint point: intersectionPoints) {
			if (P0.distance(point.getPoint()) < distance) {
				minDistancePoint =new GeoPoint(point.getGeometry(),new Point3D(point.getPoint()));
				distance = P0.distance(point.getPoint());
			}	
		}
		System.out.println(minDistancePoint);
		return minDistancePoint;
	
	}
	
	private Color calcColor(GeoPoint gp) { 
	      Color ambientLight =_scene.getAmbientLight().getIntensity(gp.getPoint());
	      Color emissionLight =gp.getGeometry().get_emission();
	      Color diffuseLight = new Color(0, 0, 0);
	      Color specularLight = new Color(0, 0, 0); 
	     for (Light light: _scene.getLights()) {
	    	 if (!shaded(light,light.getL(gp.getPoint()),gp.getPoint(),gp.getGeometry().getNormal(gp.getPoint()))) {
	    	  diffuseLight=addColors(diffuseLight,calcDiffusiveComp(
	    			  							 gp.getGeometry().get_material().getKd()
	    			  							 ,gp.getGeometry().getNormal(gp.getPoint())
	    			  							 ,light.getL(gp.getPoint())
	    			  							 ,light.get_intensity()));

	    	  
	    	  specularLight=addColors(specularLight,calcSpecularComp(
	    			  						    	gp.getGeometry().get_material().getKs(),
	    			  						    	new Vector(_scene.getCamera().getPo().subtract(gp.getPoint()).normalize()),
	    			  						    	gp.getGeometry().getNormal(gp.getPoint()),
	    			  						    	light.getL(gp.getPoint()),
	    			  						    	gp.getGeometry().get_material().getShininess(),
	    			  						    	light.get_intensity()));
	    	  
	    	  

	    	 }
	     }
	      
	      Color ambientAndEmission=addColors(ambientLight,emissionLight);
	      Color diffuseAndspecular=addColors(diffuseLight,specularLight);
	      
    return addColors(ambientAndEmission,diffuseAndspecular);
	      
	}
	
	
	
	private Color calcDiffusiveComp(double _kd, Vector normal, Vector l, Color lightIntensity) {
		
		Color kdi=new Color(Light.rgbCheck((int) (lightIntensity.getRed()*_kd)),
				Light.rgbCheck((int)(lightIntensity.getGreen()*_kd)),
				Light.rgbCheck((int)(lightIntensity.getBlue()*_kd)));
		
	
		
		double nl=normal.dotProduct(l.scale(1));
		
		Color diffused=new Color(Light.rgbCheck((int)(kdi.getRed()*nl)),
				Light.rgbCheck((int)(kdi.getGreen()*nl)),
				Light.rgbCheck((int)(kdi.getBlue()*nl)));
		
		
		
		return diffused;
	}

	private Color calcSpecularComp(double _Ks, Vector v,Vector normal,Vector l, int _nShininess,Color lightIntensity)  {

		double ttVector=2*normal.dotProduct(l.scale(-1));
		Vector r=l.scale(-1).subtract(normal.scale(ttVector)).normalize(); // R
		
		
		double vr=Math.pow(r.dotProduct(v), _nShininess)*_Ks;
		
		Color tor33=new Color(Light.rgbCheck((int)(lightIntensity.getRed()*vr)),
				Light.rgbCheck((int)(lightIntensity.getGreen()*vr)),
				Light.rgbCheck((int)(lightIntensity.getBlue()*vr)));
		
		return tor33;
		

	}
	
	private boolean shaded(Light light, Vector l, Point3D point, Vector n ) {
	     Vector lightDirection = l; // from point to light source
	     Vector epsVector = n.scale(EPS);
		 Point3D newPoint = point.add(epsVector); 

	   Ray shadowRay = new Ray(newPoint , lightDirection );
	   List<GeoPoint> intersectionPoints =getSceneRayIntersections(shadowRay);
	   if (intersectionPoints.isEmpty()) {
		return false;
		
	   }
	      return true;

	}


	
	private static Color addColors(Color first,Color other) {
		int r=first.getRed()+other.getRed();
		int g=first.getGreen()+other.getGreen();
		int b=first.getBlue()+other.getBlue();
			r=Light.rgbCheck(r);
			g=Light.rgbCheck(g);
			b=Light.rgbCheck(b);
		
		return new Color(r, g, b);
		
		
		
		
	}
	
	
	
	public void renderImage() {
		
		for(int i=0; i<_imageWriter.getNx();i++) {
			for(int j=0; j<_imageWriter.getNy();j++) {
				Ray ray = _scene.getCamera().constructRayThroughPixel
						(_imageWriter.getNx(), _imageWriter.getNy(), j, i,_scene.get_screenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				List<GeoPoint> intersectionPoints =  new ArrayList<GeoPoint>();
				intersectionPoints=getSceneRayIntersections(ray);
				if(intersectionPoints.isEmpty()) {
				_imageWriter.writePixel(j, i, _scene.get_background());
				}
			else
			{
        		GeoPoint closestPoint = getClosestPoint(intersectionPoints);
                 _imageWriter.writePixel(j, i, calcColor(closestPoint));

			}
	
			}
		}
		_imageWriter.writeToImage();
		
	}
	

}
