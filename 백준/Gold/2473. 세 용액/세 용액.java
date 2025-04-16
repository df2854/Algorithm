import java.io.*;
import java.util.*;

public class Main {
	static int tc, n, ans, ansLeft, ansRight;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long tmp = Long.MAX_VALUE;
		
		for (int i = 0; i < n-2; i++) {
			int left = i+1, right = n-1;
			
			while (left < right) {
				long sum = (long)arr[i] + arr[left] + arr[right];
				if (Math.abs(sum) < Math.abs(tmp)) {
					tmp = sum;
					ans = i;
					ansLeft = left;
					ansRight = right;
				}
				
				if (sum < 0) left++;
				else right--;
			}
		}

		System.out.println( arr[ans] + " " + arr[ansLeft] + " " + arr[ansRight]);
	}	
}
