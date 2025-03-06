import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] time;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		time = new int[100001];
		Arrays.fill(time, -1);
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(n);
		time[n] = 0;
		while (!que.isEmpty()) {
			int current = que.poll();
			if (current == k) {
				System.out.println(time[current]);
				return;
			}
			
			int newPosition = 2 * current;
            if (newPosition <= 100000 && time[newPosition] == -1) {
                que.offer(newPosition);
                time[newPosition] = time[current];
            }
			
			for (int i : new int[]{current - 1, current + 1}) {
                if (i >= 0 && i <= 100000 && time[i] == -1) {
                    que.offer(i);
                    time[i] = time[current] + 1;
                }
            }
			
		}
		
	}
}
