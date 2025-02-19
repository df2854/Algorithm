import java.util.*;
import java.io.*;

class Solution {
	static class Point{
		int y, x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int n, ans, maxCore, map[][];
	static List<Point> list;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || i == n-1 || j == 0 || j == n-1) continue;
						list.add(new Point(i, j));
					}
				}
			}
			
			ans = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	public static void dfs(int idx, int sum, int core) {
		if (idx == list.size()) {
			if (maxCore < core) {
				maxCore = core;
				ans = sum;
			} else if (maxCore == core) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		
		Point cur = list.get(idx);
		int cy = cur.y;
		int cx = cur.x;
		
		for (int d = 0; d < 4; d++) {
			int ny = cy, nx = cx;
			int cnt = 0;
			
			while(true) {
				ny += dy[d];
				nx += dx[d];
				
				if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
					break;
				}
				
				if (map[ny][nx] == 1) {
					cnt = 0;
					break;
				}
				
				cnt++;
			}
			
			if (cnt != 0) {
				int fy = cy, fx = cx;
				for (int i = 0; i < cnt; i++) {
					fy += dy[d];
					fx += dx[d];
					map[fy][fx] = 1;
				}
				
				dfs(idx+1, sum + cnt, core + 1);
				
				fy = cy;
				fx = cx;
				for (int i = 0; i < cnt; i++) {
					fy += dy[d];
					fx += dx[d];
					map[fy][fx] = 0;
				}
			} else {
				dfs(idx+1, sum, core);
			}
		}
	}
}
