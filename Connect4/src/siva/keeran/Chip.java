package siva.keeran;

public class Chip {
	
	private static boolean occupied;
	private static int colour;
	
	public Chip(boolean status, int colour){
		this.occupied = status;
		this.colour = colour;
	}
	
	public void setOccupied(){
		occupied = true;
		
	} public boolean isOccupied(){
		return occupied;
	}
}