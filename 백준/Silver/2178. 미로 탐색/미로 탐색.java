import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static int[][] graph;

    static class Point {
        public int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        String[] input;
        for(int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<Point> que = new LinkedList<>();
        graph[0][0] = -1;
        que.offer(new Point(0, 0));
        while (!que.isEmpty()) {
            Point cur = que.poll();
            int cy = cur.y, cx = cur.x;

            for(int dir = 0; dir < 4; dir++) {
                int ny = cy + dy[dir], nx = cx + dx[dir];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && graph[ny][nx] == 1) {
                    graph[ny][nx] = graph[cy][cx] - 1;
                    que.offer(new Point(ny, nx));
                }
            }
        }

        System.out.println(-graph[n-1][m-1]);
    }
}