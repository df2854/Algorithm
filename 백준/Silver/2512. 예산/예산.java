import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		int end = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, arr[i]);
		}
		int limit = Integer.parseInt(br.readLine());
		
		int start = 0;
		// 파라메트릭 서치
		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (mid >= arr[i]) {
					sum += arr[i];
				} else {
					sum += mid;
				}
			}
			
			if (sum <= limit) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		bw.write(end + "\n");
		bw.flush();
		bw.close();
	}
}
