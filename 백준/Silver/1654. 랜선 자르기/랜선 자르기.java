import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[k-1];

		while (left <= right) {
			long mid = (left + right) / 2;
			int count = 0;
			for (int num : arr) {
				count += (num / mid);
			}
			
			if (count >= n) {
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
