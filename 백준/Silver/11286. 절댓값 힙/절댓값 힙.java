import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int n = Math.abs(o1) - Math.abs(o2);
				if (n == 0) {
					return o1 - o2;
				}
				return n;
			}
		});
		for (int i = 0; i < n; i++) {
			int key = Integer.parseInt(br.readLine());
			if (key != 0) {
				que.offer(key);
			} else {
				if (que.isEmpty()) {
					bw.write(0 + "\n");
					continue;
				}
				bw.write(que.poll() + "\n");
			}
		}
		
		bw.close();
	}
}