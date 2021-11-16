package Scene;
import Geometries.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.Light;

public class Scene {
	private String name;
	private List<Geometry> geometrise;
	private Camera camera;
	private double _screenDistance;
    private Color _background; 
    private AmbientLight ambientLight;
    private List<Light> lights;

	
	public Scene() {
		this.name="";
		this.camera=new Camera();
		this.geometrise= new ArrayList<Geometry>();
		this.lights= new ArrayList<Light>();
		this._screenDistance=100;
		this._background=Color.BLACK;
		
	}
	public Scene(String name) { 
		this.name = name;
		this.geometrise= new ArrayList<Geometry>();
		this.lights= new ArrayList<Light>();
		
	}
	public Scene(String name,List<Geometry> geometrise,Camera camera,double _screenDistance,Color _background) {
		this.name=name; 
		this.geometrise=geometrise;
		this.camera=camera;
		this._screenDistance=_screenDistance;
		this._background=_background;
		
	}
	
	public Scene(Scene scene) {
		this.name=scene.getName();
		this.camera=new Camera(); // or by adding copy contractor 
		this.geometrise=new ArrayList<Geometry>();
		for(int i=0; i<scene.geometrise.size();i++){
        	Geometry currentElement=geometrise.get(i);
            if(currentElement instanceof Triangle)
               addGeometry(new Triangle((Triangle) currentElement));
            else if(currentElement instanceof Sphere)
                addGeometry(new Sphere((Sphere) currentElement));
            else if(currentElement instanceof Plane)
               addGeometry(new Plane((Plane) currentElement));
           
        }
		this._screenDistance=scene.get_screenDistance();
		this._background=new Color(scene.get_background().getRGB());
	
	}


	public AmbientLight getAmbientLight() {
		return ambientLight;
	}
	public void setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
	}
	public List<Light> getLights() {
		return lights;
	}
	public void setLights(List<Light> lights) {
		this.lights = lights;
	}
	public double get_screenDistance() {
		return _screenDistance;
	}
	public void set_screenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}
	public Color get_background() {
		return _background;
	}
	public void set_background(Color _background) {
		this._background = _background;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Geometry> getGeometrise() {
		return geometrise;
	}
	public void setGeometrise(List<Geometry> geometrise) {
		this.geometrise = geometrise;
	}
	
	public void addGeometry(Geometry geometry) {
		geometrise.add(geometry);
	}
	
	public void addLight(Light light) {
		System.out.println("immmmmmmmmmmm");
		lights.add(light);

	}
	
	@Override
	public String toString() {
		return "Scene: name = " + name + ", geometrise = " + geometrise;
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
		else if (this.name.equals(((Scene)obj).getName())&&
			this.geometrise.equals(((Scene)obj).getGeometrise())&&
			this._background.equals(((Scene)obj).get_background())){ 
			isEqual=true;
		}

		return isEqual;		
	}
	
	
}
