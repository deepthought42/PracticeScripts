package aStar;

import java.util.ArrayList;

public class A_Star {
	public static void main(String[] args){
		char[][] grid = new char[10][10];
		
		int startX = 3;
		int startY = 4;
		
		int endX = 10;
		int endY = 10;
		
		aStar(new ArrayList<Integer>(), grid, startX, startY, endX, endY);
	}
	
	public static void aStar(ArrayList<Integer> path, char[][] grid, int startX, int startY, int endX, int endY){
		// x + 1
		if((startX + 1) < grid.length && grid[startX+1][startY] != 'x'){
			
		}
		if((startY + 1) < grid.length && grid[startX][startY+1] != 'x'){
			
		}
		if((startX - 1) > 0 && grid[startX-1][startY] != 'x'){
			
		}
		if((startY - 1) > 0 && grid[startX][startY-1] != 'x'){
			
		}
		// y + 1
		// x - 1
		// y - 1
	}
}
