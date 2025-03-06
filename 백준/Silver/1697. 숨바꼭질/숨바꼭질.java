import java.io.*;
import java.util.*;

public class Main {
	public static final int MAX = 100000;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] visited = new int[MAX + 1];
		Arrays.fill(visited, -1);
		visited[n] = 0;

		int a = 0;

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(n);

		while (!queue.isEmpty()) {
			int crr = queue.poll();

			if (crr == k ) {
				System.out.println(visited[crr]);
			}

			for (int i = -1; i <= 2; i++) {
				if (i == 0) continue;
				else if (i == 2) {
					a = crr * i;
					if (a >= 0 && a <= MAX && visited[a] == -1) {
						visited[a] = visited[crr] + 1;
						queue.offer(a);
					}
				} else {
					a = crr + i;
					if (a >= 0 && a <= MAX && visited[a] == -1) {
						visited[a] = visited[crr] + 1;
						queue.offer(a);
					}
				}
			}
		}
	}
}
