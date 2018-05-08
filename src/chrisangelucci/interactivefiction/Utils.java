package chrisangelucci.interactivefiction;

public class Utils {

	public static String getBetween(String str, char start, char end){
		return str.substring(str.indexOf(start)+1, str.indexOf(end, str.indexOf(start)+1));
	}
	
}
