import java.io.*;
import java.util.*;

public class Main {
	static int n, m, cnt;
	static int[] inD;
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		inD = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] input = new int[num];
			for (int j = 0; j < num; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < num - 1; j++) {
				list[input[j]].add(input[j+1]);
				inD[input[j+1]]++;
			}
		}
		
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (inD[i] == 0) {
				que.offer(i);
			}
		}
		
		if (que.size() == 0) {
			System.out.println(0);
			return;
		}
		
		int cnt = 0;
		while (!que.isEmpty()) {
			int cur = que.poll();
			sb.append(cur).append("\n");
			cnt++;
			
			for (int idx : list[cur]) {
				inD[idx]--;
				if (inD[idx] == 0) {
					que.offer(idx);
				}
			}
		}
		
		if (cnt != n) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}
}
