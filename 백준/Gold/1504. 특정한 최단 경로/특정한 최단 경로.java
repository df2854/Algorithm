import java.io.*;
import java.util.*;

public class Main {
	static class Vertex implements Comparable<Vertex> {
		int no, weight;
		
		Vertex (int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int n, e, v1, v2;
	static long result;
	static List<Vertex>[] edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		edgeList = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			edgeList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edgeList[a].add(new Vertex(b, c));
			edgeList[b].add(new Vertex(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int[] from1 = dijkstra(1);
		int[] fromV1 = dijkstra(v1);
		int[] fromV2 = dijkstra(v2);
		
		long path1 = (long) from1[v1] + fromV1[v2] + fromV2[n];
		long path2 = (long) from1[v2] + fromV2[v1] + fromV1[n];
		
		result = Math.min(path1, path2);
		
		System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
	}
	private static int[] dijkstra(int start) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		pq.offer(new Vertex(start, dist[start]));
		
		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			for (Vertex next : edgeList[cur.no]) {
				int newDist = dist[cur.no] + next.weight;
				
				if (dist[next.no] > newDist) {
					dist[next.no] = newDist;
					pq.offer(new Vertex(next.no, dist[next.no]));
				}
			}
		}
		
		return dist;
	}	
}
