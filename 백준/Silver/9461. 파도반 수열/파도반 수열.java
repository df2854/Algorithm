import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for (int t = 0; t < test; t++) {
			int num = Integer.parseInt(br.readLine());
			long[] dp = new long[101];
			
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			
			for (int i = 6; i < num + 1; i++) {
				dp[i] = dp[i-1] + dp[i-5];
			}
			
			bw.write(dp[num] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}