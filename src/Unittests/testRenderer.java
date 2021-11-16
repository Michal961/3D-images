package Unittests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;


import Elements.Camera;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Scene.Scene;
import Renderer.*;


class testRenderer {
/*
	@Test
	public void basicRenderTwoColorTest() {

		Scene scene = new Scene("Test scene");
		scene.setCamera(new Camera(new Point3D(), new Vector(0, 0, 1), new Vector(0, -1, 0)));
		scene.set_screenDistance(100) ;
		scene.set_background(new Color(0,0,0));;
		
		scene.addGeometry(new Sphere(50, new Point3D(0, 0, 100),new Color(255,0,0)));

		scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, 100, 100), new Point3D(100, 100, 100),new Color(255,255,0)));
		scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100),new Color(0,255,0)));
		scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, 100, 100), new Point3D(-100, 100, 100),new Color(0,0,255)));
		scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, -100, 100), new Point3D(-100, -100, 100),new Color(0,255,255)));

		ImageWriter imageWriter = new ImageWriter("two color test", 500, 500, 500, 500);
		Renderer render= new Renderer(imageWriter, scene);
		render.renderImage();
	}

*/

@Test
public void basicRenderTwoColorTest2() {/*

	Scene scene = new Scene("Test Renderer");
	scene.setCamera(new Camera(new Point3D(), new Vector(0, 0, 1), new Vector(0, -1, 0)));
	scene.set_screenDistance(130) ;
	scene.set_background(new Color(255,255,151));
	
	scene.addGeometry(new Sphere(50, new Point3D(70, 0, 100),new Color(255,51,51)));
	scene.addGeometry(new Sphere(20, new Point3D(0, 0, 100),new Color(51,0,0)));
	scene.addGeometry(new Sphere(50, new Point3D(0, 70, 100),new Color(255,51,51)));
	scene.addGeometry(new Sphere(50, new Point3D(-70, 0, 100),new Color(255,51,51)));
	scene.addGeometry(new Sphere(50, new Point3D(0, -70, 100),new Color(255,51,51)));
	scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, 100, 100), new Point3D(100, 100, 100),new Color(153,0,0)));
	scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100),new Color(153,0,0)));
	scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, 100, 100), new Point3D(-100, 100, 100),new Color(153,0,0)));
	scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, -100, 100), new Point3D(-100, -100, 100),new Color(153,0,0)));
	
	
	
	
	ImageWriter imageWriter = new ImageWriter("Renderer test", 500, 500, 500, 500);
	Renderer render= new Renderer(imageWriter, scene);
	render.renderImage();
*/
}
}