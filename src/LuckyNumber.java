import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class LuckyNumber {
    private static ArrayList<Integer> numArray = new ArrayList<Integer>();
    
    private static void lucky() {
    	for(int i = 0; i < numArray.size(); i++) {
        	int x = numArray.get(i);
        	
        	if(x < 3) {
        		numArray.set(i, 3);
        	} else if(x > 3 && x < 5) {
        		numArray.set(i, 5);
        	} else if(x > 5) {
        		numArray.set(i, 3);
        		if(i == 0)
        			numArray.add(0, 3);
        	}
        }
        
        for(int i = 0; i < numArray.size(); i++) {
        	System.out.print(numArray.get(i));
        }
    }
    
    private static void luckyR() {
    	for(int i = numArray.size()-1; i >= 0; i--) {
        	int x = numArray.get(i);
        	
        	if(x < 3) {
        		numArray.set(i, 3);
        	} else if(x == 3) {
        		if(numArray.get(i-1) < 3) {
        			
        		}
        	} else if(x > 3 && x < 5) {
        		numArray.set(i, 5);
        	} else if(x > 5) {
        		numArray.set(i, 3);
        		if(i == 0)
        			numArray.add(0, 3);
        	}
        }
        
        for(int i = 0; i < numArray.size(); i++) {
        	System.out.print(numArray.get(i));
        }
    }
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int j = 0; j < t; j++) {
        	int num = Integer.parseInt(br.readLine());
            
            while(num/10 != 0){
            	numArray.add(num/10);
            	num = num %10;
            }
            numArray.add(num%10);
            
            lucky();
            luckyR();
           	numArray.clear();
           	System.out.println();
        }
	}
}