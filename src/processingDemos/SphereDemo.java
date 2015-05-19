package processingDemos;

import processing.core.PApplet;
import processing.opengl.*;

public class SphereDemo  extends PAppletWrapper{
	public void setup() {
		size(1000, 500, P3D);
		background(255);
		smooth();
	}
	int velocity = 10;
	
	float xVel = 0;
	float yVel = 0;
	float xAcc = 0;
	float yAcc = 0;
	int sphereSize = 100;

	float xPosition =sphereSize+5;
	float yPosition = sphereSize+5;
	float xRot = 0;
	float yRot = 0;
	
	public	void draw(){
		background(255);

		
		//xAcc = mouseX-xPosition/500;//(int) atan((float) (mouseX/(.001 + xPosition)));
		xAcc =  (float) (((mouseX- xPosition)/(float) width));
		yAcc =  (float) (((mouseY- yPosition)/(float)height));

		xVel += xAcc;
		yVel += yAcc;
		
		//yAcc = (int) atan((float) (mouseY/(.001 + yPosition)));
		//yVel += yAcc*distanceFromMouse;
		

		
		translate(xPosition, yPosition);
		
		if (xPosition < sphereSize || xPosition > width-sphereSize) {
			xVel *= -1;
			fill((frameCount+100 * 15) % 255, (frameCount+100 * 2) % 255,
				      (frameCount+100 * 7) % 255);
			xVel *= .8;
			if (xPosition < sphereSize) xPosition = sphereSize;
			else xPosition = width-1-sphereSize;
			yRot = (float) Math.max(xRot-.4*xVel, 5);
		}
		if (yPosition < sphereSize || yPosition > height-sphereSize) {
			yVel *= -1;
			fill((frameCount+100 * 8) % 255, (frameCount+100 * 6) % 255,
				      (frameCount+100 * 2) % 255);
			yVel *= .8;
			if (yPosition < sphereSize) yPosition = sphereSize;
			else yPosition = height-1-sphereSize;
			xRot = (float) Math.max(xRot-.4*yVel, 5);
		}
		
		xPosition += xVel;
		yPosition += yVel;
		

		
		//background(255);
		

		//pushMatrix();
		
		rotateX(radians(frameCount*xRot%360));
		rotateY(radians(frameCount*yRot%360));
		sphere(sphereSize);
		//popMatrix();
		
		
	}
	
	public boolean sketchFullScreen() {
		  return true;
		}
}
