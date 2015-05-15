import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class HeadChefThread1 extends Thread {
	private Thread t;
	private String threadName;
	   
	HeadChefThread1(String name){
       threadName = name;
    }
	
	public void run() {
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
     
	}
   
	public void start ()
	{
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
	}
	
	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
		
		HashMap<Character, Integer> s = new HashMap<Character, Integer>();
		s.put('B', 0); s.put('G', 0); s.put('N', 0); s.put('P', 0);
		s.put('S', 0); s.put('T', 0); s.put('V', 0);
		
		StringBuffer str = new StringBuffer(br.readLine());
		
		HeadChefThread1 T1 = new HeadChefThread1( "Thread-1");
	    T1.start();
	      
	    HeadChefThread1 T2 = new HeadChefThread1( "Thread-2");
	    T2.start();
	}
}
