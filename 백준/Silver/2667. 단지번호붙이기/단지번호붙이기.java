import java.io.*;
import java.util.*;

public class Main {
	static int n, cnt;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] map;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					Stack<int[]> stack = new Stack<>();
					stack.push(new int[] {i, j});
					cnt = 1;
					map[i][j] = -1;
					while(!stack.isEmpty()) {
						int[] cur = stack.pop();
						int cy = cur[0];
						int cx = cur[1];
						
						for (int[] d : dir) {
							int ny = cy + d[0];
							int nx = cx + d[1];
							
							if (ny >= 0 && ny < n && nx >= 0 && nx < n && map[ny][nx] == 1) {
								cnt++;
								map[ny][nx] = -1;
								stack.push(new int[] {ny, nx});
							}
						}
					}
					
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (int i : list) {
			System.out.println(i);
		}
	}
}
