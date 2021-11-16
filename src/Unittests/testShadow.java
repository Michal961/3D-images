package Unittests;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Elements.*;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;

class testShadow {

	/*
		@Test
		public void twoTriangles(){
			
			Scene scene = new Scene("twoTriangles");
			scene.set_background(new Color(0, 0, 0));
			scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
			scene.set_screenDistance(100);
			scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));

			
			Triangle triangle1 = new Triangle(new Point3D(-100, 100, 150),
						new Point3D(100, 100, 150),
						new Point3D(0, -150, 150),
						new Color (0, 0, 255));

			Sphere sphere = new Sphere(300, new Point3D(0, 0, 400),new Color(0, 0, 255));
			Material m2=new Material(1,1,20);
			sphere.set_material(m2);
			scene.addGeometry(sphere);
		
			
			Material m1=new Material(1,1,20);
			triangle1.set_material(m1);
			scene.addGeometry(triangle1);
			sphere.set_material(m2);
			scene.addGeometry(sphere);
			
			
			Triangle triangle = new Triangle(new Point3D(-125, 225, 260),
					 new Point3D(-225, 125, 260),
					 new Point3D(-225, 225, 270),
					 new Color (0, 0, 100));

Material m3=new Material(1,1,4);
triangle.set_material(m3);
//scene.addGeometry(triangle);
		
			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(0, 200, 0), new Vector(0,-100,150), 0, 0.000001, 0.0000005));
		
			ImageWriter imageWriter = new ImageWriter("twoTriangles", 500, 500, 500, 500);
			
			Renderer render = new Renderer(imageWriter, scene);
			
			render.renderImage();
			
		}
		*/
		/*
		@Test
		public void spotLightTest2(){
			
			Scene scene = new Scene("spotLightTest2");
			scene.set_background(new Color(0, 0, 0));
			scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
			scene.set_screenDistance(200);
			scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));

			Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, 1000),new Color(0, 0, 100));
			Material m1=new Material(1,1,20);
			sphere.set_material(m1);
			scene.addGeometry(sphere);
			
			Triangle triangle = new Triangle(new Point3D(-125, 225, 260),
											 new Point3D(-225, 125, 260),
											 new Point3D(-225, 225, 270),
											 new Color (0, 0, 100));
			
			Material m2=new Material(1,1,4);
			triangle.set_material(m2);
			scene.addGeometry(triangle);
			
//			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, -150), new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
			scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, 200, -100),  0, 0.000001, 0.0000005));
	
			ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);
			
			Renderer render = new Renderer(imageWriter, scene);
			
			render.renderImage();
			
		}
		
		
	@Test
	public void pointLightTest2223(){
		
		Scene scene = new Scene("pointLightTest2223");
		scene.set_background(new Color(0, 0, 0));
		scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
		scene.set_screenDistance(100);
		scene.setAmbientLight(new AmbientLight(new Color(170,0,104), 0.1));
		Light diLight=new DirectionalLight(new Color(50, 50, 0), new Vector(3,-1,2));
		
		scene.addLight(diLight);

		Material m1=new Material(1,1,1);
		Material m2=new Material(1,1,20);

		
		Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, 2000),
				 new Point3D( -3500, -3500, 1000),
				 new Point3D(  3500, -3500, 2000),
				 new Color(0,0,0));

		triangle1.set_material(m1);
		
		Triangle triangle12 = new Triangle(new Point3D(-300, 0, 300),
				 new Point3D(300, 0, 300),
				 new Point3D(0, -600, 300),
				 new Color (0, 0, 100));

			Material m12=new Material(1,1,4);
			triangle12.set_material(m12);
			//scene.addGeometry(triangle12);
		
		
		
			Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, 1000),new Color(102, 0, 0));
			sphere.set_material(m2);

		
		
		scene.addGeometry(sphere);
		//scene.addGeometry(triangle1);
	
		scene.addLight(new PointLight(new Color(128, 120, 120), new Point3D(100, -100, 100),  0, 0.00000001, 0.000000005));

		
		ImageWriter imageWriter = new ImageWriter("shadowTest1", 500, 500, 500, 500);
		
		Renderer render = new Renderer(imageWriter, scene);
		
		render.renderImage();
		
	}
	

	@Test
	public void pointLightTest22243(){
		
		Scene scene = new Scene("pointLightTest22243");
		scene.set_background(new Color(140, 151, 255));
		scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
		scene.set_screenDistance(100);
		scene.setAmbientLight(new AmbientLight(new Color(200,153, 153), 0.1));
	

		Material m1=new Material(1,1,1);
		Material m2=new Material(1,1,20);

		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, 1000),new Color(0, 0, 255));
		sphere.set_material(m2);
		
		Sphere sphere3 = new Sphere(300, new Point3D(0.0, 0,500),new Color(200, 0, 0));
		sphere3.set_material(m1); 
		scene.addGeometry(sphere);

		
		Triangle triangle32 = new Triangle(new Point3D(-100, 100, 150),
					new Point3D(100, 100, 150),
					new Point3D(0, -100, 150),
					new Color (0, 0, 255));


		triangle32.set_material(m1);
		scene.addGeometry(triangle32);
		scene.addGeometry(sphere3);
		
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(300, -300, -200), new Vector(-2, -2, -3), 0, 0.0001, 0.00005));
		
		ImageWriter imageWriter = new ImageWriter("shadowTest2", 500, 500, 500, 500);
		
		Renderer render = new Renderer(imageWriter, scene);
		
		render.renderImage();
		
	}
	
	

	@Test
	public void pointLightTest22243(){
		
		Scene scene = new Scene("pointLightTest22243");
		//scene.set_background(new Color(140, 151, 255));
		scene.set_background(new Color(0, 0, 0));
		scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
		scene.set_screenDistance(100);
		scene.setAmbientLight(new AmbientLight(new Color(200,153, 153), 0.1));
	

		Material m1=new Material(1,1,1);
		//Material m2=new Material(1,1,20);

		Sphere sphere = new Sphere(300, new Point3D(0, 0, 400),new Color(0, 0, 255));
		Material m2=new Material(1,1,20);
		sphere.set_material(m2);
		scene.addGeometry(sphere);
	


		
		Triangle triangle32 = new Triangle(new Point3D(-100, 100, 150),
					new Point3D(100, 100, 150),
					new Point3D(0, -150, 150),
					new Color (255, 0, 255));
		
		
		Triangle triangle1 = new Triangle(new Point3D(-150, 100, 200),
				 new Point3D(150, 150, 200),
				 new Point3D(0, -200, 200),
				 new Color (0, 0, 100));

		//scene.addGeometry(sphere);
		triangle1.set_material(m1);
		triangle32.set_material(m1);
		scene.addGeometry(triangle1);
		//scene.addGeometry(triangle32);
		
		
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(300, -300, -200), new Vector(-2, -2, -3), 0, 0.0001, 0.00005));
		
		ImageWriter imageWriter = new ImageWriter("shadowTest232", 500, 500, 500, 500);
		
		Renderer render = new Renderer(imageWriter, scene);
		
		render.renderImage();
		
	}
	
	@Test
	public void pointLightTest222343(){
		
		Scene scene = new Scene("pointLightTest22243");
		scene.set_background(new Color(0, 0, 0));
		scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
		scene.set_screenDistance(100);
		scene.setAmbientLight(new AmbientLight(new Color(200,153, 153), 0.1));
	

		Material m1=new Material(1,1,1);
		Material m2=new Material(1,1,20);

		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, 1000),new Color(0, 0, 255));
		sphere.set_material(m2);
		
		Sphere sphere3 = new Sphere(300, new Point3D(0.0, 0,500),new Color(200, 0, 0));
		sphere3.set_material(m1); 
		scene.addGeometry(sphere);

		
		Triangle triangle32 = new Triangle(new Point3D(-100, 100, 150),
					new Point3D(100, 100, 150),
					new Point3D(0, -150, 150),
					new Color (0, 0, 255));


		triangle32.set_material(m1);
		scene.addGeometry(triangle32);
		scene.addGeometry(sphere3);
		
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(300, -300, -200), new Vector(-2, -2, -3), 0, 0.0001, 0.00005));
		
		ImageWriter imageWriter = new ImageWriter("shadowTest2", 500, 500, 500, 500);
		
		Renderer render = new Renderer(imageWriter, scene);
		
		render.renderImage();
		
	}
	
	
		@Test
		public void pointLightTest2223(){
			
			Scene scene = new Scene("pointLightTest2223");
			scene.set_background(new Color(0, 0, 0));
			scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
			scene.set_screenDistance(100);
			scene.setAmbientLight(new AmbientLight(new Color(0,8,128), 0.1));
			Light diLight=new DirectionalLight(new Color(50, 50, 0), new Vector(3,-1,2));
			
			scene.addLight(diLight);

			Material m1=new Material(1,1,1);
			Material m2=new Material(1,1,20);

			Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, 1000),new Color(0, 100, 0));
			sphere.set_material(m2);
			
			Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, 2000),
					 new Point3D( -3500, -3500, 1000),
					 new Point3D(  3500, -3500, 2000),
					 new Color(0,0,0));

			triangle1.set_material(m1);
			Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, 2000),
						  new Point3D( -3500,  3500, 1000),
						  new Point3D( -3500, -3500, 1000),
				      new Color(0,0,0));
			


			triangle2.set_material(m1);
			
			Triangle triangle32 = new Triangle(new Point3D(-100, 100, 150),
					new Point3D(100, 100, 150),
					new Point3D(0, -150, 150),
					new Color (0, 100, 0));


		triangle32.set_material(m1);
		scene.addGeometry(triangle32);
			
			scene.addGeometry(sphere);
			scene.addGeometry(triangle1);
			scene.addGeometry(triangle2);
			
			
			
			scene.addLight(new PointLight(new Color(128, 120, 120), new Point3D(-100, 300, 100),  0, 0.00000001, 0.000000005));

			
			ImageWriter imageWriter = new ImageWriter("Point test 2235", 500, 500, 500, 500);
			
			Renderer render = new Renderer(imageWriter, scene);
			
			render.renderImage();
			
		}

*/
@Test
public void spotLightTest3(){
	
	Scene scene = new Scene("spotLightTest3");
	scene.set_background(new Color(0, 0, 0));
	scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
	scene.set_screenDistance(100);
	scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
	Material m=new Material(1,1,1);

	Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, 2000),
			 						 new Point3D( -3500, -3500, 1000),
			 						 new Point3D(  3500, -3500, 2000),
			 						 new Color(0,0,0));

	triangle1.set_material(m);
	Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, 2000),
			  						  new Point3D( -3500,  3500, 1000),
			  						  new Point3D( -3500, -3500, 1000),
				 				      new Color(0,0,0));
	
	triangle2.set_material(m);

	//scene.addGeometry(triangle1);
	//scene.addGeometry(triangle2);
	
	Material m2=new Material(1,1,20);

	Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, 1000),new Color(102, 0, 0));
	sphere.set_material(m2);
	
	
	
	
	
	Triangle triangle32 = new Triangle(new Point3D(-100, 100, 150),
			new Point3D(100, 100, 150),
			new Point3D(0, -150, 150),
			new Color (204, 0, 0));
	
	triangle32.set_material(m);
	scene.addGeometry(sphere);
	scene.addGeometry(triangle32);

	
	scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(300, -300, -200), new Vector(-2, -2, -3), 0, 0.0001, 0.00005));
	
	
	ImageWriter imageWriter = new ImageWriter("Spot test 5", 500, 500, 500, 500);
	
	Renderer render = new Renderer(imageWriter, scene);
	
	render.renderImage();
	
	}
}
