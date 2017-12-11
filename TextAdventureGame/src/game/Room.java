package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import items.Item;

public class Room implements Serializable {
   

	private static final long serialVersionUID = 1L;
	protected  String description;
	protected  String details;
	protected  HashMap<String,Door> doors; 
	protected  ArrayList<Item> roomItems;
	private ValidDirection directions; 
	
	public Room(String description,String details) {	
		
		this.description = description;
		this.details =  details;
		doors = new HashMap<>();
		roomItems = new ArrayList<>();
		directions = new ValidDirection();
	}

	public Room getExit(String direction) {
		if(doors.containsKey(direction))
		{		
	        return doors.get(direction).goToDestination(this);
		}
		
		return null;		
	}

	public void setExit(String direction, Door neighbor) 
    {
        doors.put(direction, neighbor);
    }

	public void addToRoom(Item itemIn) {
		roomItems.add(itemIn);
		
	}
  
	private Item getRoomItem(String wantedItem)
	{
		   for (Item item : roomItems) 
		   {
			   if(item.getDescription().equalsIgnoreCase(wantedItem))	
			   {
				   return item;  
			   }
			   else if(item.getItem(wantedItem)!=null)
			   {  
				   return item.getItem(wantedItem);	     
			   }
			   
		   }
		   return null;
	}
	
	public String showItemsDescription(String itemToShow) {
		return getRoomItem(itemToShow).getLongDescription();
	}

	
	
	public void deleteFromRoom(String itemOut) 
	{
		for(int i=0;i<roomItems.size();i++)
		{
			if(roomItems.get(i).getDescription().equalsIgnoreCase(itemOut))
			{
				roomItems.remove(i);
				break;
			}
			else
			{
				roomItems.get(i).removeItem(itemOut);
			}
		}
	}

	public String getDescription() {
		return description;
	}


	public String getLongDescription() {
		return  description + " "+details;
	}

	public ArrayList<Item> getRoomItems() {
		return roomItems;
	}
	

    public boolean hasItem(String searchingItem)
    {
    	for(int i=0;i<roomItems.size();i++)
    	{
    		if(roomItems.get(i).getDescription().equalsIgnoreCase(searchingItem))
    		{
    			return true;
    		}
    		else if(roomItems.get(i).getItem(searchingItem)!=null)
	        {  
    			return    true;	     
	        }
    	}
    	
    	return false;
    }


    public boolean canPickItem(String item) {
		return (hasItem(item) &&
				getRoomItem(item).isPickable());

    }
    public Door getDoor(String direction){
		return doors.get(direction);
	}

    public void moveItemTo(ArrayList<Item> inventory, String item) {
		inventory.add(getRoomItem(item));
		deleteFromRoom(item);
	}    
    
    public boolean leadsToDirection(String givenString) {
    	
    	if(directions.isDirection(givenString)) {
			return true;
		}
    	else {
    		return false;
    	}
}

	public String getDetails() {
		return details;
		}
}
