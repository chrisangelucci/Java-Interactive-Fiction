package chrisangelucci.interactivefiction;

public class Path {

	private String cmd;
	private int roomId;
	private String requiredItem = "";
	
	public Path(String cmd, int roomId, String requiredItem){
		this.cmd = cmd;
		this.roomId = roomId;
		this.requiredItem = requiredItem;
	}
	
	public String getCommand(){
		return this.cmd;
	}
	
	public int getRoomId(){
		return this.roomId;
	}
	
	public boolean hasRequiredItem(){
		return this.requiredItem != "";
	}
	
	public String getRequiredItem(){
		return this.requiredItem;
	}
	
	public String toString(){
		return "Path[cmd:" + cmd + ",roomId:" + roomId + ",requiredItem:" + requiredItem + "]";
	}
	//this code did not work weel, but was well done
}
