import java.util.*;
import java.io.*;

class Main {
	static int n, m, ans;
	static boolean[] visited;
	static List<List<Integer>> list, reverseList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		reverseList = new ArrayList<>();
		for (int i = 0; i <= n+1; i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);
			reverseList.get(end).add(start);
		}
		
		ans = 0;
		
		for (int i = 1; i <= n; i++) {
			int parent = dfs(i);
			int child = dfs2(i);
			
			if (parent + child == n-1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int dfs(int k) {
		Stack<Integer> stack = new Stack<>();
		visited = new boolean[n+1];
		int cnt = 0;
		
		stack.push(k);
		visited[k] = true;
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			
			for (int idx : list.get(cur)) {
				if (!visited[idx]) {
					cnt++;
					visited[idx] = true;
					stack.push(idx);
				}
			}
		}
		
		return cnt;
	}
	
	public static int dfs2(int k) {
		Stack<Integer> stack = new Stack<>();
		visited = new boolean[n+1];
		int cnt = 0;
		
		stack.push(k);
		visited[k] = true;
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			
			for (int idx : reverseList.get(cur)) {
				if (!visited[idx]) {
					cnt++;
					visited[idx] = true;
					stack.push(idx);
				}
			}
		}
		
		return cnt;
	}

}
