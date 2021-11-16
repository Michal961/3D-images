package Primitives;

/**
 	* We will describe a point in space by using by using a coordinate
	*A coordinate system consists of an origin and directions
	*If we agree on a coordinate system, we can describe all vectors in that system with a vector of numbers


*/

public class Coordinate {
	private double coordinate;
	
	//constructors
	public Coordinate() {
		this.coordinate=0.0;
	}

	public Coordinate(double coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate(Coordinate coordinate) {
		this.coordinate=coordinate.coordinate;
	}
	
	
	/*
	 * Gets the coordinate
	 * @return coordinate
	 */
	public double get_coordinate() {
		return coordinate;
	}

	public void set_coordinate(double coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return ""+coordinate;
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
		else if(this.coordinate==((Coordinate)obj).get_coordinate()) {
			isEqual=true;
		}
		return isEqual; 		

	}
	
	


}
