package game;

public class DynRoom extends Room implements Updater {

	private static final long serialVersionUID = 1L;
	private Observer timer;
	private String nightDescription;
    private String tempDetails;
	public DynRoom(String description, String details,String nightDescription) {
		
		super(description, details);
		this.nightDescription=nightDescription;
		timer=(Observer) Time.getInstance();
		timer.attach(this);
		tempDetails=details;
		
	}

	@Override
	public void update() {
		if(timer.isNight()){
			details=nightDescription;
		}
		else {
			details=tempDetails;
		}
	}
}
