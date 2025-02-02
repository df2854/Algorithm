import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		dp = new Integer[n + 1];
		dp[0] = dp[1] = 0;
		
		bw.write(rec(n) + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int rec(int num) {
		if (dp[num] == null) {
			if ((num % 3 == 0) && (num % 2 == 0)) {
				dp[num] = Math.min(rec(num / 3) + 1, rec(num / 2) + 1);
			} else if (num % 3 == 0) {
				dp[num] = Math.min(rec(num / 3) + 1, rec(num - 1) + 1);
			} else if (num % 2 == 0) {
				dp[num] = Math.min(rec(num / 2) + 1, rec(num - 1) + 1);
			} else {
				dp[num] = rec(num - 1) + 1;
			}
		}
		
		return dp[num];
	}
}