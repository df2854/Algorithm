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
	static int v, e, result;
	static List<Vertex>[] vertexList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		vertexList = new ArrayList[v+1];
		for (int i = 0; i <= v; i++) {
			vertexList[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			vertexList[from].add(new Vertex(to, weight));
			vertexList[to].add(new Vertex(from, weight));
		}
		
		visited = new boolean[v+1];
		result = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1, 0));
		
		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			if (visited[cur.no]) continue;
			
			result += cur.weight;
			visited[cur.no] = true;
			
			for (Vertex n : vertexList[cur.no]) {
				if (!visited[n.no]) {
					pq.offer(n);
				}
			}
		}
		
		System.out.println(result);
	}

}
