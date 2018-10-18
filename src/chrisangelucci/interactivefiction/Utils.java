package chrisangelucci.interactivefiction;

public class Utils {
//we wrote this inc class, it was ok
	public static String getBetween(String str, char start, char end){
		return str.substring(str.indexOf(start)+1, str.indexOf(end, str.indexOf(start)+1));
	}
	
}
