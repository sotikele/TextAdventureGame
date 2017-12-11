package items;

import java.util.ArrayList;

public class ContainerItems extends Item {

	private static final long serialVersionUID = 1L;
	private ArrayList<Item> itemList = new ArrayList<>();

	public ContainerItems(String description, boolean pickable) {
		super(description, pickable);

	}

	@Override
	public void addItem(Item itemIn) {
		itemList.add(itemIn);
	}

	@Override
	public void removeItem(String itemOut) {

		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getDescription().equalsIgnoreCase(itemOut)) 
			{
				itemList.remove(i);
				break;
			} else 
			{
				itemList.get(i).removeItem(itemOut);
			}

		}
	}

	@Override
	public Item getItem(String itemOutPut) {

		for (Item item : itemList) {
			if (item.getDescription().equalsIgnoreCase(itemOutPut))
			{
				return item;
			} else if (item.getItem(itemOutPut) != null) 
			{
				return item.getItem(itemOutPut);
			}

		}

		return null;
	}

	@Override
	public boolean isContainer() {

		return true;
	}

	@Override
	public String getLongDescription() {
		String result = description + " Contains:";
		for (Item item : itemList) {

			result = result + " ," + item.getDescription() + " ";
		}
		return result;
	}

}
