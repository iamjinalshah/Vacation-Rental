package digimation.vacationrental.util;

import java.util.regex.Pattern;
import java.util.regex.*;

public class ValidationUtils {
	
	public static boolean isEmpty(String param){
		boolean isEmpty = false;
		
		if(param=="" || param.trim().length()<=0 ){
			isEmpty=true;
			
		}
		return isEmpty;
	}
	
	public static boolean isLength(String mobile){
		boolean isEmpty = false;
		
		if(mobile.length()>10 || mobile.length()<10){
			isEmpty=true;
			
		}
		return isEmpty;
	}
	
	public static boolean isChar(String Char){
		boolean isEmpty = false;
		
		if(Pattern.matches("^[0-9]+$", Char)){
			isEmpty=true;
			
		}
		return isEmpty;
	}
	
	public static boolean isNum(String num){
		boolean isEmpty = false;
		
		if(Pattern.matches("^[a-zA-Z]+$", num)){
			isEmpty=true;
			
		}
		return isEmpty;
	}
	
	
}
