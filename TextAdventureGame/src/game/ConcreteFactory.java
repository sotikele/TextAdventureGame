package game;

import items.ContainerItems;
import items.Item;
import items.Key;
import items.SimpleItems;

public class ConcreteFactory implements Factory {

	@Override
	public Item makeItem(String nameClass, String description, boolean pickable) {
		try {
			if (nameClass.equalsIgnoreCase("ContainerItems")) {
				return new ContainerItems(description, pickable);
			} else if (nameClass.equalsIgnoreCase("SimpleItems")) {
				return new SimpleItems(description, pickable);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Room makeRoom(String nameClass, String description,String details,String DynNightDescription) {
		try {
			if (nameClass == "Room") {
				return new Room(description,details);				
			}
			else if (nameClass == "DynRoom") {
				return new DynRoom(description,details,DynNightDescription);				
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Door makeDoor(String nameClass, Room currentRoom, Room destination, String PositionOfDoorInCurrentRoom,
			String PositionOfDoorInDestinationRoom, boolean locked, int ID,String lockedmessage,String unlockmessage,String wrongkey) {
		try {
			if (nameClass == "Door") {
				return new Door(currentRoom, destination, PositionOfDoorInCurrentRoom, PositionOfDoorInDestinationRoom,
						locked, ID,lockedmessage,unlockmessage,wrongkey);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public Item makeItemKey(String nameClass, String description, boolean pickable, int ID) {
		try {
			if (nameClass.equalsIgnoreCase("Key")) {
				return new Key(description, pickable, ID);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}