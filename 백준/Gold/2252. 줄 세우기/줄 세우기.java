import java.io.*;
import java.util.*;

public class Main {
	static int n, m; // n : 정점의 개수, m : 간선의 개수
	static List<Integer>[] list;
	static int[] inD;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		list = new ArrayList[n+1];
		inD = new int[n+1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		int x, y;
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			list[x].add(y);
			// 진입차수 관리
			inD[y]++;
		}
		
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (inD[i] == 0) que.offer(i);
		}
		// 가지 치기 que 사이즈가 0이면 해결 불가
		
		List<Integer> ans = new ArrayList<>();
		int cnt = 0;
		while(!que.isEmpty()) {
			int cur = que.poll();
			ans.add(cur);
			cnt++;
			
			for (int idx : list[cur]) {
				inD[idx]--;
				if (inD[idx] == 0) que.offer(idx);
			}
		}
		// 판단 cnt == n
		// cnt != n이면 사이클 존재
		
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
