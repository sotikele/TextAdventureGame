package commands;

public class GoCommand implements Command {

	private Action theCommand;
    private String direction;
    
	public GoCommand(Action theCommand,String direction) {
		this.theCommand = theCommand;
		this.direction=direction;
	}
	@Override
	public String execute() {
		
		return theCommand.go(direction);	
	}
}
