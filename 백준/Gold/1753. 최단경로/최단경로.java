import java.io.*;
import java.util.*;

public class Main {
	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int v, e, k, result;
	static int[] dist;
	static boolean[] visited;
	static List<Vertex>[] vertexList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		k = Integer.parseInt(br.readLine());
		
		vertexList = new ArrayList[v+1];
		for (int i = 0; i <= v; i++) {
			vertexList[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			vertexList[u].add(new Vertex(v, w));
		}
		
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[v+1];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		dist[k] = 0;
		pq.offer(new Vertex(k, 0));
			
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			int curV = cur.no;
			int curW = cur.weight;
			
			if (visited[curV]) continue;
			
			visited[curV] = true;
			
			for (Vertex n : vertexList[curV]) {
                if (!visited[n.no]) {
                    int newDis = dist[curV] + n.weight;
				
				    if (dist[n.no] > newDis) {
					    dist[n.no] = newDis;
					    pq.offer(new Vertex(n.no, dist[n.no]));
				    }
                }
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
