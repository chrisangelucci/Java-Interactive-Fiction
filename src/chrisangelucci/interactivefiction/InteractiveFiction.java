package chrisangelucci.interactivefiction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import chrisangelucci.interactivefiction.parser.FictionParser;
import chrisangelucci.interactivefiction.parser.ParseError;

public class InteractiveFiction {

	private static List<Room> rooms = new ArrayList<Room>();
	public static boolean inventoryEnabled = false;
	
	private static final String DEBUG_STORY = "C:\\Users\\Chris Jr\\Documents\\Miner\\Workspace\\InteractiveFiction\\story.txt";
	
	public static void main(String[] args) {
		try {
			rooms = new FictionParser(DEBUG_STORY).parseFile();
		} catch (IOException | ParseError e) {
			e.printStackTrace();
		}
		
		for(Room r : rooms){
			System.out.println(r.toString());
		}
	}
	//why did you steal my grill???
}
