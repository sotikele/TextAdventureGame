package commands;

public class OpenCommand implements Command {

	private Action theCommand;
	private String secondWord;

	public OpenCommand(Action theCommand, String secondWord) {
		this.theCommand = theCommand;
		this.secondWord = secondWord;
	}

	@Override
	public String execute() {
		return theCommand.open(secondWord);

	}
}
