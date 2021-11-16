package Unittests;


import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

import Elements.Camera;
import Primitives.*;


public class testCamera {

    
    @Test
    public void testConstructRayThroughPixel() {
    	Point3D p1=new Point3D();
		Vector v1=new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1)));
		Vector v2=new Vector(new Point3D(new Coordinate(0),new Coordinate(-1),new Coordinate(0)));
		Vector v3=new Vector(new Point3D(new Coordinate(-2),new Coordinate(-2),new Coordinate(10)));
		Vector v4=new Vector(new Point3D(new Coordinate(-3),new Coordinate(-3),new Coordinate(10)));
		Vector v5=new Vector(new Point3D(new Coordinate(-1),new Coordinate(-3),new Coordinate(10)));
		Vector v6=new Vector(new Point3D(new Coordinate(-1),new Coordinate(-1),new Coordinate(10)));
		Vector v7=new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(10)));
		Vector v8=new Vector(new Point3D(new Coordinate(0),new Coordinate(-2),new Coordinate(10)));
		Vector v9=new Vector(new Point3D(new Coordinate(-2),new Coordinate(0),new Coordinate(10)));
		
    	
    	
        Camera camera = new Camera(p1, v1, v2);
        
        // ============ Equivalence Partitions Tests ==============
        // TC01: 3X3 Corner (0,0)
        assertEquals("Bad ray", new Ray(p1, v3.normalize()),
               camera.constructRayThroughPixel(3, 3, 0, 0, 10, 6, 6));
        
        
        // TC02: 4X4 Corner (0,0)
        assertEquals("Bad ray", new Ray(p1, v4.normalize()),
               camera.constructRayThroughPixel(4, 4, 0, 0, 10, 8, 8));

        // TC03: 4X4 Side (0,1)
        assertEquals("Bad ray", new Ray(p1, v5.normalize()),
               camera.constructRayThroughPixel(4, 4, 1, 0, 10, 8, 8));

        // TC04: 4X4 Inside (1,1)
        assertEquals("Bad ray", new Ray(p1,v6.normalize()),
                camera.constructRayThroughPixel(4, 4, 1, 1, 10, 8, 8));
        
        
        
       
        // =============== Boundary Values Tests ==================
        // TC11: 3X3 Center (1,1)
        assertEquals("Bad ray", new Ray(p1, v7.normalize()),
                camera.constructRayThroughPixel(3, 3, 1, 1, 10, 6, 6));

        // TC12: 3X3 Center of Upper Side (0,1)
       assertEquals("Bad ray", new Ray(p1,v8.normalize()),
                camera.constructRayThroughPixel(3, 3, 1, 0, 10, 6, 6));

        // TC13: 3X3 Center of Left Side (1,0)
        assertEquals("Bad ray", new Ray(p1, v9.normalize()),
                camera.constructRayThroughPixel(3, 3, 0, 1, 10, 6, 6));
       
    }

}