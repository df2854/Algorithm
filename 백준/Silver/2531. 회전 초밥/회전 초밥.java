/*
 접근 방법 : (임의의 한 위치부터 k개의 초밥을 연속해서 먹는거 -> 슬라이딩 윈도우, 가짓수 최댓값 -> Set) -> 이렇게 하면 시간이 오래 걸림
 어떻게 줄일까? -> 전의 코드를 살펴보니 d를 사용하지 않았음 -> d크기의 int 배열을 만들어서 먹은 횟수 저장
 시간 복잡도 : O(n * k)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, d, k, c, cnt, max;
	static int[] arr, eated;
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
		
		eated = new int[d+1]; // 각각 먹은 초밥 수
		cnt = 0;
		
		for (int i = 0; i < k; i++) { // 초기 가짓수 찾기
			if (eated[arr[i]] == 0) {
				cnt++;
			}
			eated[arr[i]]++;
		}
		
		max = cnt; // 현재 가잣수
		
		for (int i = 0; i < n; i++) { // 슬라이딩 윈도우
			if (max <= cnt) {
				if (eated[c] == 0) { // 쿠폰 초밥 먹은 적 없는 경우, 가짓수 하나 더하기
					max = cnt + 1;
				} else {
					max = cnt;
				}
			}
			
			// 앞쪽을 뺐을 때, 먹은 횟수가 0이 되면 가짓수 하나 빼기
			eated[arr[i]]--;
			if (eated[arr[i]] == 0) {
				cnt--;
			}
			
			// 다음 것을 넣을 때, 넣기 전에 먹은 횟수가 0이면 가짓수 하나 더하기
			if (eated[arr[(i + k) % n]] == 0) {
				cnt++;
			}
			eated[arr[(i + k) % n]]++;
		}
		
		System.out.println(max);
	}
}
