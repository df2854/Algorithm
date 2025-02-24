import java.util.*;
import java.io.*;

class Solution {
	static int tc, n;
	static Queue<Integer> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		for (int t = 1; t <= 10; t++) {
			tc = Integer.parseInt(br.readLine());
			
			que = new ArrayDeque<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}
			
			n = 0;
			
			out: while (true) {
				for (int i = 1; i <= 5; i++) {
					int num = que.poll() - i;
					if (num > 0) {
						que.offer(num);
					} else {
						num = 0;
						que.offer(num);
						break out;
					}
				}
 			}
			
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			for (int num : que) {
				sb.append(num).append(" ");
			}
			
			System.out.println(sb);
		}
	}
}
