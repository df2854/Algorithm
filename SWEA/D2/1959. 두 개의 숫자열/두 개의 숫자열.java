import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] a = new int[20];
			int[] b = new int[20];
			
			if (n < m) {
				a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			} else {
				b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= Math.abs(n - m); i++) {
				int sum = 0;
				for (int j = 0; j < a.length; j++) {
					sum += a[j] * b[j + i];
				}
				if (max < sum) {
					max = sum;
				}
			}
			bw.write("#" + t + " " + max + "\n");
		}
		bw.close();
	}
}