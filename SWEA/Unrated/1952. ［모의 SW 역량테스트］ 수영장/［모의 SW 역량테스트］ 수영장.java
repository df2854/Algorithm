import java.util.*;
import java.io.*;

class Solution {
	static int charge[], month[], result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			charge = new int[4];
			month = new int[12];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				charge[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			result = charge[3];
			
			bt(0, 0);
			
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
	private static void bt(int m, int sum) {
		if (m >= 12) {
			if (sum > 0) {
				result = Math.min(result, sum);
			}
			return;
		}
		
		if (month[m] == 0) bt(m+1, sum);
		else {
			bt(m+1, sum + (month[m] * charge[0]));
			bt(m+1, sum + charge[1]);
			bt(m+3, sum + charge[2]);
		}
	}

}
