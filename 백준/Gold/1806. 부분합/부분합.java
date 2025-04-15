import java.io.*;
import java.util.*;

public class Main {
	static int n, s, result;
	static int[] arr, sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sum = new int[n+1];
		sum[1] = arr[0];
		for (int i = 2; i <= n; i++) {
			sum[i] += arr[i-1] + sum[i-1];
		}
		
		result = n + 1;
		int left = 0, right = 1;
		while (left < right && right <= n) {
			int a = sum[right] - sum[left];
			
			if (a >= s) {
				result = Math.min(result, right - left);
				left++;
			} else {
				right++;
			}
		}
		
		System.out.println(result == n+1 ? 0 : result);
	}
}
