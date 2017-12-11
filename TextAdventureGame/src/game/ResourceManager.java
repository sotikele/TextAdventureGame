package game;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceManager {

	private ResourceManager(){
		
	}
	
	
	public static  final void save(Serializable data,String fileName)throws Exception{
		try(ObjectOutputStream oos=new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName+".txt")))){
			oos.writeObject(data);
			
		}
		
	}
	
	public static final Object load(String fileName)throws Exception{
		try (ObjectInputStream ois=new ObjectInputStream(Files.newInputStream(Paths.get(fileName+".txt")))) {
			return  ois.readObject();
		}
		
	}
}
