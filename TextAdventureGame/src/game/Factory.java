package game;

import items.Item;

public interface Factory {
	Item makeItem(String nameClass, String description, boolean pickable);
	Room makeRoom(String nameClass, String description, String details,String DynNightDescription);
	Door makeDoor(String nameClass, Room currentRoom, Room destination, String PositionOfDoorInCurrentRoom,String PositionOfDoorInDestinationRoom, boolean locked, int ID,String lockedmessage,String ulockmessage,String wrongkey);
	Item makeItemKey(String nameClass, String description, boolean pickable, int ID);

}