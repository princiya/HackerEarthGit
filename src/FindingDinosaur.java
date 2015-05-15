import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;


public class FindingDinosaur {
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> s = new HashMap<String, Integer>();
		
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            
            String str = st.nextToken();
            int sum = 0;
            for(int x = 0; x < k; x++)
            	sum += Integer.parseInt(st.nextToken());
            
            s.put(str, sum);
		    
        }
        
        for(int j = 0; j < q; j++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int sum = 0;
            for(int x = 0; x < k; x++)
            	sum += Integer.parseInt(st.nextToken());
            
            if(s.containsValue(sum)) {
            	for (Entry<String, Integer> entry : s.entrySet()) {  
        	        if ((entry.getValue() == sum)) {
        	        	System.out.println(entry.getKey());
        	        	break;
        	        }
        	    }
            } else {
            	System.out.println("You cant fool me :P");
            }
        }
    }
}
