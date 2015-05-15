/* IMPORTANT: class must not be public. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

class _2NumberOfRs {
    private static String doReplace(String str, int index) {
    	if(str.charAt(index) == 'K')
    		str = replace(str, index, 'R');
    	else
    		str = replace(str, index, 'K');
    	return str;
    }
    
    private static String replace(String str, int index, char replace){     
	    if(str==null){
	        return str;
	    }else if(index<0 || index>=str.length()){
	        return str;
	    }
	    char[] chars = str.toCharArray();
	    chars[index] = replace;
	    return String.valueOf(chars);       
	}
	
	private static int noOfSubstrings(String str, String findStr) {
		int count = 0, lastIndex = 0;
		while(lastIndex != -1){
	       lastIndex = str.indexOf(findStr,lastIndex);
	       if( lastIndex != -1){
             count ++;
             lastIndex+=findStr.length();
	      }
		}
		return count;
	}
	
	private static LinkedHashMap<Integer, Integer> getLongestSubstring(String str, char c) {
		LinkedHashMap<Integer, Integer> obj = new LinkedHashMap<Integer, Integer>();
		int tempLength = 0, pos = -1;
		int i = 0; // index value
		
		i = str.indexOf(c);
		while(i != -1 && i < str.length()) {
			pos = i;
			++tempLength;
			while(++i < str.length() && str.charAt(i) == c) {
				++tempLength;
			}
			i = str.indexOf(c, i);
			
			if(tempLength > 1) {
				obj.put(pos, tempLength);
				System.out.println(pos+" "+obj.get(pos));
			}
			tempLength = 0;
		}
		return obj;
	}
	
	private static ArrayList<ArrayList<Integer>> getLongestSubstring1(String str, char c) {
		ArrayList<ArrayList<Integer>> obj = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> position = new ArrayList<Integer>();
		ArrayList<Integer> length = new ArrayList<Integer>();
		ArrayList<Integer> element = new ArrayList<Integer>();
		int tempLength = 0, pos = -1;
		int i = 0; // index value
		
		i = str.indexOf(c);
		while(i != -1 && i < str.length()) {
			pos = i;
			++tempLength;
			while(++i < str.length() && str.charAt(i) == c) {
				++tempLength;
			}
			i = str.indexOf(c, i);
			
			if(tempLength > 1) {
				position.add(pos);
				length.add(tempLength);
				element.add(pos);
				element.add(tempLength);
				obj.add(element);
			}
			tempLength = 0;
		}
		for(int x = 0; x < obj.size(); x++) {
			if(x != obj.size() - 1) {
				ArrayList innerArray = obj.get(x);
				Integer endOfFirst = (Integer) innerArray.get(1);
				innerArray = obj.get(x+1);
				Integer startOfSecond = (Integer) innerArray.get(0);
			}
		}
		return obj;
	}
	
	private static void getLongestCharSequenceToReplace(String str) {
		LinkedHashMap<Integer, Integer> obj = getLongestSubstring(str, 'K');
		Iterator it = (Iterator) obj.entrySet().iterator();
		while(((java.util.Iterator<Entry<Integer, Integer>>) it).hasNext()) {
			
		}
	}
	
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int index = 0;
		
        for (int j = 0; j < t; ++j) {
            String str = new String(br.readLine()); 
            int length = str.length();
            if(length == 1) {
            	str = doReplace(str, 0);
            } else {
            	int countKK = noOfSubstrings(str, "KK");
            	int countRR = noOfSubstrings(str, "RR");
            	
            	if(countKK > countRR) {
            		index = str.indexOf("KK");
            		if(countKK == 1) {
            			for(int i = index; i < index + 2; i++) {
		            		str = doReplace(str, i);
		            	}
            		} else {
            			int toIndex = 0;
            			LinkedHashMap<Integer, Integer> obj = getLongestSubstring(str, 'R');
                		int maxValueInMap= !obj.isEmpty() ? (Collections.max(obj.values())) : 0;  // This will return max value in the Hashmap
                        for (Entry<Integer, Integer> entry : obj.entrySet()) {  // Itrate through hashmap
                            if (entry.getValue() == maxValueInMap) {
                                toIndex = entry.getKey();     // Get the key with max value
                            }
                        }
                        if(!obj.isEmpty()) {
    	            		for(int i = index; i < toIndex; i++) {
    	            			str = doReplace(str, i);
    	            		}
                        } else {
                        	for(int i = index; i < length; i++) {
    		            		str = doReplace(str, i);
    		            	}
                        }
            		}	
            	} else {
            		LinkedHashMap<Integer, Integer> obj = getLongestSubstring(str, 'K');
            		int maxValueInMap= !obj.isEmpty() ? (Collections.max(obj.values())) : 0;  // This will return max value in the LinkedHashMap
                    for (Entry<Integer, Integer> entry : obj.entrySet()) {  // Itrate through hashmap
                        if (entry.getValue() == maxValueInMap) {
                            index = entry.getKey();     // Get the key with max value
                        }
                    }
                    if(!obj.isEmpty()) {
	            		for(int i = index; i < index + maxValueInMap; i++) {
	            			str = doReplace(str, i);
	            		}
                    } else {
                    	str = doReplace(str, 0);
                    }
            	}
            }
            
            int count = 0;
            for(int i = 0; i < length; i++) {
            	if(str.charAt(i) == 'R')
            		count++;
            }
            System.out.println(count+" "+str);
        }
    }
}
