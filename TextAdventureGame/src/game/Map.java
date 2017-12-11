package game;



import items.Item;

public class Map {

	private Room startingRoom;
	private Factory factory;

	protected Map() {
		factory = new ConcreteFactory();
	}

	@SuppressWarnings("unused")
	public void initializeMap() {

			
		
		Room cell1 = factory.makeRoom("Room","You are in your cell", " there's a door to the East",null);
		Room cellhall1 = factory.makeRoom("DynRoom", "You are in the cell hallway","you see cell#1 to the west, cell#2 to the north, cell#3 to the south and another hallway to the east","TROLOLOLOLOOLOLO");
		Room cell2 = factory.makeRoom("Room","You are in cell#2 there's a password on the floor","there's an exit to the south",null);
		Room cell3 = factory.makeRoom("Room", "You are in cell#3 you see a locker in the corner"," there's an a exit to the north",null);
		Room cellhall2 = factory.makeRoom("Room", "You are in the second cell hallway you see a crowbar on the floor","",null);
		Room darkoffice = factory.makeRoom("Room", "You are in a dark office you see a desk,","there's an exit to the north",null);
		Room prisonexit = factory.makeRoom("Room", "You are in the exit to the basement","there's a reinforced door leading upstairs to the east and the cell hallway to the south",null);
        Room hall1 = factory.makeRoom("Room","You are in the F1 north wallway"," there's a kitchen to the east and the main hallway to the south",null);
        Room kitchen = factory.makeRoom("Room","You're in the kitchen you see a knife on the counter"," there's an exit to the west",null); 
        Room hall2 = factory.makeRoom("Room","You are in the main hall"," there's an office to the west, a storrage locker to the south, the main enterance to the east and the north hallway to the north",null);
        Room office1 = factory.makeRoom("Room","you are in a small office you see a folder on the desk","there's an exit to the east",null); 
        Room storrage = factory.makeRoom("Room","you are in the main storrage closet you see a fire extinguisher on the floor","the exit is to the north",null);
        Room enterance = factory.makeRoom("Room","you are in the prisons enterance there's fire","there's a door to the east and the main hallway to the west",null); 
        Room yard = factory.makeRoom("Room","you are in the prisons yard"," the prisons exit is to the east, you see something shining in the bush, there's a toolshed to the south",null); 
        Room shed = factory.makeRoom("Room","There's nothing here but an old ladder","the exit is to the north",null); 
        Room ending = factory.makeRoom("Room","this is where the game ends","",null);        
        // Creates Doors
		Door door1 = factory.makeDoor("Door", cellhall1, cell1, "west", "east", false, 1,"lockedmessage","ulockmessage","wrongkey");
		Door door2 = factory.makeDoor("Door", cellhall1, cell2, "north", "south", true, 2,"The Door to Cell#2 is locked, you need a key to advance","The door to cell#2 is now open","This is the wrong key");
		Door door3 = factory.makeDoor("Door", cellhall1, cell3, "south", "north", false, 3,"lockedmessage","ulockmessage","wrongkey");
		Door door4 = factory.makeDoor("Door", cellhall1, cellhall2, "east", "west", false, 4,"lockedmessage","ulockmessage","wrongkey");
		Door door5 = factory.makeDoor("Door", cellhall2, darkoffice, "south", "north", false, 5,"lockedmessage","ulockmessage","wrongkey");
		Door door6 = factory.makeDoor("Door", cellhall2, prisonexit, "north", "south", true, 6,"This door is locked","you unlock the door to the prisons basemnt loby","This is the wrong key.");
		Door door7 = factory.makeDoor("Door", prisonexit, hall1, "east", "west", true, 7,"This door requires a password to open","Password accepted the door is now open","Wrong password try again");
		Door door8 = factory.makeDoor("Door", hall1, kitchen, "east", "west", false, 8,"lockedmessage","ulockmessage","wrongkey");
		Door door9 = factory.makeDoor("Door", hall1, hall2, "south", "north", false, 9,"lockedmessage","ulockmessage","wrongkey");
		Door door10 = factory.makeDoor("Door", hall2, office1, "west", "east", false, 10,"lockedmessage","ulockmessage","wrongkey");
		Door door11 = factory.makeDoor("Door", hall2, storrage, "south", "north", true, 11,"The storrage door is locked","You unlock the door to the storrage room","This is not the right key");
		Door door12 = factory.makeDoor("Door", hall2, enterance, "east", "west", false, 12,"lockedmessage","ulockmessage","wrongkey");
		Door door13 = factory.makeDoor("Door", enterance, yard, "east", "west", true, 13,"There's fire in the way","The fire has been extinguished","You cant use that to put out the fire");
		Door door14 = factory.makeDoor("Door", yard, shed, "south", "north", true, 14,"The shed door is locked tight","You unlock the sheds wooden door","This is the wrong key");
		Door door15 = factory.makeDoor("Door", yard, ending, "east", "west", true, 15,"The door is jammed,you'll have to get over the fence","You place the ladder, you can now climb over the fence","You cant use that to scale the fence");
		
		
		
		
		
		// ***Create and adding items for the classphysics room(vozikis)***//
		//containers
		Item locker1 = factory.makeItem("ContainerItems", "locker", false);
		Item desk1 = factory.makeItem("ContainerItems", "desk", false);
		Item folder = factory.makeItem("ContainerItems", "folder", false);
		Item bushes = factory.makeItem("ContainerItems", "bushes", false);
		
		//simple		
		Item crowbar = factory.makeItem("SimpleItems", "crowbar", true);
		Item knife = factory.makeItem("SimpleItems", "knife", true);
		
		//keys		
		Item hallkey = factory.makeItemKey("Key","hallkey", true, 6);
        Item cell2key = factory.makeItemKey("key","cell2key", true, 2);
        Item password = factory.makeItemKey("key","password", true, 7);
        Item key3 = factory.makeItemKey("Key","hallkey", true, 4);
        Item storragekey = factory.makeItemKey("Key","storragekey", true, 11);
        Item extinguisher = factory.makeItemKey("Key","extinguisher", true, 13);
        Item shedkey = factory.makeItemKey("Key","shedkey", true, 14);
        Item ladder = factory.makeItemKey("Key","ladder", true, 15);


        
		// adding for the container item cabinet

		locker1.addItem(hallkey);
		desk1.addItem(cell2key);
		folder.addItem(storragekey);
        bushes.addItem(shedkey);

		//////////////////////add items to rooms
		cell3.addToRoom(locker1);
		cellhall2.addToRoom(crowbar);
		darkoffice.addToRoom(desk1);
		cell2.addToRoom(password);
		kitchen.addToRoom(knife);
		office1.addToRoom(folder);
		storrage.addToRoom(extinguisher);
		yard.addToRoom(bushes);
		shed.addToRoom(ladder);

		////////////////////////////////////

		startingRoom = cell1;

	}

	public Room getStartingLocation() {
		return startingRoom;
	}

/*
	public  void readXML() {
		
		SAXBuilder builder = new SAXBuilder();
		
		Document document = null;
		
		try {
			document = builder.build(new File("./src/Map.xml"));
			
		}

		catch (JDOMException | IOException e) {
			e.printStackTrace();
		}

		Element root = document.getRootElement();
		
		for (Element element : root.getChildren("room")) {
			factory.makeRoom("Room", element.getChildText("description"),element.getChildText("details"),null );
		}
}
	
	*/
}
