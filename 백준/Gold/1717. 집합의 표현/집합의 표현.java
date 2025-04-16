import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (key == 0) {
				union(a, b);
			} else if (key == 1) {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else System.out.println("NO");
			}
		}
	}	
	
	private static void init() {
		parent = new int[n+1];
		rank = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	private static int find(int a) {
		if (parent[a] != a) {
			parent[a] = find(parent[a]);
		}
		
		return parent[a];
	}
	
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB) return;
		
		if (rank[rootA] < rank[rootB]) {
			parent[rootA] = rootB;
		} else if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
		} else {
			parent[rootB] = rootA;
			rank[rootA]++;
		}
	}
}
