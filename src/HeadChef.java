import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HeadChef {
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
		
		HashMap<Character, Integer> s = new HashMap<Character, Integer>();
		s.put('B', 0); s.put('G', 0); s.put('N', 0); s.put('P', 0);
		s.put('S', 0); s.put('T', 0); s.put('V', 0);
		
		StringBuffer str = new StringBuffer(br.readLine());
		
		for(int j = 0; j < n/2; j++) {
			Character c = str.charAt(j);
			s.put(c, s.get(c)+1);
		}
		
		for(int j = n/2; j < n; j++) {
			Character c = str.charAt(j);
			s.put(c, s.get(c)+1);
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for(int j = 0; j < t; j++) {
			str = new StringBuffer(br.readLine());
			
			int a = s.get(str.charAt(0));
			int b = s.get(str.charAt(1));
			int c = s.get(str.charAt(2));
			
			Long val = (long) a*b*c;
			
			System.out.println(val);
			
			if(val > 0) {
				s.put(str.charAt(0), s.get(str.charAt(0))-1);
				s.put(str.charAt(1), s.get(str.charAt(1))-1);
				s.put(str.charAt(2), s.get(str.charAt(2))-1);
			}
		}
	}
}
