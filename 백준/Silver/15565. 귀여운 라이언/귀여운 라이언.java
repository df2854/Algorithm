import java.io.*;
import java.util.*;

public class Main {
	static int n, k, result;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, right = 0, cnt = 0;
		int result = Integer.MAX_VALUE;
		
		while (right < n) {
			if (arr[right] == 1) cnt++;
			
			while (cnt >= k) {
				result = Math.min(result, right - left + 1);
				if (arr[left] == 1) cnt--;
				left++;
			}
			
			right++;
		}
		
		if (result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
}
