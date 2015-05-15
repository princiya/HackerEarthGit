
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

class Mystery {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		HashMap<Character, Character> s = new HashMap<Character, Character>();
		s.put('a', 'q'); s.put('g', 'u'); s.put('o', 'g'); s.put('v', 'c');
        s.put('b', 'w'); s.put('h', 'i'); s.put('p', 'h'); s.put('w', 'v');
        s.put('c', 'e'); s.put('i', 'o'); s.put('q', 'j'); s.put('x', 'b');
        s.put('d', 'r'); s.put('j', 'p'); s.put('r', 'k'); s.put('y', 'n');
        s.put('e', 't'); s.put('k', 'a'); s.put('s', 'l'); s.put('z', 'm');
        s.put('f', 'y'); s.put('l', 's'); s.put('t', 'z');
        s.put('m', 'd'); s.put('n', 'f'); s.put('u', 'x');
		
        for (int j = 0; j < t; j++) {
            StringBuilder a = new StringBuilder(br.readLine());
			
            for(int i = 0; i < a.length(); i++) {
            	if(a.charAt(i) != ' ') {
            		a.setCharAt(i, s.get(a.charAt(i)));
				}
            }
            System.out.println(a.toString());
        }
    }
}
