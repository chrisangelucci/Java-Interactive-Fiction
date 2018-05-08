package chrisangelucci.interactivefiction;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private int id;
	
	private List<String> lines = new ArrayList<String>();
	
	private List<Path> paths = new ArrayList<Path>();
	
	public Room(int id, List<String> lines, List<Path> paths){
		this.id = id;
		this.lines = lines;
		this.paths = paths;
	}
	
	public String toString(){
		String str = "Room[id:" + id + ",lines:" + lines + ",paths:";
		for(Path p : paths){
			str = str + p.toString() + ",";
		}
		str = str + "]";
		return str;
	}
	
}
