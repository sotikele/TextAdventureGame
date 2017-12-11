package items;

import java.io.Serializable;

public abstract  class Item implements Serializable{ 

	
	protected static final long serialVersionUID = 1L;
	protected  boolean pickable;	
	protected  String description;
	     
	
	public Item(String description,boolean heavy) {
			
		this.description = description;
		this.pickable=heavy;
	}
 

	public boolean isPickable() {
		return pickable;
	}

	public String getDescription() {
		return description;
	}
	
	public abstract Item  getItem(String itemOutPut);
	public abstract void addItem(Item itemIn);
	public abstract void removeItem(String itemOut);
    public abstract boolean isContainer();
	public abstract String getLongDescription();
	 
}