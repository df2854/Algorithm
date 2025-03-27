/*
 접근 방법 : 구간 구하기 -> 투 포인터? 귀여운 라이언 문제와 비슷
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, b, w, result;
	static char[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		arr = new char[n];
		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			arr[i] = input.charAt(i);
		}
		
		int left = 0, right = 0;
		int bCnt = 0, wCnt = 0;
		int result = 0;
		while (right < n) {
			// 오른쪽 확장
			if (arr[right] == 'B') bCnt++;
			else if (arr[right] == 'W') wCnt++;
			right++;
			
			// 검은 돌 개수가 초과하면 왼쪽 포인터 이동
			while (bCnt > b) {
				if (arr[left] == 'B') bCnt--;
				else if (arr[left] == 'W') wCnt--;
				left++;
			}
			
			if (wCnt >= w) {
				result = Math.max(result, right - left);
			}
		}
		
		System.out.println(result);
	}
}
