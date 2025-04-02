import java.io.*;
import java.util.*;

public class Main {
	static class Fox {
		int no;
		long weight;
		
		public Fox(int no, long weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	}
	static class Wolf {
		int no;
		long weight;
		boolean tag;
		
		public Wolf(int no, long weight, boolean tag) {
			super();
			this.no = no;
			this.weight = weight;
			this.tag = tag;
		}
	}
	static int n, m, result;
	static List<Fox>[] vertexList;
	static long[] foxDist;
	static long[][] wolfDist;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		vertexList = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			vertexList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken()) * 2;
			
			vertexList[from].add(new Fox(to, weight));
			vertexList[to].add(new Fox(from, weight));
		}
		
		foxDist = new long[n+1];
		
		Arrays.fill(foxDist, Long.MAX_VALUE);
		
		foxDist[1] = 0;
		
		visited = new boolean[n+1];
		
		PriorityQueue<Fox> pqF = new PriorityQueue<>((o1, o2) -> {
			return Long.compare(o1.weight, o2.weight);
		});
		
		PriorityQueue<Wolf> pqW = new PriorityQueue<>((o1, o2) -> {
			return Long.compare(o1.weight, o2.weight);
		});
		
		pqF.offer(new Fox(1, 0));
		
		
		while (!pqF.isEmpty()) {
			Fox cur = pqF.poll();
			
			if (visited[cur.no]) continue;
			visited[cur.no] = true;

			for (Fox f : vertexList[cur.no]) {
				if (!visited[f.no] && foxDist[f.no] > foxDist[cur.no] + f.weight) {
					foxDist[f.no] = foxDist[cur.no] + f.weight;
					pqF.offer(new Fox(f.no, foxDist[f.no]));
				}
			}
		}
		
		wolfDist = new long[n+1][2];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(wolfDist[i], Long.MAX_VALUE);
		}
		wolfDist[1][0] = 0;
		
		pqW.offer(new Wolf(1, 0, true));
		
		while (!pqW.isEmpty()) {
			Wolf cur = pqW.poll();
			int tagIdx = cur.tag ? 0 : 1;
			
			if (cur.weight > wolfDist[cur.no][tagIdx]) continue;
			
			for (Fox w : vertexList[cur.no]) {
				boolean nextTag = !cur.tag;
				int nextTagIdx = nextTag ? 0 : 1;
				long edgeWeight = w.weight;
				long nextWeight = cur.tag ? cur.weight + (edgeWeight / 2) : cur.weight + (edgeWeight * 2);
				if (wolfDist[w.no][nextTagIdx] > nextWeight) {
					wolfDist[w.no][nextTagIdx] = nextWeight;
					pqW.offer(new Wolf(w.no, wolfDist[w.no][nextTagIdx], nextTag));
				}
				
			}
		}
		
		result = 0;
		
		for (int i = 1; i <= n; i++) {
			if (foxDist[i] < Math.min(wolfDist[i][0], wolfDist[i][1])) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
