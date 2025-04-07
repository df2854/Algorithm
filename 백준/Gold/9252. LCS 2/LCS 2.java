import java.io.*;
import java.util.*;

public class Main {
	static int n1, n2;
	static String input;
	static char[] str1, str2;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		input = br.readLine();
		n1 = input.length();
		str1 = new char[n1];
		for (int i = 0; i < n1; i++) {
			str1[i] = input.charAt(i);
		}
		
		input = br.readLine();
		n2 = input.length();
		str2 = new char[n2];
		for (int i = 0; i < n2; i++) {
			str2[i] = input.charAt(i);
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
		
		int i = n1, j = n2;
		while (i > 0 && j > 0) {
			if (str1[i - 1] == str2[j - 1]) {
				sb.append(str1[i - 1]);
				i--;
				j--;
			} else if (dp[i - 1][j] >= dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		
		System.out.println(dp[n1][n2]);
		System.out.println(sb.reverse().toString());
	}
} 
