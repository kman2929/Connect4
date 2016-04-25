package siva.keeran;

/**
 * 
 * @author Aaisha Eid and Keeran Siva
 * @version 1.0
 */
public class Chip {
	
	private boolean occupied;
	private Player player;
	
	/**
	 * 
	 * @param status
	 * @param player
	 */
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
	public void setEmpty(){
		occupied  = false;
	}
	public void setOccupied(){
		occupied = true;
		
	} public boolean isOccupied(){
		return occupied;
	}
}