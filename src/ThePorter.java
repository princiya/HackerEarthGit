/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ThePorter {
    private static void skip_sum(int b[], int l, int r, int k) {
    	int sum = 0;
              while (l <= r && l <= b.length) {
                    sum = sum + b[l];
                    l = l + k; 
              }
              System.out.println(sum);
    }
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a[] = new int[2];
        int i = 0;
        while(st.hasMoreTokens()){
			a[i++] = Integer.parseInt(st.nextToken());
		}
		int b[] = new int[a[0]+1];
		st = new StringTokenizer(br.readLine());
		for(i = 1; i <= a[0]; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		for(i = 0; i < a[1]; i++) {
			st = new StringTokenizer(br.readLine());
			int c[] = new int[3];
			for(int j = 0; j < 3; j++) {
				c[j] = Integer.parseInt(st.nextToken());
			}
			skip_sum(b, c[0], c[1], c[2]);
		}
    }
}
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map.Entry;

class ThePorter {
	static HashMap<Character, Character> obj = new HashMap<Character, Character>();
	
	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char c[] = new char[n];
		int d[] = new int[n];
		
		int i;
		
		st = new StringTokenizer(br.readLine());
	    for(i = 1; i <= n; i++) {
	    	c[i] = st.nextToken().charAt(0);
	    	d[i] = 0;
	    }
	    	
	    for(i = 0; i < m; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int u = Integer.parseInt(st.nextToken());
	    	int v = Integer.parseInt(st.nextToken());
	    	
	    	if(c[u] == 'B') {
	    		if(d[u] == 0) {
	    			obj.put(c[u], 'B');
	    			d[u] = 1;
	    		}
	    		if(d[v] == 0) {
	    			obj.put(c[v], 'P');
	    			d[v] = 1;
	    		}
	    	}
	    	else {
	    		if(d[u] == 0) {
	    			obj.put(c[u], 'P');
	    			d[u] = 1;
	    		}
	    		if(d[v] == 0) {
	    			obj.put(c[v], 'B');
	    			d[v] = 1;
	    		}
	    	}
	    }
	    
	    int cnt = 0;
	    for (Entry<Character, Character> entry : obj.entrySet()) {  
	        if ((entry.getKey() == 'B' && entry.getValue() == 'P') || (entry.getKey() == 'G' && entry.getValue() == 'B')) {
	            cnt++;
	        }
	    }
	    System.out.println(cnt);
	}
}
