import java.io.*;
import java.util.*;

class Solution {
	static class Edge implements Comparable<Edge> {
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	static int tc, n, count;
	static double e;
	static long result;
	static List<Integer> combList;
	static List<Edge> edgeList;
	static int[] parent, x, y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			x = new int[n];
			y = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			e = Double.parseDouble(br.readLine());
			
			combList = new ArrayList<>();
			edgeList = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					long dist = dx * dx + dy * dy;
					edgeList.add(new Edge(i, j, dist));
				}
			}
			
			Collections.sort(edgeList);
			make();
			
			result = 0;
			count = 0;
			
			for (Edge e : edgeList) {
				if (union(e.from, e.to)) {
					result += e.weight;
					count++;
					if (count == n-1) break;
				}
			}
			
			sb = new StringBuilder();
			sb.append("#" + t + " " + Math.round(result * e));
			System.out.println(sb);
		}
	}
	
	private static void make() {
		parent = new int[n];
		for (int i = 0; i < n; i ++) {
			parent[i] = i;
		}
	}
	
	private static int find(int x) {
		if (parent[x] != x ) {
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