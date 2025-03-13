/*
 접근 방법 : 그냥 평범하게 완전탐색하니 50점 -> 문자열 길이가 200,000자 -> 메모이제이션 필요 (dp?)
 문제 태그를 보니 누적합 -> 알파벳 전부 구현 [26][n+1] -> 50점
 
 */

import java.io.*;
import java.util.*;

public class Main {
	static String S;
	static int q, n, accCnt[][], result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		S = br.readLine();
		n = S.length();
		accCnt = new int[26][n+1];
		
		for (int i = 1; i < n + 1; i++) {
			int idx = S.charAt(i-1) - 'a';
			for (int j = 0; j < 26; j++) {
				accCnt[j][i] = accCnt[j][i-1];
			}
			accCnt[idx][i]++;
		}
		
		q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int idx = c - 'a';
			result = accCnt[idx][end+1] - accCnt[idx][start];
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}
