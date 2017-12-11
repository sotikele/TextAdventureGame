package commands;

public class TimeCommand implements Command {
	private Action theCommand;
	
	public TimeCommand(Action theCommand) {
		this.theCommand = theCommand;

	}
	@Override
	public String execute() {
		return theCommand.time();
	
	}
}
