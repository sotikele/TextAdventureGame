package items;

public class Key extends Item {


	private static final long serialVersionUID = 1L;
    private int ID;	
    
	public Key(String description, boolean heavy,int ID) {
		super(description, heavy);
		this.ID=ID;
	}

	@Override
	public String toString() {
		
		return this.getDescription();
	}

	
	
	
	
	
	@Override
	public Item getItem(String itemOutPut) {
		// It has to be degenerate
		return null;
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
	public boolean isContainer() {
		
		return false;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String getLongDescription() {
		
		return description;
	}

	
	
	
}
