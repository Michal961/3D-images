package Primitives;

public class Material {
	private double _kd = 0d;
    private double _ks = 0d;
    private int _nShininess = 1;

	public  Material(Material material) {
		  _kd =material.getKd() ;
	      _ks = material.getKs();
	      _nShininess = material.getShininess();
	}
	public  Material() {
		  _kd = 0d;
	      _ks = 0d;
	      _nShininess = 1;
	}
	public  Material(double kd,double ks, int nS){
		 _kd = kd;
	     _ks = ks;
	     _nShininess = nS;
	}
    /**
  	 * Diffusion attenuation factor getter/setter
     */
    public double getKd() {
    	return _kd;
    	}
   	public void setKd(double kd) {
   		_kd = kd;
   		}

    /**
  	 * Specular attenuation factor getter/setter
     */
    public double getKs() {
    	return _ks;
    	}
   	public void setKs(double ks) {
   		_ks = ks;
   		}

    /**
     * Shininess level getter/setter
     */
    public int getShininess() {
    	return _nShininess; 
    	}
   	public void setShininess(int nShininess) {
   		_nShininess = nShininess;
   		}
	@Override
	public String toString() {
		return "Material [_kd=" + _kd + ", _ks=" + _ks + ", _nShininess=" + _nShininess + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(_kd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(_ks);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + _nShininess;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
			return false;
		if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
			return false;
		if (_nShininess != other._nShininess)
			return false;
		return true;
	}
	


   	
   	

}
