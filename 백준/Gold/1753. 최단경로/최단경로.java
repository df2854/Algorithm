import java.io.*;
import java.util.*;

class Node {
    int v;
    int w;

    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
    
}

public class Main {
    private static void dijkstra (List<List<Node>> graph, int start) {
        int n = graph.size();
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[start] = 0;
        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> {
        	return o1.w - o2.w;
        });
        que.offer(new Node(start, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int curV = cur.v;
            int curW = cur.w;

            if (curW > dis[curV]) continue;

            for (Node node : graph.get(curV)) {
                int newDis = dis[curV] + node.w;

                if (newDis < dis[node.v]) {
                    dis[node.v] = newDis;
                    que.offer(new Node(node.v, newDis));
                }
            }
        }

        for (int i = 1; i <= n-1; i++) {
            System.out.println((dis[i] == Integer.MAX_VALUE) ? "INF" : dis[i]);
        }
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }
        

        dijkstra(graph, start);
	}
}
