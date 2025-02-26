import java.util.*;
import java.io.*;

class Solution {
	static int n, arr[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int result = 0;
			int down = 0;
			int up = 0;
			
			for (int i = 1; i < n; i++) {
				if (arr[i-1] < arr[i]) {
					if (down > 0) {
						result += up * down;
						up = 0;
						down = 0;
					}
					up++;
				} else {
					down++;
				}
			}
			result += up * down;
			
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
