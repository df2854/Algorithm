import java.util.*;

class Solution {
    class Point {
        int y;
        int x;
        
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    private int[] dy = {-1, 0, 1, 0};
    private int[] dx = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        if (maps[0][0] == 0) return -1;
        
        Queue<Point> que = new ArrayDeque<>();
        que.offer(new Point(0, 0));
        maps[0][0] = -1;
        
        while (!que.isEmpty()) {
            Point cur = que.poll();
            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                
                if(ny < n && ny >= 0 && nx < m && nx >= 0 && maps[ny][nx] == 1) {
                    maps[ny][nx] = maps[cur.y][cur.x] - 1;
                    que.offer(new Point(ny, nx));
                }
                
                if (ny == n-1 && nx == m-1) {
                    return -maps[ny][nx];
                }
            }
        }
        return -1;
    }
}