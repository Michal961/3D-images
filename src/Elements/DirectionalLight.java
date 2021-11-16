package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class DirectionalLight extends Light {
	private Vector _direction;
	
	

	public DirectionalLight(Color _intensity,Vector _direction) {
		super(_intensity);
		this._direction = _direction.normalize();
	}
	
	public DirectionalLight(DirectionalLight other) {
		super(other.get_intensity());
		this._direction=new Vector(other.get_direction().normalize());
	}
	
	

	public Vector get_direction() {
		return _direction;
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}

	@Override
	public Color getIntensity(Point3D point) {
		return this.get_intensity();
	}

	@Override
	public Vector getL(Point3D point) {

		return new Vector(-1,-1,-1);
	}

	@Override
	public String toString() {
		return "DirectionalLight [_direction=" + _direction + "]";
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
		else if(super.equals(obj) && (this.get_direction().equals(((DirectionalLight)obj).get_direction()))) {
			
			isEqual=true;
		}
		
		
		return isEqual;
		
	}
	
	

}
