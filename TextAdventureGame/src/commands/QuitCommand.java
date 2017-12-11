package commands;

public class QuitCommand implements Command {

	private Action theCommand;

	public QuitCommand(Action theCommand) {
		this.theCommand = theCommand;
	}

	@Override
	public String execute() {
		return	theCommand.quit();

	}
}
