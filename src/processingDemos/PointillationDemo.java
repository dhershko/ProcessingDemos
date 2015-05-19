package processingDemos;

import processing.core.*;

public class PointillationDemo extends PApplet {

	PImage img;
	float pointRadius = 100;

	public void setup() {
		
		String url = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSmjOJ3ZnNbK7mmYbirShpZtDgiB8JHUxg-J_HbwtqcmS2gvcVFTJXFUg";
//		String url = "http://breadedcat.com/wp-content/uploads/2012/02/cat-breading-tutorial-004.jpg";
		img = loadImage(url, "png");
		imageMode(CENTER);
		size(1000, 500);
		noStroke();
		background(255);
	}

	public void draw() { 
		pointRadius = map(mouseX, 0, width, 1, 80);
		//if (pointRadius > 25) pointRadius = (float) (pointRadius -.5);
		for (int i =0; i < 1000; i ++) {
			int x = (int)(random(img.width));
			int y = (int)(random(img.height));
			
			float xToUse =  map(x, 0, img.width, 0, width);
			float yToUse = map(y, 0, img.height, 0, height);
			
			float distanceFromMouse = (float) Math.sqrt(Math.pow(xToUse - mouseX,2) + Math.pow(yToUse - mouseY, 2)); 
			
			pointRadius = Math.min(distanceFromMouse/10, 80);
			
			int pix = img.get(x, y);
			fill(pix, 128);
			ellipse(xToUse, yToUse, pointRadius, pointRadius);
		}
	}


	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", PointillationDemo.class.getName() });
	}
}
