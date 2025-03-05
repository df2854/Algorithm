import java.io.*;
import java.util.*;

public class Main {
	static int n, m, target;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			target = Integer.parseInt(st.nextToken());
			sb.append(upperBound(target) - lowerBound(target)).append(" ");
		}
		
		bw.write(sb + "\n");
		bw.flush();
		bw.close();
	}
	private static int lowerBound(int num) {
		int left = 0;
		int right = n;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] >= num) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	private static int upperBound(int num) {
		int left = 0;
		int right = n;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] > num) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}
