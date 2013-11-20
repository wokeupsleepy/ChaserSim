package mapper;

import mover.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class MoverLogic {
	
	static int turnCounter;
	static List<MovingBody> movingBodyBag = new ArrayList<MovingBody>();
	
	//the sequence of method calls was determined using the scaffolding code at the bottom
	public static void pauseAndSetGrid(GridGenerator gridPhysInput) {

		gridPhysInput.setGrid();
		gridPhysInput.setBounds();
		for(int i = 0; i < movingBodyBag.size(); i++) {
			MovingBody movingElement = movingBodyBag.get(i);
			gridPhysInput.setPosition(movingElement.getXCoor(), movingElement.getYCoor(), 
					movingElement.getIdValue());
		}
		System.out.println("Physical Grid at Turn " + turnCounter + ": ");
		gridPhysInput.printGrid();
		System.out.print("\n");
		turnCounter++;
		
	}
	
	public static void moverRestrictions(MovingBody movingInput, GridGenerator gridInput) {
		int startXCoor, endXCoor, startYCoor, endYCoor;
		String badnessYo = "You're walking into a wall";
		startXCoor = movingInput.getXCoor();
		startYCoor = movingInput.getYCoor();
		if (movingInput.wantMoveUp == true) {
			endYCoor = startYCoor - 1;
			endXCoor = startXCoor;
		}
	}
	
	//purpose: Determine if the Predator knows where the Prey is, AND...
		//if so, move Predator toward Prey
	//logic: Find the abs. value of the difference between the coordinates of Predator and Prey
	//If it is within predatorSenseRadius, then the Predator knows where the prey is
	//code complete, but not tested (HERE)
	//consder removing all the **AndSetGrid methods and adjusting the MoveLogic method to perform the move
	public static void predatorMoveLogic(Predator predatorInput, Prey preyInput) {

		int predatorSenseRadius = predatorInput.getSenseRadius();
		
		boolean predatorYOverPreyY = predatorInput.getYCoor() > preyInput.getYCoor(), 
				predatorXOverPreyX = predatorInput.getXCoor() > preyInput.getXCoor(), 
				preyYOverPredatorY = preyInput.getYCoor() > predatorInput.getYCoor(), 
				preyXOverPredatorX = preyInput.getXCoor() > predatorInput.getXCoor(), 
				distWithinSense = (Math.abs(predatorInput.getYCoor() - preyInput.getYCoor()) <= predatorSenseRadius)
				&& (Math.abs(predatorInput.getXCoor() - preyInput.getXCoor()) <= predatorSenseRadius);
		
		if(distWithinSense == true) {
			if(predatorInput.getYCoor() == preyInput.getYCoor() && 
					predatorInput.getXCoor() == preyInput.getXCoor()) {
				System.out.println("Game Over! The Prey has been caught.");
			}
			else if(predatorInput.getYCoor() == preyInput.getYCoor() && predatorXOverPreyX == true) {
				System.out.println("The Predator is to the right of the Prey.");
			}
			else if(predatorInput.getYCoor() == preyInput.getYCoor() && preyXOverPredatorX == true) {
				System.out.println("The Predator is to the left of the Predator.");
			}
			else if(predatorInput.getXCoor() == preyInput.getXCoor() && predatorYOverPreyY == true) {
				System.out.println("The Predator is below the Prey.");
			}
			else if(predatorInput.getXCoor() == preyInput.getXCoor() && preyYOverPredatorY == true) {
				System.out.println("The Predator is above the Prey.");
			}
			else if(predatorYOverPreyY == true && predatorXOverPreyX == true) {
				System.out.println("The Predator is below and to the right of the Prey.");
			}
			else if(predatorYOverPreyY == true && preyXOverPredatorX == true) {
				System.out.println("The Predator is below and to the left of the Prey.");
			}
			else if(preyYOverPredatorY == true && predatorXOverPreyX == true) {
				System.out.println("The Prey is below and to the left of the Predator.");
			}
			else if(preyYOverPredatorY == true && preyXOverPredatorX == true) {
				System.out.println("The Prey is below and to the right of the Predator.");
			}
		}
		else{
			System.out.println("The Prey is not nearby...");
		}
	}

}
//		The following is commented-out scaffolding and test code to see if this junk works
//		Conclusion: It works
		
//		System.out.println("This is the 1st snapshot of phys:");
//		physicalLayer1.printGrid();
//		System.out.print("\n");
//		
//		//the next bit of code displays all the actions necessary to move the element directionally
//		//movements can be chained together
//		
//		predatorAlpha.moveLeft();
//		predatorAlpha.moveUp();
//		physicalLayer1.setGrid();
//		physicalLayer1.setBounds();
//		physicalLayer1.setPosition(predatorAlpha.getXCoor(), predatorAlpha.getYCoor(), 
//				predatorAlpha.getIdValue());
//		
//		System.out.println("This is the 2nd snapshot of phys:");
//		physicalLayer1.printGrid();
//		System.out.print("\n");
//		
//		//end element movement
//		
//		GridGenerator sensoryLayer1 = new GridGenerator(10,15);
//		sensoryLayer1.setGrid();
//		sensoryLayer1.setBounds();
//		
//		//adds predator to sensoryLayer
//		sensoryLayer1.setPosition(predatorAlpha.getXCoor(), predatorAlpha.getYCoor(), 
//				predatorAlpha.getIdValue());
//		
//		//generate sense radius of predator and add it to sensoryLayer
//		predatorAlpha.setSenseRadius(2);
//		predatorAlpha.setSenseArray();
//		predatorAlpha.addSenseArray(sensoryLayer1.getGrid());
//		
//		//scaffolding code to check if SenseArray was created properly
//		System.out.println("senseArray for predatorAlpha:");
//		for (int y = 0; y < predatorAlpha.getSenseRadius()*2 + 1; y++) {
//			for (int x = 0; x < predatorAlpha.getSenseRadius()*2 + 1; x++) {
//				System.out.print(predatorAlpha.senseArray[y][x] + " ");
//			}
//			System.out.print("\n");
//		}
//		//conclusion, yes it was
//		
//		//steps for movement:
//			//direction, set position on phys, set position on sensory, set sensoryArray,
//			//decide next direction, print grids
//		
//		predatorAlpha.moveUp();
//		predatorAlpha.moveRight();
//		predatorAlpha.moveRight();
//		physicalLayer1.setGrid();
//		physicalLayer1.setBounds();
//		physicalLayer1.setPosition(predatorAlpha.getXCoor(), predatorAlpha.getYCoor(), 
//				predatorAlpha.getIdValue());
//		sensoryLayer1.setGrid();
//		sensoryLayer1.setBounds();
//		sensoryLayer1.setPosition(predatorAlpha.getXCoor(), predatorAlpha.getYCoor(), 
//				predatorAlpha.getIdValue());
//		predatorAlpha.addSenseArray(sensoryLayer1.getGrid());
//		physicalLayer1.printGrid();
//		System.out.print("\n");
//		sensoryLayer1.printGrid();
//		
//		//add logic for deciding next movement

