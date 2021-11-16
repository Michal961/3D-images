package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class AmbientLight extends Light{
	
	private double _ka;
	

	public AmbientLight() {
		super();
		this._ka= 0.1;
	}

	public AmbientLight(Color _intensity,double _ka) {
		super(_intensity);
		this._ka=_ka;
	}
	
	public AmbientLight(AmbientLight other) {
		super(other.get_intensity());
		this._ka=other.get_ka();
	}
	

	public double get_ka() {
		return _ka;
	}

	public void set_ka(double _ka) {
		this._ka = _ka;
	}

	@Override
	public Color getIntensity(Point3D point) {
		Color numerator=this.get_intensity();
		return new Color(Light.rgbCheck((int)(numerator.getRed()*this._ka)),
				Light.rgbCheck((int)(numerator.getGreen()*this._ka)),
				Light.rgbCheck((int)(numerator.getBlue()*this._ka)));

	}

	@Override
	public Vector getL(Point3D point) {
		return null;
	}

	@Override
	public String toString() {
		
		return "AmbientLight [_ka=" + _ka + "]";
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
		else if(super.equals(obj)&&(this._ka==(((AmbientLight)obj).get_ka()))) {
			
			isEqual=true;
		}
		
		
		return isEqual;
		
	}
	
	
	

}
