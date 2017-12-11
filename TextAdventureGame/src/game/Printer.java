package game;

import java.io.Serializable;

public class Printer implements Serializable  {
	
private static final long serialVersionUID = 1L;

public Printer(){
	
}

public final void print(String text){
	System.out.println(text);	
}	
	
public  final void Menu(){
	
System.out.println("Welcome to Text Adventure Game\nChoose");
System.out.println("1:New  Game\n2:Load Game\n3:Exit Game");
	
	
	
	
}
}
