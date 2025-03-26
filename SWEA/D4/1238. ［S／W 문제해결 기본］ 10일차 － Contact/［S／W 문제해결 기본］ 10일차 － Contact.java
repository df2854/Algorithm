import java.io.*;
import java.util.*;

class Solution {
	static int n, start;
	static List<Integer>[] list;
	static int[] depth;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[101];
			for (int i = 0; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list[from].add(to);
			}
			
			depth = new int[101];
			
			Queue<Integer> que = new ArrayDeque<>();
			que.add(start);
			depth[start] = 0;
			int max = -1;
			while(!que.isEmpty()) {
				int cur = que.poll();
			
				for (int num : list[cur]) {
					if (depth[num] == 0) {
						depth[num] = depth[cur] + 1;
						max = Math.max(max, depth[num]);
						que.offer(num);
					}
				}
			}
			
			for (int i = 100; i >= 1; i--) {
				if (depth[i] == max) {
					sb.append(i);
					break;
				}
			}
			
			System.out.println(sb);
		}
	}
}