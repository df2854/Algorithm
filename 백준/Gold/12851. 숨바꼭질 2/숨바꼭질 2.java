import java.io.*;
import java.util.*;

public class Main {
	static int n, k, cnt;
	static int[] time;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		time = new int[100001];
		Arrays.fill(time, -1);
		cnt = 0;
		
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(n);
		time[n] = 0;
		while (!que.isEmpty()) {
			int current = que.poll();
			if (current == k) {
				cnt++;
				continue;
			}
			
			int[] a = {1, -1, current};
			
			for (int i = 0; i < 3; i++) {
				int newPosition = current + a[i];
				
				if (newPosition >= 0 && newPosition <= 100000) {
					if (time[newPosition] == -1 || time[newPosition] == time[current] + 1) {
						que.offer(newPosition);
						time[newPosition] = time[current] + 1;
					}
				}
			}
		}
		
		System.out.println(time[k]);
		System.out.println(cnt);
	}
}
