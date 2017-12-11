package game;

import java.util.Scanner;
import commands.Command;
import commands.Parser;

public class Game {

    private Printer printer;
	private Parser parser;
	private Map map;
	private Player player;
	
	public Game() {
		
		printer=new Printer();
		parser = new Parser();
		player = Player.getInstance();
		map = new Map();
		map.initializeMap();
		player.setStartingPosition(map.getStartingLocation());

	}

	public void play() throws Exception {

		Menu();
		parser.setActioner(player);
		printer.print(player.printLocation());

		while (true) {
			Command command = parser.getCommand();
			if (command != null) {
				printer.print(command.execute());
			} else {
				printer.print("I can't understand what you say.");

			}
		}
	}

	public void Menu() {
		printer.Menu();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();

		switch (i) {
		case 1:
			printer.print("Plase Enter a Username");
			Scanner input1 = new Scanner(System.in);
			String userName = input1.nextLine();
			player.setName(userName);
			
			break;
		case 2:
			printer.print("Plase Enter your  Username");
			Scanner input2 = new Scanner(System.in);
			String userName1 = input2.nextLine();
			try {
				player = (Player) ResourceManager.load(userName1);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			System.exit(0);
		}
	}
}