import java.io.*;
import java.util.*;

public class Main {
	static int n, c, result;
	static int[] arr, dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 0, right = arr[n-1] - arr[0];
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int before = arr[0];
			
			for (int i = 1; i < n; i++) {
				if (mid <= arr[i] - before) {
					cnt++;
					before = arr[i];
				}
			}
			
			if (cnt >= c) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}