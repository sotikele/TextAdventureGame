package game;

public enum Direction {
	
	NORTH("north"),
	SOUTH("south"),
	WEST("west"),
	EAST("east"),
	UNKNOWN("?");
	
	private String direction;
	
	Direction(String direction){ 
		this.direction = direction;
	}
	
	public String toString() {
		return direction;
	}
}
