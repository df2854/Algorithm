import java.util.*;
import java.io.*;

class Solution {
	static int n, arr[], ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			ans = 0;
			nQueen(0);
			
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void nQueen(int num) {
		if (num == n) {
			ans++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[num] = i;
			if (isAvailable(num)) {
				nQueen(num+1);
			}
		}
	}

	private static boolean isAvailable(int idx) {
		for (int i = 0; i < idx; i++) {
			if (arr[idx] == arr[i]) return false;
			
			if (Math.abs(arr[idx] - arr[i]) == Math.abs(idx - i)) return false;
		}
		
		return true;
	}
}
