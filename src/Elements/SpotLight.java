package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class SpotLight extends PointLight{
	private Vector _direction;
	

	public SpotLight(Color _intensity,Point3D _position,Vector _direction, double _kc, double _kl, double _kq) {
		super(_intensity,_position, _kc, _kl, _kq);
		this._direction = _direction.normalize();
	}
	public SpotLight(SpotLight other) {
		super(other.get_intensity(),other.get_position(), other.get_kc(), other.get_kl(),other.get_kq());
		this._direction=new Vector(other.get_direction());
	}

	@Override
	public String toString() {
		return "SpotLight [_direction=" + _direction + "]";
	}

	public Vector get_direction() {
		return _direction;
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}

	@Override
	public Color getIntensity(Point3D point) {
		Vector lVector=this.getL(point).scale(-1);
		double dirL=get_direction().dotProduct(lVector);
		Color numerator;
		if(dirL<=0) {
			numerator= new Color(0,0,0);
		 }
		else {
		numerator= new Color((int)(this._intensity.getRed()*dirL),
							 (int)(this._intensity.getGreen()*dirL),
							(int)(this._intensity.getBlue()*dirL));
		}
		double d=point.distance(this.get_position());
		double denominator=(this.get_kc()+(this.get_kl()*d))+(this.get_kq()*(Math.pow(d, 2)));
		
		return new Color((int)(numerator.getRed()/denominator),
						(int)(numerator.getGreen()/denominator),
						 (int)(numerator.getBlue()/denominator));
		
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
		else if(super.equals(obj) && (this.get_direction().equals(((SpotLight)obj).get_direction()))) {
			
			isEqual=true;
		}
		
		
		return isEqual;
		
	}
	

}
