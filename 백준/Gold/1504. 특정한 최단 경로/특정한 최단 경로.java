import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static class Vertex implements Comparable<Vertex> {
		int node, weight;

		public Vertex(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static int N, E, v1, v2;
	private static long result;
	private static List<Vertex>[] adjList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Vertex(b, c));
			adjList[b].add(new Vertex(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int[] from1 = dijkstra(1);
		int[] fromV1 = dijkstra(v1);
		int[] fromV2 = dijkstra(v2);
		
		long a = (long) from1[v1] + fromV1[v2] + fromV2[N];
		long b = (long) from1[v2] + fromV2[v1] + fromV1[N];
		
		result = Math.min(a, b);
		
		System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
	}
	
	public static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, 0));
		
		while(!pq.isEmpty()) {
			Vertex no = pq.poll();
			
			if (no.weight > dist[no.node]) continue;
			
			for (Vertex next : adjList[no.node]) {
				if (dist[next.node] > next.weight + dist[no.node]) {
					dist[next.node] = next.weight + dist[no.node];
					pq.offer(new Vertex(next.node, dist[next.node]));
				}
			}
		}
		
		return dist;
	}
}
