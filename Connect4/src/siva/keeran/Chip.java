package siva.keeran;

/**
 * This class creates a JPanel and creates and adds its components such as 
 * the JButtons and JLabels. It also utilizes instance variables and responds to the 
 * users actions when they click on a button. 
 * 
 * @author Aaisha Eid and Keeran Siva
 * @version 1.0
 */
public class Chip {
	
	private boolean occupied;
	private Player player;
	
	/**
	 * Constructor method
	 *       -creates the JPanel object
	 *       -creates and adds the JButtons and JLabels  
	 * 
	 * @param status
	 *     -the status of the board piece (empty or occupied) of type boolean
	 * @param player
	 *     -the player occupying the board piece of type Player
	 */
	public Chip(boolean status, Player player){
		this.occupied = status;
		this.player = player ;
	}
	
	/**
	 * This method returns the player occupying the board piece.
	 * 
	 * @return player
	 */
	public Player getPlayer(){
		return player;
	}
	
	/**
	 * This method sets the board piece to the occupying player.
	 * 
	 * @param player
	 */
	public void setPlayer(Player player){
		this.player = player;
	}
	
	/**
	 * This method sets the player of the board piece to empty.
	 * 
	 */
	public void setEmpty(){
		occupied  = false;
	}
	
	/**
	 * This method sets the player of the board piece to occupied.
	 * 
	 */
	public void setOccupied(){
		occupied = true;
	}
	
	/**
	 * This method returns the status of the board piece, whether occupied or 
	 * empty.
	 * 
	 * @return occupied
	 */
	public boolean isOccupied(){
		return occupied;
	}
}