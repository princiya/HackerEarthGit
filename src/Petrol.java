import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Petrol {
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
		    
		    int j = 1;
		    boolean flag = true;
		    if (n == 0) flag = false;
		    if(d == 0) flag = true;
		    while(j <= d) {
		    	if(j%2 == 0) {
		    		n = n > 0 ? n-1 : 0;
		    	}
		    	if(j%6 == 0) {
		    		n = n > 0 ? n+2 : 2;
		    	}
		    	j++;
		    	if(n == 0 && j <= d) {
		    		flag = false;
		    		break;
		    	}
		    }
		    if(flag == true) {
		    	System.out.println("Yes");
		    } else
		    	System.out.println("No");
		}
    }
}