package chrisangelucci.interactivefiction.parser;

public class ParseError extends Exception {

	private String msg;
	
	public ParseError(String msg){
		this.msg = msg;
	}
	
	public String getMessage(){
		return this.msg;
	}
	
}
