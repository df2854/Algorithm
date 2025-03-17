/*
 접근 방법 : 임의의 한 위치부터 k개의 초밥을 연속해서 먹는거 -> 슬라이딩 윈도우, 가짓수 최댓값 -> Set
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, d, k, c, result;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 슬라이딩 윈도우를 Queue로
		Queue<Integer> q = new ArrayDeque<>();
		// 초기 슬라이딩 윈도우
		for (int i = 0; i < k; i++) {
			q.offer(arr[i]);
		}
		Set<Integer> set = new HashSet<>(q); // 가짓수 확인
		set.add(c); // 쿠폰 초밥 추가
		result = set.size();
		
		for (int i = 0; i < n-1; i++) { // 슬라이딩 윈도우
			q.poll(); // 제일 앞에 빼고
			q.offer(arr[(i+k) % n]); // 다음꺼 넣기
			
			set = new HashSet<>(q); // 가짓수 확인
			set.add(c); // 쿠폰 추가
			
			result = Math.max(result, set.size());
		}
		
		System.out.println(result);
	}
}
