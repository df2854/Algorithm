import java.io.*;
import java.util.*;

public class Main {
	static int tc, n, k, w, result;
	static int[] time, inD, dp;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			time = new int[n+1];
			list = new ArrayList[n+1];
			inD = new int[n+1];
			dp = new int[n+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list[from].add(to);
				inD[to]++;
			}
			
			w = Integer.parseInt(br.readLine());
			
			Queue<Integer> que = new ArrayDeque<>();
			for (int i = 1; i <= n; i++) {
				if (inD[i] == 0) {
					que.offer(i);
					dp[i] = time[i];
				}
			}
			
			while (!que.isEmpty()) {
				int cur = que.poll();
				
				for (int next : list[cur]) {
					dp[next] = Math.max(dp[next], dp[cur] + time[next]);
					inD[next]--;
					if (inD[next] == 0) que.offer(next);
				}
			}
			
			System.out.println(dp[w]);
		}
	}	
}
