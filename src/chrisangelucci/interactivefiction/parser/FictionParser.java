package chrisangelucci.interactivefiction.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import chrisangelucci.interactivefiction.InteractiveFiction;
import chrisangelucci.interactivefiction.Path;
import chrisangelucci.interactivefiction.Room;
import chrisangelucci.interactivefiction.Utils;
//where is my snadwhich??

public class FictionParser {

	private String filePath;
	
	public FictionParser(String filePath) throws ParseError{
		if(new File(filePath).exists() && filePath.endsWith(".txt")){
			this.filePath = filePath;
		}else{
			throw new ParseError("File does not exist, or is incorrect type!");
		}
	}
	
	public List<Room> parseFile() throws IOException{
		List<Room> rooms = new ArrayList<Room>();
		
		BufferedReader b = new BufferedReader(new FileReader(new File(filePath)));

        String line = "";
        
        List<String> partialRoom = new ArrayList<String>();
        
        boolean inRoom = false;
        
        while ((line = b.readLine()) != null) {
            if(line.equals("[Enable-Inventory]")){
            	InteractiveFiction.inventoryEnabled = true;
            	continue;
            }
            if(!inRoom && line.startsWith("[Room ")){
            	inRoom = true;
            }
            if(inRoom){
            	partialRoom.add(line);
            }
            if(inRoom && line.equals("[End-Room]")){
            	inRoom = false;
            	rooms.add(parseRoom(partialRoom));
            	partialRoom.clear();
            }
        }
        b.close();
        return rooms;
	}
	
	private Room parseRoom(List<String> room){
		int id = 0;
		List<String> lines = new ArrayList<String>();
		List<Path> paths = new ArrayList<Path>();
		for(String line : room){
			if(line.startsWith("[Room ")){
				id = Integer.valueOf(line.substring(6,7));
				continue;
			}
			if(line.startsWith("[End-Room]"))
				continue;
			if(line.startsWith("[Path-to ")){
				String pathInfo = Utils.getBetween(line, '[', ']');
				String item = "";
				if(pathInfo.contains("\"")){
					item = Utils.getBetween(pathInfo, '"', '"');
				}
				int pathid = Integer.valueOf(pathInfo.replaceAll("Path-to", "").replaceAll("\"" + item + "\"", "").trim());
				paths.add(new Path(line.replaceAll("\\[" + pathInfo + "\\]", "").trim(), pathid, item));
				continue;
			}
			lines.add(line);
		}
		Room r = new Room(id, lines, paths);
		return r;
	}
	
}
