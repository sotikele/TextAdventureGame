package game;

import java.io.Serializable;
import java.util.ArrayList;

import commands.Action;
import items.Item;
import items.Key;

public class Player implements Action, Serializable {
	
    private Time timer;
	private static final long serialVersionUID = 1L;
	private String name;
	private static Player instance = null;
	private Room currentRoom;
	private int hitPoints;
	private ArrayList<Item> inventory;
	private String lockedDoorLocation;

	private Player(int hitPoints) {
		this.hitPoints = hitPoints;
		this.inventory = new ArrayList<>();
		timer=Time.getInstance();
		lockedDoorLocation = null;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public String getItemList() {
		String items = "";
		int index = 1;
		for (Item item : inventory) {
			items += index + " " + item.getDescription() + "\n";
			index++;
		}
		return items;

	}

	public Item getItemFromInventory(String itemOutPut) {

		for (Item item : inventory) {
			if (item.getDescription().equalsIgnoreCase(itemOutPut)) {
				return item;
			} else if (item.getItem(itemOutPut) != null) {
				return item.getItem(itemOutPut);
			}

		}

		return null;
	}

	public String printLocation() {
		return currentRoom.getDescription();

	}

	public void setStartingPosition(Room position) {
		currentRoom = position;
	}
	
	@Override
	public String go(String givenString) {

		if (givenString == null) {			
			return "Go where?";
		}
		
		if (currentRoom.leadsToDirection(givenString)) {
			
			Room nextRoom = currentRoom.getExit(givenString);

			if (nextRoom==null) {
				return "There is no exit this way.";
			}
			
			else if (currentRoom.getDoor(givenString).isLocked()) {			
				this.setLockedDoorLocation(givenString);
				timer.timePass(0, 2);
				return "The door is Locked";
			}
		
			else {
				currentRoom = nextRoom;
				timer.timePass(0, 10);
				return currentRoom.getDescription();
			}
		}
		
		else {
			return "There is no direction called "+givenString ;
		}
	}

	@Override
	public String look() {
		timer.timePass(0, 1);	
		return currentRoom.getLongDescription();
	}

	@Override
	public String quit() {
		try {
			ResourceManager.save(this, this.name);
		} catch (Exception e1) {
			// e1.printStackTrace();
		}
		System.exit(0);
		return "cya soon";
	}

	@Override
	public String pickup(String secondWord) {

		if (secondWord == null) {
			return "pickup what?";
		}

		if (currentRoom.canPickItem(secondWord) == true) {
			currentRoom.moveItemTo(inventory, secondWord);
			timer.timePass(0, 1);
			return "You picked up the " + secondWord;
		} else {
			timer.timePass(0, 1);
			return "There is nothing similar to "+ secondWord +" in this room.";
		}

	}

	

	@Override
	public String open(String secondWord) {

		if (secondWord == null) {
			return "open what?";
		}

		if (currentRoom.hasItem(secondWord)) {
			timer.timePass(0, 1);
			return currentRoom.showItemsDescription(secondWord);

		} else {
			timer.timePass(0, 1);
			return "There is nothing here.";
		}

	}

	// TODO douleuei mono gia kleidia
	@Override
	public String use(String secondWord) {

		if (secondWord == null) {
			return "use what?";
		}

		if (this.hasItem(secondWord) && currentRoom.getDoor(this.lockedDoorLocation)
				.getID() == ((Key) this.getItemFromInventory(secondWord)).getID()) {

			currentRoom.getDoor(this.lockedDoorLocation).setLocked(false);
			timer.timePass(0, 1);
			return "FA";
		} else {
			return "FA";
		}

	}

	public static Player getInstance() {
		if (instance == null) {
			instance = new Player(50);
		}
		return instance;

	}

	public boolean hasItem(String searchingItem) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getDescription().equalsIgnoreCase(searchingItem)) {
				return true;
			} else if (inventory.get(i).getItem(searchingItem) != null) {
				return true;
			}
		}
		return false;
	}

	public String getLockedDoorLocation() {
		return lockedDoorLocation;
	}

	public void setLockedDoorLocation(String lockedDoorLocation) {
		this.lockedDoorLocation = lockedDoorLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String viewInventory() {
		return getItemList();

	}

	@Override
	public String delay() {
		return	timer.waitTime();
		
	}

	@Override
	public String time() {
		return	timer.tellDayAndTime();
		
	}

}