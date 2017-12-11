package commands;

import java.util.Scanner;

public class Parser {
	private CommandFactory command;
	private Action actioner;
	private Scanner input;

	
	public Parser() {
		command = new CommandFactory();
		input = new Scanner(System.in);

	}
	public Command getCommand() {

		String inputLine;
		String word1 = null;
		String word2 = null;

		inputLine = input.nextLine();

		Scanner token = new Scanner(inputLine);

		if (token.hasNext()) {
			word1 = token.next();
			if (token.hasNext()) {
				word2 = token.next();
			}
			token.close();
		}

		return command.makeCommand(word1, actioner, word2);
	}

	public Scanner getInput() {
		return input;
	}

	public void setActioner(Action actioner) {
		this.actioner = actioner;
	}

}
