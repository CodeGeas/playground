package com.jitesh.dp;

import java.util.ArrayList;
import java.util.List;

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
this.x=x;
this.y=y;
}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

public class NQueenProblem {

	
	
	public static void main(String[] args) {
		boolean board[][]=new boolean[4][4];
		int N;
		List<Point> queens=new ArrayList<Point>();
		placeQueens(board,queens,0,0);
		System.out.println(queens);
		
		
		
	}

	private static boolean placeQueens(boolean[][] board, List<Point> queens,int x,int y) {
		boolean isPlaced=false;
		
		for(int i=y;i<board.length;i++){
			
			if(!checkClash(queens,x,i))
			{
			
			board[x][i]=true;
			Point p=new Point(x,i);
			queens.add(p);
			isPlaced=placeQueens(board,queens,x+1,0);
			if(!isPlaced){
				queens.remove(p);
				board[x][i]=false;
			}
			}
			else if(queens.size()==4)
			{
				return true;
			}
		}
		if(!isPlaced){
			return false;
		}
		return true;
	}

	private static boolean checkClash(List<Point> queens, int x, int y) {

		return queens.stream().anyMatch(q1-> (q1.x==x)|| (q1.y==y) || (Math.abs((y-q1.y)/(x-q1.x))==1));
	
	}

}
