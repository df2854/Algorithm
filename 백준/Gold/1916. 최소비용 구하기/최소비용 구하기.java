import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int v;
		int w;
		
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static List<List<Node>> list;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int sNode = Integer.parseInt(st.nextToken());
		int lNode = Integer.parseInt(st.nextToken());
		
		dijkstra(sNode, lNode);
	}
	
	public static void dijkstra(int start, int end) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int cv = cur.v;
			int cw = cur.w;
			
			if (cw > dist[cv]) continue;
			
			for (Node node : list.get(cv)) {
				int ndist = dist[cv] + node.w;
				
				if (dist[node.v] > ndist) {
					dist[node.v] = ndist;
					pq.offer(new Node(node.v, ndist));
				}
			}
		}
		
		System.out.println(dist[end]);
	}
}
