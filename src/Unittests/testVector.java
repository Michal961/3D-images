package Unittests;

import static org.junit.Assert.*;
import org.junit.Test;

import Primitives.*;



//the fail



public class testVector {
	   @Test
	    public void testLength() {
	        // TC01: Simple test
		   Point3D p1=new Point3D(new Coordinate(0),new Coordinate(3),new Coordinate(4));
	        assertEquals("length() wrong value", 5, new Vector(p1).length(), 0.00001);
	      
	    
	    }

	   @Test
	    public void testNormalized() {
		   Point3D p1=new Point3D(new Coordinate(0),new Coordinate(3),new Coordinate(4));
	        Vector v = new Vector(p1);
	        Vector n = v.normalize();
	        // ============ Equivalence Partitions Tests ==============
	        // TC01: Simple test
	        assertFalse("normalized() changes the vector itself", v == n);
	        assertEquals("wrong normalized vector length", 1, n.length(), 0.00001);
		    }
	   
  @Test
    public void testAdd() {
	  Point3D p1=new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(1));
	  Point3D p2=new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(4));
	  Point3D p3=new Point3D(new Coordinate(-1),new Coordinate(-2),new Coordinate(-3));
        // TC01: Simple test
        assertEquals("Wrong vector add", new Vector(p1),new Vector(p2).add(new Vector(p3)));
        // TC11: test adding v + (-v)
        Point3D p4=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
        try {
            new Vector(p4).add(new Vector(p3));
            fail("IllegalArgumentException");
       } catch (IllegalArgumentException e) {
        	
        }
    }
    
  
    @Test
    public void testSubtract() {
      Point3D p1=new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(1));
  	  Point3D p2=new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(4));
  	  Point3D p3=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
        // TC01: Simple test
        assertEquals("Wrong vector subtract", new Vector(p1),
                new Vector(p2).subtract(new Vector(p3)));

        // TC11: test subtracting same vector
       try {
            new Vector(p3).subtract(new Vector(p3));
            fail("Subtract v from v must throw exception");
        } catch (IllegalArgumentException e) {}
    }
    
    @Test
    public void testScale() {
    	 Point3D p1=new Point3D(new Coordinate(2),new Coordinate(4),new Coordinate(6));
     	 Point3D p2=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
        // TC01: Simple test
        assertEquals("Wrong vector scale", new Vector(p1),
                new Vector(p2).scale(2));

         //TC11: testmult by 0
        try {
            new Vector(p2).scale(0);
            fail("Scale by 0 must throw exception");
        } catch (IllegalArgumentException e) {}
    }
    
    
    @Test
   public void testDotProduct() {
   	 Point3D p1=new Point3D(new Coordinate(-2),new Coordinate(-4),new Coordinate(-6));
 	 Point3D p2=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
 	 Point3D p3=new Point3D(new Coordinate(0),new Coordinate(3),new Coordinate(-2));
    	
       Vector v1 = new Vector(p2);

       // TC01: Simple dotProduct test
       Vector v2 = new Vector(p1);
       assertEquals("dotProduct() wrong value", -28, v1.dotProduct(v2), 0.00001);

       // TC11: dotProduct for orthogonal vectors
       Vector v3 = new Vector(p3);
       assertEquals("dotProduct() for orthogonal vectors is not zero", 0, v1.dotProduct(v3), 0.00001);
   }

   @Test
    public void testCrossProduct() {
	   
	   	 Point3D p1=new Point3D(new Coordinate(0),new Coordinate(3),new Coordinate(-2));
	 	 Point3D p2=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
	 	 Point3D p3=new Point3D(new Coordinate(-2),new Coordinate(-4),new Coordinate(-6));
         Vector v1 = new Vector(p2);

        // ============ Equivalence Partitions Tests ==============
        Vector v2 = new Vector(p1);
        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        
        //----------> cant under
         assertEquals("crossProduct() wrong result length", v1.length() * v2.length(), vr.length(), 0.00001);


        // TC02: Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand",vr.dotProduct(v1)==0);// isZero(vr.dotProduct(v1)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand",vr.dotProduct(v2)==0);// isZero(vr.dotProduct(v2)));

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(p3);
        try {
            v1.crossProduct(v3);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {}
    }

    @Test
    public void testPointSubtract() {
    	
    	 Point3D p1=new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(1));
	 	 Point3D p2=new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(4));
	 	 Point3D p3=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
	 	 
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple test
        assertEquals("Wrong point subtract", new Vector(p1),
               p2.subtract(p3));

        // =============== Boundary Values Tests ==================
        // TC11: test subtracting same point
        try {
               p3.subtract(p3);
            fail("Subtract P from P must throw exception");
        } catch (IllegalArgumentException e) {}
    }

    

}