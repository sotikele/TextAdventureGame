package game;

import java.util.HashMap;


public class ValidDirection {

	private HashMap<String, Direction> validDirection;
	
	public ValidDirection(){
		validDirection = new HashMap<>();
	
		for(Direction direction : Direction.values()) {
			if(direction != Direction.UNKNOWN) {
				validDirection.put(direction.toString(), direction);
			}
		}
	}

	public Direction getDirectionWord(String commandWord) {
		Direction command = validDirection.get(commandWord);
		if (command != null) {
			return command;
		}
		else {
			return Direction.UNKNOWN;
		}
	}
	public boolean isDirection(String aString) {
		return validDirection.containsKey(aString);
	}
}
