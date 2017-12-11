package game;

import java.io.Serializable;

public class Door implements Serializable {

	private static final long serialVersionUID = 1L;
	private Room currentLocation;
	private Room nextLocation;
	private boolean locked;
	private final int ID;
	private String lockedmessage;
	private String unlockmessage;
	private String wrongkey;
	

	public Door(Room currentRoom, Room destination, String PositionOfDoorInCurrentRoom,
			String PositionOfDoorInDestinationRoom, boolean locked, int ID,String lockedmessage,String unlockmessage,String wrongkey) {
        this.lockedmessage = lockedmessage;
        this.unlockmessage= unlockmessage;
        this.wrongkey= wrongkey;
		this.currentLocation = currentRoom;
		this.nextLocation = destination;
		this.locked = locked;
		this.ID = ID;
		currentLocation.setExit(PositionOfDoorInCurrentRoom, this);
		nextLocation.setExit(PositionOfDoorInDestinationRoom, this);
	}

	public Room goToDestination(Room currentRoom) {

		if (currentLocation.equals(currentRoom)) {
			return nextLocation;

		} else if (nextLocation.equals(currentRoom)) {
			return currentLocation;
		}
		
		return null;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getID() {
		return ID;
	}
	public String getLockedmessage() {
		return lockedmessage;
	}

	public void setLockedmessage(String lockedmessage) {
		this.lockedmessage = lockedmessage;
	}

	public String getUnlockmessage() {
		return unlockmessage;
	}

	public void setUnlockmessage(String unlockmessage) {
		this.unlockmessage = unlockmessage;
	}

	public String getWrongkey() {
		return wrongkey;
	}

	public void setWrongkey(String wrongkey) {
		this.wrongkey = wrongkey;
	}
}

