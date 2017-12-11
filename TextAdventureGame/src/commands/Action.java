package commands;

public interface Action {
	String use(String secondWord);
	String open(String secondWord);
	String pickup(String secondWord);
	String go(String secondWord);
	String viewInventory();
	String delay();
	String time();
	String quit();
	String look();
}
