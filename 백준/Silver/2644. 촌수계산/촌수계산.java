import java.io.*;
import java.util.*;

public class Main {
	static int n, m, x, y, cnt, result;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dist = new int[n+1];
		Arrays.fill(dist, -1);
		
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(x);
		dist[x] = 0;
		while(!que.isEmpty()) {
			int current = que.poll();
            if (current == y) break;
            
			for (int num : list[current]) {
				if (dist[num] == -1) {
					dist[num] = dist[current] + 1;
					que.offer(num);
				}
			}
		}
		System.out.println(dist[y]);
	}
}
