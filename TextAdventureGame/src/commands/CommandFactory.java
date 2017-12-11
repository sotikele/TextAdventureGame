package commands;

public class CommandFactory {
	
	public Command  makeCommand(String nameClass,Action actioner,String secondWord){	
		try
		{
			if(nameClass.equalsIgnoreCase("go"))
			{
				return new GoCommand(actioner,secondWord);
			}
			else if(nameClass.equalsIgnoreCase("use"))
			{
				return new UseCommand(actioner,secondWord);
			}
			else if(nameClass.equalsIgnoreCase("open"))
			{
				return new OpenCommand(actioner,secondWord);
			}
			else if(nameClass.equalsIgnoreCase("quit"))
			{
				return new QuitCommand(actioner);
			}
			else if(nameClass.equalsIgnoreCase("look"))
			{
				return new LookCommand(actioner);
			}
			else if(nameClass.equalsIgnoreCase("pickup"))
			{
				return new PickupCommand(actioner,secondWord);
			}
			else if(nameClass.equalsIgnoreCase("view"))
			{
				return new ViewInventoryCommand(actioner);
			}
			else if(nameClass.equalsIgnoreCase("wait"))
			{
				return new DelayCommand(actioner);
			}
			else if(nameClass.equalsIgnoreCase("time"))
			{
				return new TimeCommand(actioner);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  return null;	
	}
}
