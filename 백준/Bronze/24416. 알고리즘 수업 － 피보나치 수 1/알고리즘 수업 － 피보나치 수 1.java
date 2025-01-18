import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		fib(n);
		
		bw.write((cnt+1)/2 + " " + (n-2) + "\n");
		
		bw.flush();
		bw.close();
	}
	
	public static int fib(int n) {
		cnt += 1;
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
}