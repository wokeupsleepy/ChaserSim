package mapper;

import mover.Predator;
import mover.Prey;
import java.util.Scanner;

//contains the main method and handles input from user

public class UserController {
	
	public static void main(String[] args) {
		
		GridGenerator physicalLayer1 = new GridGenerator(20,35);
		Predator predatorAlpha = new Predator(6,9);
		Prey preyAlpha = new Prey(7,11);
		MoverLogic.movingBodyBag.add(predatorAlpha);
		MoverLogic.movingBodyBag.add(preyAlpha);
		predatorAlpha.setSenseArray();
		preyAlpha.setSenseArray();
		
		MoverLogic.pauseAndSetGrid(physicalLayer1);
		MoverLogic.predatorMoveLogic(predatorAlpha, preyAlpha);
	}

}
