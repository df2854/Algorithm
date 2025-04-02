import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int n, m;
	static List<Edge> edgeList;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		edgeList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to  = Integer.parseInt(st.nextToken());
			int weight  = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(from, to, weight));
		}
		
		Collections.sort(edgeList);
		
		make();
		
		int count = 0;
		int result = 0;
		int max = 0;
		
		for (Edge e : edgeList) {
			if (union(e.from, e.to)) {
				result += e.weight;
				max = Math.max(max, e.weight);
				count++;
				if (count == n - 1) break;
			}
		}
		
		System.out.println(result - max);
	}
	private static void make() {
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	private static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	private static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX == rootY) return false;
		
		parent[rootY] = rootX;
		return true;
	}
}
