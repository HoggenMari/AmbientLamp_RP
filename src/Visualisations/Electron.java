package Visualisations;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;

public class Electron {

	PVector position;
	PApplet applet;
	PGraphics canvas;

	public Electron(PApplet a, PGraphics c) {
		applet = a;
		canvas = c;
		float x, y;
		x = 0;
		y = 0;
		switch ((int) applet.random(0, 3.9f)) {
		case 0:
			x = -10;
			y = applet.random(0, canvas.height);
			break;
		case 1:
			x = canvas.width + 10;
			y = applet.random(0, canvas.height);
			break;
		case 2:
			x = applet.random(0, canvas.width);
			y = -10;
			break;
		case 3:
			x = applet.random(0, canvas.width);
			y = canvas.height + 10;
			break;
		}
		position = new PVector(x, y);
	}
	
	public Electron(PApplet a, PGraphics c, double speed) {
		applet = a;
		canvas = c;
		float x, y;
		x = 0;
		y = 0;
		switch ((int) applet.random(0, 3.9f)) {
		case 0:
			x = -10;
			y = applet.random(0, canvas.height);
			break;
		case 1:
			x = canvas.width + 10;
			y = applet.random(0, canvas.height);
			break;
		case 2:
			x = applet.random(0, canvas.width);
			y = -10;
			break;
		case 3:
			x = applet.random(0, canvas.width);
			y = canvas.height + 10;
			break;
		}
		position = new PVector(x, y);
	}

	void move() {
		PVector direction = new PVector(canvas.width / 2, canvas.height / 2);
		direction.sub(position);
		direction.normalize();
		direction.mult(0.5f);
		position.add(direction);
		//((Object) direction).random2D();
		//direction.mult(0.3f);
		//position.add(direction);
	}

	void display() {
		move();
		canvas.beginDraw();
		//System.out.println(PVector.dist(position, new PVector(canvas.width / 2, canvas.height / 2)));
		canvas.fill(255, 255, 255, (PVector.dist(position, new PVector(canvas.width / 2,
				canvas.height / 2)) / PVector.dist(new PVector(0, 0), new PVector(canvas.width / 2,
						canvas.height / 2)))*255);
		canvas.ellipse(position.x, position.y, PVector.dist(position, new PVector(canvas.width / 2,
				canvas.height / 2))*0.5f, PVector.dist(position, new PVector(canvas.width / 2,
						canvas.height / 2))*0.5f);
		canvas.endDraw();
	}

	boolean dead() {
		float d = PVector.dist(position, new PVector(canvas.width / 2,
				canvas.height / 2));
		if (d < 5) {
			return true;
		} else
			return false;
	}

}
