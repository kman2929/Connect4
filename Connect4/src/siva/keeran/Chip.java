package siva.keeran;

public class Chip {
	
	private boolean occupied;
	private Player player;
	
	public Chip(boolean status, Player player){
		this.occupied = status;
		this.player = player ;
	}
	public Player getPlayer(){
		return player;
	}
	public void setPlayer(Player player){
		this.player = player;
	}
	public void setOccupied(){
		occupied = true;
		
	} public boolean isOccupied(){
		return occupied;
	}
}