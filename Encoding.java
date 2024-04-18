package application;

import java.util.List;
import java.util.Map;

public class Encoding {

	public static String Compressdata(String r,Map<Character, String> res){

		 String compressedOutput ="";
		 for (int i = 0; i < r.length(); i++) {
	            char currentChar = r.charAt(i);

	            // Check if the character exists in the map
	            if (res.containsKey(currentChar)) {
	                String value = res.get(currentChar);
	                compressedOutput=compressedOutput+value;
        	}
	            else {
	            	System.out.println("  not found ");
	            }
		 }

	        return compressedOutput;
	}

}
//StringBuilder compressedOutput = new StringBuilder();
//for (char c : r.toCharArray()) {
//    compressedOutput.append(res.get(c));
//}
//return compressedOutput.toString();