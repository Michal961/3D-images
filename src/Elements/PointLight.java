package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class PointLight extends Light{
	private Point3D _position;
	private double _kc;
	private double _kl;
	private double _kq;
	
	
	
	

	public PointLight(Color _intensity,Point3D _position, double _kc, double _kl, double _kq) {
		super(_intensity);
		this._position = _position;
		this._kc = _kc;
		this._kl = _kl;
		this._kq = _kq;
	}
	
	public PointLight(PointLight other) {
		super(other.get_intensity());
		this._position =new Point3D(other.get_position());
		this._kc = other.get_kc();
		this._kl = other.get_kl();
		this._kq = other.get_kq();;
	}
	

	public Point3D get_position() {
		return _position;
	}

	public void set_position(Point3D _position) {
		this._position = _position;
	}

	public double get_kc() {
		return _kc;
	}

	public void set_kc(double _kc) {
		this._kc = _kc;
	}

	public double get_kl() {
		return _kl;
	}

	public void set_kl(double _kl) {
		this._kl = _kl;
	}

	public double get_kq() {
		return _kq;
	}

	public void set_kq(double _kq) {
		this._kq = _kq;
	}

	@Override
	public Color getIntensity(Point3D point)  {
		Color numerator=this.get_intensity();
		double d=(this._position.distance(point));
		double denominator=(this._kc+(this._kl*d))+(this._kq*(Math.pow(d, 2)));
		return new Color(Light.rgbCheck((int)(numerator.getRed()/denominator)),
				Light.rgbCheck((int)(numerator.getGreen()/denominator)),
				Light.rgbCheck((int)(numerator.getBlue()/denominator)));
	
	}

	@Override
	public Vector getL(Point3D point) {
		
		return this._position.subtract(point).normalize();
	
	
	}
	
	@Override
	public String toString() {
		return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
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
		else if(super.equals(obj) && (this._position.equals(((PointLight)obj).get_position()))&&
				this._kc==((PointLight)obj).get_kc()&&
				this._kl==((PointLight)obj).get_kl()&&
				this._kq==((PointLight)obj).get_kq()) {
			
			isEqual=true;
		}
		
		
		return isEqual;
		
	}

}
