import java.io.*;
import java.util.*;

public class Main {
	static int n, m, arr[], target[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());
		target = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < m; i++) {
			System.out.println(binarySearch(target[i]));
		}
	}
	private static int binarySearch(int target) {
		int start = 0;
		int end = n - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return 1;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else if (arr[mid] < target) {
				start = mid + 1;
			}
		}
		
		return 0;
	}
	
}