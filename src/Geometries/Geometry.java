package Geometries;
import Primitives.*;
import Primitives.Vector;
import java.awt.Color;

import java.util.*;


public abstract class Geometry {
	protected Color _emission;
	protected Material _material;

	
	public abstract List <Point3D> findIntersections(Ray ray) ;
	public abstract Vector getNormal(Point3D p);
	
	public Geometry() {
		this._emission=Color.white;
		this._material=new Material();
	}
	
	public Geometry(Color _emission,Material _material) {
		this._emission=_emission;
		this._material=_material;
	}
	public Geometry(Color _emission) {
		this._emission=_emission;
		this._material=new Material();
	}
	
	public Color get_emission() {
		return _emission;
	}
	public void set_emission(Color _emission) {
		this._emission = _emission;
	}
	public Material get_material() {
		return _material;
	}
	public void set_material(Material _material) {
		this._material = _material;
	}
	@Override
	public String toString() {
		return "Geometry [_emission=" + _emission + ", _material=" + _material + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_emission == null) ? 0 : _emission.hashCode());
		result = prime * result + ((_material == null) ? 0 : _material.hashCode());
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
		Geometry other = (Geometry) obj;
		if (_emission == null) {
			if (other._emission != null)
				return false;
		} else if (!_emission.equals(other._emission))
			return false;
		if (_material == null) {
			if (other._material != null)
				return false;
		} else if (!_material.equals(other._material))
			return false;
		return true;
	}
	
	
	
	
	

}
