package commands;

public class DelayCommand implements Command {
	private Action theCommand;
	
	public DelayCommand(Action theCommand) {
		this.theCommand = theCommand;

	}
	@Override
	public String execute() {
		return theCommand.delay();
	
	}

}
