import java.io.*;
import java.util.*;

class Solution
{
    static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(input[j]);
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			
			Queue<Point> queue = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			
			queue.offer(new Point(startY, startX, 0));
			visited[startY][startX] = true;
			
			int result = -1;
			while(!queue.isEmpty()) {
				Point current = queue.poll();
                int cy = current.y, cx = current.x, time = current.time;
                
                if (cy == endY && cx == endX) {
                    result = time;
                    break;
                }
                
                for(int i = 0; i < 4; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];
                    
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (visited[ny][nx] == false) {
                        if (graph[ny][nx] == 0) {
                        	queue.offer(new Point(ny, nx, time + 1));
                            visited[ny][nx] = true;
                        } else if (graph[ny][nx] == 2) {
                            if (time % 3 == 2) {
                                visited[ny][nx] = true;
                                queue.add(new Point(ny, nx, time + 1));
                            } 
                            else {
                            	queue.add(new Point(cy, cx, time + 1));
                            }
                        }
                    }
                }
			}
			bw.write("#" + t + " " + result + "\n");
		}
		bw.close();
	}
}

class Point {
	public int y, x, time;
	Point(int y, int x, int time) {
		this.y = y;
		this.x = x;
		this.time = time;
	}
}