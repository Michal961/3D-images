package Unittests;
import Geometries.*;
import Primitives.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GeometryTest {
/*
	@Test
	void toStringTest() {
		Point3D p1=new Point3D();
		Point3D p2=new Point3D(new Coordinate(7),new Coordinate(8),new Coordinate(9));
		Point3D p3=new Point3D(new Coordinate(4),new Coordinate(5),new Coordinate(6));
		Vector v1=new Vector(new Point3D(new Coordinate(4),new Coordinate(5),new Coordinate(6)));

		Geometry firsrGeometry=new Triangle(p1,p2,p3);
		Geometry secondGeometry=new Plane(p2, v1);
		Geometry thirdGeometry=new Triangle();

		List<Geometry> geometryList=new ArrayList<Geometry>();
		geometryList.add(firsrGeometry);
		geometryList.add(secondGeometry);
		geometryList.add(thirdGeometry);
	//	geometryList.add(new Cylinder(new Ray(v1, p1), 3.5, 5));
		geometryList.add(new Triangle());
		
		
		//toString test for Triangle
		String firstElement=geometryList.get(0).toString();//Triangle toString 
		String secondElement=geometryList.get(1).toString();//Plane toString
		
		
		//Triangle toString 
		assertEquals("(0.0,0.0,0.0),(7.0,8.0,9.0),(4.0,5.0,6.0)",firstElement);
		
		//Plane toString
		assertEquals("Plane:(7.0,8.0,9.0),(4.0,5.0,6.0)",secondElement);

		
	}
	
	@Test
	void equalsTest() {
		
		Point3D p1=new Point3D();
		Point3D p2=new Point3D(new Coordinate(7),new Coordinate(8),new Coordinate(9));
		Point3D p3=new Point3D(new Coordinate(4),new Coordinate(5),new Coordinate(6));
	//	Vector v1=new Vector(new Point3D(new Coordinate(4),new Coordinate(5),new Coordinate(6)));
		
		Geometry firsrGeometry=new Triangle(p1,p2,p3);
		Geometry secondGeometry=new Triangle();
		Geometry thirdGeometry=secondGeometry;
		
		
		List<Geometry> geometryList=new ArrayList<Geometry>();
		geometryList.add(firsrGeometry);
		geometryList.add(secondGeometry);
		geometryList.add(thirdGeometry);
		//geometryList.add(new Cylinder(new Ray(v1, p1), 3.5, 5));
		geometryList.add(new Triangle());
		
		boolean firstAndSecond=geometryList.get(0).equals(geometryList.get(1));
		boolean SecondAndThird=geometryList.get(1).equals(geometryList.get(2));
		//first and second element check
		assertEquals(false,firstAndSecond);
		
		//second and third element check
		assertEquals(true,SecondAndThird);
		
	}
	
*/
}
