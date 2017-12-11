package commands;

public class LookCommand implements Command {
	private Action theCommand;

	public LookCommand(Action theCommand) {
		this.theCommand = theCommand;
	}

	@Override
	public String execute() {
		return theCommand.look();

	}
}
