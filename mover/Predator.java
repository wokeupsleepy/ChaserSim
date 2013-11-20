package mover;

import mapper.*;

public class Predator extends MovingBody{

	public Predator(int xCoor, int yCoor) {
		super(xCoor, yCoor);
		idValue = 2; //2 represents the predator
		senseRadius = 5;
	}
	

}