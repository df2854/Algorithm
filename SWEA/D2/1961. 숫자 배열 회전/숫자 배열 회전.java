import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			String arr[][] = new String[n][n];
			for (int i = 0; i < n; i++) {
				String input[] = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = input[j];
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(arr[n-1-j][i]);
				}
				sb.append(" ");
				for (int j = 0; j < n; j++) {
					sb.append(arr[n-1-i][n-1-j]);
				}
				sb.append(" ");
				for (int j = 0; j < n; j++) {
					sb.append(arr[j][n-1-i]);
				}
				sb.append("\n");
			}
			bw.write("#" + t + "\n");
			bw.write(sb + "");
		}
		bw.close();
	}
}