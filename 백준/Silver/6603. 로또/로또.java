/*
 접근 방법 : 조합문제
 시간 복잡도 : O(n+q)
 */

import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] lotto;
	static int[] result = new int[6];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) return;
			
			lotto = new int[k];
			for (int i = 0; i < k; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			
			sb = new StringBuilder();
			
			comb(0, 0);
			System.out.println(sb);
		}
	}
	private static void comb(int idx, int start) {
		if (idx == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < k; i++) {
			result[idx] = lotto[i];
			comb(idx + 1, i + 1);
		}
	}
}
