package Elements;
import java.awt.Color;


import Primitives.Point3D;
import Primitives.Vector;

public abstract class Light {
	protected Color _intensity;
	
	
	public Light() {
		this._intensity =new Color(0, 0, 0);
	}
	public Light(Color _intensity) {
		this._intensity = _intensity;
	}
	public Light(Light other) {
		this._intensity =
				new Color(other.get_intensity().getRed(), other.get_intensity().getGreen(),other.get_intensity().getBlue());
	}

	public Color get_intensity() {
		return _intensity;
	}

	public void set_intensity(Color _intensity) {
		this._intensity = _intensity;
	}
	
	 public abstract Color getIntensity(Point3D point);
	 public abstract Vector getL(Point3D point);
	 
	 
	@Override
	public String toString() {
		return "Light [_intensity=" + _intensity + "]";
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
		else if(this._intensity.equals(((Light)obj).get_intensity())) {
			
			isEqual=true;
		}
		
		
		return isEqual;
		
	}
	
	public static int rgbCheck(int rgbValue) {
		if (rgbValue>255)
			return 255;
		else if(rgbValue<0)
			return 0;
		else 
			return rgbValue;
		
	}
	 
	
	 
	
	

}
