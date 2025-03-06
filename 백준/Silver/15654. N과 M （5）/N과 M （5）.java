import java.io.*;
import java.util.*;

public class Main {
	static int n, m, arr[], result;
	static boolean[] visited;
	static List<Integer> list;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		visited = new boolean[n];
		list = new ArrayList<>();	
		
		perm(0);
		
		System.out.println(sb);
	}
	private static void perm(int idx) {
		if (idx == m) {
			for (int num : list) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			
			list.add(arr[i]);
			visited[i] = true;
			
			perm(idx + 1);
			
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}
}