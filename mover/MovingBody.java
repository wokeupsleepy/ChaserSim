package mover;

public class MovingBody {
	
	int xCoor;
	int yCoor;
	int idValue = 1;
	int senseRadius = 1; //this is the number of tiles away a MovingBody can sense
	public boolean wantMoveUp, wantMoveDown, wantMoveLeft, wantMoveRight, wantMoveUpLeft, wantMoveUpRight, wantMoveDownLeft, wantMoveDownRight;
	
	public MovingBody(int xCoorInput, int yCoorInput) {
		xCoor = xCoorInput;
		yCoor = yCoorInput;
	} //sets start positions
	
	public int getXCoor() {
		return xCoor;
	}
	
	public int getYCoor() {
		return yCoor;
	}
	
	public int getIdValue() {
		return idValue;
	}
	
	public void moveLeft() {
		xCoor -=1;
	}
	
	public void moveRight() {
		xCoor +=1;
	}
	
	public void moveUp() {
		yCoor -=1;
	}
	
	public void moveDown() {
		yCoor +=1;
	}
	
	public void setSenseRadius(int startingSenseRadius) {
		senseRadius = startingSenseRadius;
	}
	public int getSenseRadius() {
		return senseRadius;
	}
	
	//senseRadius provides the number of tiles the predator can "sense" another target
	//this value governs the method setSenseArray
	
	//still working (HERE)
	
	public int[][] senseArray;
	public void setSenseArray() {
		int senseArrayDimension = 2*senseRadius + 1;
		senseArray = new int[senseArrayDimension][senseArrayDimension];
		//creates the array showing the sense boundaries
		senseArray[senseRadius][senseRadius] = idValue;
		//sets the origin of senseArray
		for (int y = 0; y < senseArrayDimension; y++) {
			for (int x = 0; x < senseArrayDimension; x++) {
				if (senseArray[y][x] != idValue) {
					senseArray[y][x] = idValue * 3;
				}
			}
		}
	}
	
	//populate larger sensoryGrid argument with senseArray
	//basically, sensoryGrid[yCoor-senseRadius][xCoor-senseRadius] = senseArray[0][0]
	//really though... is addSenseArray really necessary?
	//need to update this such that they can overlap...
	public void addSenseArray(int[][] sensoryGrid) {
		for (int y = 0; y < senseRadius + 1; y++) {
			for (int x = 0; x < senseRadius + 1; x++) {
				if (sensoryGrid[yCoor - y][xCoor - x] != mapper.GridGenerator.getWallId()) {
					sensoryGrid[yCoor - y][xCoor - x] = senseArray[senseRadius - y][senseRadius - x];
				}
				else {
					continue;
				}
				if (sensoryGrid[yCoor + y][xCoor + x] != mapper.GridGenerator.getWallId()) {
					sensoryGrid[yCoor + y][xCoor + x] = senseArray[senseRadius - y][senseRadius + x];
				}
				else {
					continue;
				}
				if (sensoryGrid[yCoor + y][xCoor - x] != mapper.GridGenerator.getWallId()) {
				sensoryGrid[yCoor + y][xCoor - x] = senseArray[senseRadius + y][senseRadius - x];
				}
				else {
					continue;
				}
				if (sensoryGrid[yCoor - y][xCoor + x] != mapper.GridGenerator.getWallId()) {
					sensoryGrid[yCoor - y][xCoor + x] = senseArray[senseRadius - y][senseRadius + x];
				}
				else {
					continue;
				}
			}
		}
	}
	
	
	//for now, we'll do movement speeds of 1 each by default for movingbodies
}