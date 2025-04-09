import java.io.*;
import java.util.*;

public class Main {
	static int v, e, result;
	static List<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[v+1];
		for (int i = 0; i <= v; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		visited = new boolean[v+1];
		
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(1);
		visited[1] = true;
		result = 0;
		
		while (!que.isEmpty()) {
			int cur = que.poll();
			
			for (int num : adjList[cur]) {
				if (visited[num]) continue;
				
				visited[num] = true;
				result++;
				que.offer(num);
			}
		}
		
		System.out.println(result);
	}
} 
