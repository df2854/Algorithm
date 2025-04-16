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
		
		parent = new int[n];
		rank = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (find(a) != find(b)) {
				union(a, b);
			} else {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
	}	
	
	private static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}
	
	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX == rootY) return;
		
		if (rank[rootX] < rank[rootY]) {
			parent[rootX] = rootY;
		} else if (rank[rootX] > rank[rootY]) {
			parent[rootY] = rootX;
		} else {
			parent[rootY] = rootX;
			rank[rootX]++;
		}
	}
	
}
