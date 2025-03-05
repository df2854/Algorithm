import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[n-1];

		while (left <= right) {
			long mid = (left + right) / 2;
			long num = 0;
			for (int a : arr) {
				if (a < mid) {
					continue;
				} 
				num += a - mid;
			}
			
			if (num >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		bw.write(right + "\n");
		bw.flush();
		bw.close();
	}
}
