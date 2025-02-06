import java.io.*;
import java.util.*;

class Point {
    int y;
    int x;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int[] dy = {-1, 0, 1, 0};
            int[] dx = {0, 1, 0, -1};

            Queue<Point> que = new ArrayDeque<>();

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        map[i][j] = -1;
                        que.offer(new Point(i, j));
                        while (!que.isEmpty()) {
                            Point cur = que.poll();
                            int cy = cur.y;
                            int cx = cur.x;

                            for (int dir = 0; dir < 4; dir++) {
                                int ny = cy + dy[dir];
                                int nx = cx + dx[dir];
                                if (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 1) {
                                    map[ny][nx] = -1;
                                    que.offer(new Point(ny, nx));
                                }
                            }
                        }
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
