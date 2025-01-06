import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int n, m, r;
	static int[] visitOrder; 
	static int order;
	static ArrayList<Integer>[] graph;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(int n) throws IOException {
		if (!visited[n]) {
			visited[n] = true;
			visitOrder[n] = order++;
		}
		
		for (int next : graph[n]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
	}
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[n+1];
        visitOrder = new int[n + 1];
        order = 1;
        
        dfs(r);
        for (int i = 1; i <= n; i++) {
            bw.write(visitOrder[i] + "\n");
        }
        bw.close();
	}
	
}