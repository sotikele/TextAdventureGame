package game;

public interface Observer {

	public void attach(Updater o);
	public void detach(Updater o);
	public boolean isNight();
	
}
