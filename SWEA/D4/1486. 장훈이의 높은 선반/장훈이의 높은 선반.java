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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			
			int minValue = Integer.MAX_VALUE;
			
			for (int i = 0; i < (1 << n); i++) {
				List<Integer> subset = new ArrayList<>();
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) != 0) {
						subset.add(arr[j]);
					}
				}
				
				for (int k : subset) {
					sum += k;
				}
				
				if (sum >= b && sum - b < minValue) {
					minValue = sum - b;
				}
			}
			bw.write("#" + t + " " + minValue + "\n");
		}
		bw.close();
	}
}