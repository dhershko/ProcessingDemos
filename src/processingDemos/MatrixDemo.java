package processingDemos;

import processing.core.*;

public class MatrixDemo extends PAppletWrapper {

	public void setup() {
		frameRate(60);
		  size(200, 200);
		  background(255);
		  smooth();
		  noStroke();
		}

	public	void draw(){
		  if (frameCount % 2 == 0) {
		    fill(frameCount * 3 % 255, frameCount * 5 % 255,
		      frameCount * 7 % 255);
		    
		    pushMatrix();
		   
		    translate(100, 100);
		    rotate(radians(frameCount * 5  % 360));
		    float scaleMax = 100;
		    float toScaleBy =  (((frameCount % scaleMax) + 1)/(float)scaleMax);
		    
		    scale(toScaleBy);
		    
		    rect(0, 0, 80, 20);
		    rotate(radians(180));
		    rect(0, 0, 80, 20);
		    popMatrix();
		  }
		}


	public static void main(String args[]) {
		PAppletWrapper.main(new String[] { "--present", MatrixDemo.class.getName() });
	}
}
