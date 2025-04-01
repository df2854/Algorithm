import java.io.*;
import java.util.*;

public class Main {
	static int n, sLeft, sRight;
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
		
		int left = 0;
		int right = n - 1;
		int tmp = Integer.MAX_VALUE;
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			if (Math.abs(sum) < Math.abs(tmp)) {
				tmp = sum;
				sLeft = left;
				sRight = right;
			}
			
			if (sum > 0) right--;
			else left++;
		}
		
		System.out.println(arr[sLeft] + " " + arr[sRight]);
	}

}
