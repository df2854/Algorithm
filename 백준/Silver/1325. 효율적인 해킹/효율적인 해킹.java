import java.io.*;
import java.util.*;

public class Main {
	static int n, m, max, result, cnt[];
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
		}
		
		max = Integer.MIN_VALUE;
		cnt = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			Queue<Integer> que = new ArrayDeque<>();
			que.offer(i);
			visited[i] = true;
			while (!que.isEmpty()) {
				int current = que.poll();
				
				for (int num : list[current]) {
					if (!visited[num]) {
						visited[num] = true;
						cnt[i]++;
						que.offer(num);
					}
				}
				
				if (max < cnt[i]) {
					max = cnt[i];
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (cnt[i] == max) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}
