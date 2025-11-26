import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	private static int N, M;
	private static int[][] adjMatrix;
	private static int[] parent, rank, road;
	private static String answer;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		answer = "YES";
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		init();
		
		adjMatrix = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());
				adjMatrix[i][j] = a;
				if (a == 1) {
					union(i, j);
				}
			}
		}
		
		road = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			road[i] = Integer.parseInt(st.nextToken());
			if (i > 0 && find(road[i-1]) != find(road[i])) {
				answer = "NO";
			}
		}
		
		System.out.println(answer);
		
	}
	
	private static void init() {
		parent = new int[N+1];
		rank = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
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
