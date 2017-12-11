package commands;

public class UseCommand implements Command {

	private Action theCommand;
	private String secondWord;

	public UseCommand(Action theCommand, String secondWord) {
		this.theCommand = theCommand;
		this.secondWord = secondWord;
	}

	@Override
	public String execute() {
		return	theCommand.use(secondWord);

	}
}
