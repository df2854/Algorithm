/*
 접근 방법 : 그래프 탐색, 처음에 루트에서 U까지 방문 처리(dfs)하고 다시 루트 U인 서브트리 정점의 수를 계산(dfs)
 dfs를 두 번 하니까 시간초과  (N, Q <= 10^5이므로 당연히 시간 초과)
 그래서 트리의 각 노드의 depth를 저장 ->  서브 트리 루트의 depth보다 큰 노드만 dfs -> 그런데 이번에는 메모리 초과
 visited말고 다른 방법 필요 dp?
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, r, q;
	static int[] dp;
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[start].add(end);
			list[end].add(start);
		}

		dp = new int[n+1];
		Arrays.fill(dp, 1);
		
		dfs(r, 0);
		
		for (int i = 0; i < q; i++) {
			int root = Integer.parseInt(br.readLine());
			System.out.println(dp[root]);
		}
	}
	private static void dfs(int node, int parent) {
		for (int i : list[node]) {
			if (i != parent) {
				dfs(i, node);
				dp[node] += dp[i];
			}
		}
	}
}
