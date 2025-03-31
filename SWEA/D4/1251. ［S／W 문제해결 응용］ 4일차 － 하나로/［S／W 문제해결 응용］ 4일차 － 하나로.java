import java.io.*;
import java.util.*;

class Solution {
	static class Edge implements Comparable<Edge> {
		int to;
		long weight;
		
		Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Solution.Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	static int tc, n;
	static double e;
	static long result;
	static List<Edge>[] edgeList;
	static int[] x, y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			x = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			y = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			e = Double.parseDouble(br.readLine());
			
			edgeList = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				edgeList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					long dist = dx * dx + dy * dy;
					
					edgeList[i].add(new Edge(j, dist));
					edgeList[j].add(new Edge(i, dist));
				}
			}
			
			result = prim(1);
			
			sb.append("#").append(t).append(" ").append(Math.round(result * e)).append("\n");
		}
		System.out.println(sb);
	}
	private static long prim(int start) {
		boolean[] visited = new boolean[n];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		long total = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int node = cur.to;
			long w = cur.weight;
			
			if (visited[node]) continue;
			
			total += w;
			visited[node] = true;
			
			for (Edge e : edgeList[node]) {
				if (!visited[e.to]) {
					pq.offer(e);
				}
			}
		}
		
		return total;
	}
}