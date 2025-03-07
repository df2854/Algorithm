import java.io.*;
import java.util.*;

class Solution {
	static int v, e;
	static int[] inD;
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[v+1];
			for (int i = 0; i < v+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			inD = new int[v+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				inD[to]++;
			}
			
			Queue<Integer> que = new ArrayDeque<>();
			for (int i = 1; i <= v; i++) {
				if (inD[i] == 0) que.offer(i);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			while(!que.isEmpty()) {
				int cur = que.poll();
				sb.append(cur).append(" ");
				
				for (int idx : list[cur]) {
					inD[idx]--;
					if (inD[idx] == 0) que.offer(idx);
				}
			}
			bw.write(sb + "\n");
		}
		bw.flush();
		bw.close();
	}
	
}
