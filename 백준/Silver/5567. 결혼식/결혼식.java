import java.io.*;
import java.util.*;

public class Main {
	static int n, m, cnt;
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		for (int i = 0; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		visited = new boolean[n+1];
		visited[1] = true;
		dfs(0, 1);

		cnt = 0;
		
		for (int i = 2; i < n + 1; i++) {
			if (visited[i]) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
	private static void dfs(int depth, int num) {
		if (depth == 2) {
			return;
		}

		for (int i : list[num]) {
			visited[i] = true;
			dfs(depth + 1, i);
		}
	}

}
