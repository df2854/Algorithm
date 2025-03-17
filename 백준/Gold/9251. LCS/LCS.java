import java.io.*;
import java.util.*;

public class Main {
	static char[] str1, str2;
	static int[][] dp;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input1 = br.readLine();
		String input2 = br.readLine();
		int n1 = input1.length();
		int n2 = input2.length();
		
		str1 = new char[n1];
		str2 = new char[n2];
		
		for (int i = 0; i < n1; i++) {
			str1[i] = input1.charAt(i);
		}
		for (int i = 0; i < n2; i++) {
			str2[i] = input2.charAt(i);
		}
		
		dp = new int[n1+1][n2+1];
		
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[n1][n2]);
	}
}