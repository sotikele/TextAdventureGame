package commands;

public class PickupCommand implements Command {

	private Action action;
	private String secondWord;

	public PickupCommand(Action action, String secondWord) {
		this.action = action;
		this.secondWord = secondWord;
	}

	@Override
	public String execute() {
		
		return	action.pickup(secondWord);

	}
}
