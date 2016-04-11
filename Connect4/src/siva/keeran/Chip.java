package siva.keeran;

public class Chip {
	
	private boolean occupied;
	private ChipColour colour;
	
	public Chip(boolean status, ChipColour col){
		this.occupied = status;
		this.colour = col;
	}
	public ChipColour getColour(){
		return colour;
	}
	public void setColour(ChipColour col){
		colour = col;
	}
	public void setOccupied(){
		occupied = true;
		
	} public boolean isOccupied(){
		return occupied;
	}
}