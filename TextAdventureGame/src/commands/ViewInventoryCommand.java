package commands;

public class ViewInventoryCommand implements Command {

	private Action theCommand;

	public ViewInventoryCommand(Action theCommand) {
		this.theCommand = theCommand;

	}

	@Override
	public String execute() {
		 return theCommand.viewInventory();
	}
	
}
