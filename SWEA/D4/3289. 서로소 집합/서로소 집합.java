import java.io.*;
import java.util.*;

class Solution {
	static class UnionFind {
		int[] parent;
		int[] rank;
		
		UnionFind(int size) {
			parent = new int[size+1];
			rank = new int[size+1];
			
			for (int i = 1; i <= size; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}
		
		int find(int x) {
			if (parent[x] != x) {
				parent[x] = find(parent[x]);
			}
			
			return parent[x];
		}
		
		void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			
			if (rootX == rootY) return;
			
			if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else if (rank[rootY] > rank[rootX]) {
				parent[rootY] = rootX;
			} else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
	}
	static int tc, n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			UnionFind u = new UnionFind(n);
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int key = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				switch(key) {
				case 0:
					u.union(x, y);
					break;
				case 1:
					if (u.find(x) == u.find(y)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					break;
				}
			}
			
			bw.write(sb + "\n");
		}
		bw.flush();
		bw.close();
	}
	
}
