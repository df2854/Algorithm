import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	static int tc, n, m, w;
	static boolean cycle;
	static int[] dist;
	static List<Edge> edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			edgeList = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edgeList.add(new Edge(from, to, weight));
				edgeList.add(new Edge(to, from, weight));
			}
			
			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edgeList.add(new Edge(from, to, -weight));
			}
			
			cycle = false;
		
			dist = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				for (Edge e : edgeList) {
					if (dist[e.to] > dist[e.from] + e.weight) {
						dist[e.to] = dist[e.from] + e.weight;
						if (i == n) cycle = true;
					}
				}
			}

			System.out.println(cycle ? "YES" : "NO");
		}
	}

}
