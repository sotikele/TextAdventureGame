package items;

public class SimpleItems extends Item {

	

	
	private static final long serialVersionUID = 1L;



	public SimpleItems(String description,boolean pickable) {
		super(description,pickable);
		
	}

	
	
	@Override
	public void addItem(Item itemIn) {
		// It has to be degenerate
		
	}

	@Override
	public void removeItem(String itemOut) {
		// It has to be degenerate
		
	}

	@Override
	public Item getItem(String itemOutPut) {
		//It has to be degenerate
		return null;
		
		
	}

	@Override
	public boolean isContainer() {
		
		return false;
	}



	@Override
	public String getLongDescription() {
		
		return description+ " is Empty";
	}

	

}	