package mapper;

import java.util.ArrayList;
import java.util.Collections;

public class GridGenerator {
	
	private int xRange, yRange;
	public int[][] grid;
	private static int wallId = 9; //sets the Id of the wall tiles
	private static int floorId = 0; //sets Id for flow tiles
	
	//constructor
	public GridGenerator(int xInput, int yInput) {
		xRange = xInput;
		yRange = yInput;
		grid = new int[yRange][xRange];
	}

	//the first number indicates the number of rows, the second number indicates the number of columns
	//positions dictated with the origin at the upper-left corner and positive axes to bottom and left
	
	int getXRange() {
		return xRange;
	}
	
	int getYRange() {
		return yRange;
	}
	
	public static int getWallId() {
		return wallId;
	}
	
	public static int getFloorId() {
		return floorId;
	}
	
	void setPosition(int x, int y, int value) {
		grid[y][x] = value;
	}
	
	int getPosition(int x, int y) {
		int position = grid[y][x];
		return position;
	}
	
	void printGrid() {
		for (int y = 0; y < yRange; y++) {
			for (int x = 0; x < xRange; x++) {
				System.out.print(grid[y][x] + " ");
			}
			System.out.print("\n");
		}
	}

	void setGrid() {
		for (int y = 1; y < yRange - 1; y++) {
			for (int x = 1; x < xRange - 1; x++) {
				grid[y][x] = floorId;
			}
		}
	}
	
	int[][] getGrid() {
		return grid;
	}
	
	void setBounds() {
		int y = 0;
		int x = 0;
		while (y < yRange) {
			grid[y][0] = wallId;
			grid[y][xRange - 1] = wallId;
			y++;
		}
		while (x < xRange) {
			grid[0][x] = wallId;
			grid[yRange - 1][x] = wallId;
			x++;
		}
	}
	
	//THIS IS UNFINISHED, DO NOT USE (HERE)
	int[] setObstacles(ArrayList<Integer> arrListInput) {
		//this method becomes prohibitively expensive the larger the set is
		//figure out a way to optimize this alg. for large N
		ArrayList<Integer> rawRandList = new ArrayList<Integer>((xRange - 1) * (yRange - 1));
		for(int i = 0; i < 25; i++) {
		  rawRandList.add(i);
		}
		Collections.shuffle(rawRandList); //creates a shuffled list of numbers from 0 to 24
		int[] selectedObstacles = new int[9]; //collects first 9 digits from the shuffled rawRandList
		int j = 0;
		while (j < 9) {
			selectedObstacles[j] = arrListInput.get(j);
			j++;
		}
		return selectedObstacles;
	}

}
