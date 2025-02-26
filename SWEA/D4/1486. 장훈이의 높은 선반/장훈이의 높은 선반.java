import java.util.*;
import java.io.*;

class Solution {
	static int n, b, arr[], min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i < (1 << n); i++) {
				int sum = 0;
				List<Integer> list = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) != 0) {
						list.add(arr[j]);
					}
				}
				
				for (int num : list) {
					sum += num;
				}
				
				if (sum >= b) {
					min = Math.min(min, sum - b);
				}
			}
			
			bw.write("#" + t + " " + min + "\n");
		}
		bw.flush();
		bw.close();
	}
}