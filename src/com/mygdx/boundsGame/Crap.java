package com.mygdx.boundsGame;

import com.badlogic.gdx.math.Circle;

public class Crap {

	
	public Crap(){
		
	}
	
	public void setCircle(){
		Circle c = new Circle();
		c.overlaps(c);
	}
}
