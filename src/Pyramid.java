import java.io.BufferedReader;
import java.io.InputStreamReader;

class Pyramid {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long t = (long) Long.parseLong(br.readLine());
		Long i, j = (long) 1, k, x = (long) 0;
		boolean flag = false;
		for(i = (long) 1; i <=t ; i++) {
			x = (long) 0;
			Long num = (long) Long.parseLong(br.readLine());
			for(k = (long) 1; k <= num; k++) {
				flag= false;
				for(j = (long) 1; j <= k; j++) {
					x++;
					if(x == num) {
						flag = true;
						break;
					}
				}
				if(flag == true) break;
			}
			System.out.println(j);
		}
     }
}
