package game;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Time implements  Serializable,Observer {

	private ArrayList<Updater> observers;
	private static final long serialVersionUID = 1L;
	protected int hour,minutes,day ;
	private static Time instance=null;
	
	private Time()
	{
		observers=new ArrayList<Updater>();
		hour=12;
		minutes=0;
		day=1;
	}
	
	public void timePass(int ammountH,int ammountM)
	{		
		int ammount;
		ammount = ammountM + ammountH*60;	
			
		while(minutes+ammount>=60){
			ammount=ammount-60;
			if (hour<23){
			hour++;}
			else{hour=0; day++;}
		}
		minutes= minutes+ammount;
		Notify();
	}
		
	public String tellDayAndTime(){
		if(minutes<10){
			return "It's day "+day+" and the time is "+hour+":0"+minutes;
		}
		else{
			return "It's day "+day+" and the time is "+hour+":"+minutes;
			}		
	}

	
	public boolean isFinalDay()
	{
	   if(day>=4)
		   return true;
	   else return false;		   
		
	}
	
	
	public String waitTime(){
		int hour,minute;
	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
		System.out.println("How long will you wait?");
		System.out.println("Hours:"); 
		hour = sc.nextInt();		
		System.out.println("Minutes:");
		minute = sc.nextInt();	
		
		timePass(hour,minute);		
		
		return tellDayAndTime();
	}
	
	public static Time getInstance(){
		if(instance==null){
			instance=new Time();
		}
		return instance;
	}
	
	public void attach(Updater o){
		observers.add(o);
	}
	
	public void detach(Updater o){
		observers.remove(o);
	}
	
	public void Notify(){
		for(int i=0;i<observers.size();i++){
			((Updater) observers.get(i)).update();
		}
	}

	@Override
	public boolean isNight() {
			if(hour>=6 & hour<21)
				return false;
			else 
				return true;
	}
	
}
