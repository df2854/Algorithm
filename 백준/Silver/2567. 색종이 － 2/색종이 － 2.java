import java.io.*;
import java.util.*;

public class Main {
	static int n, result, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		result = 0;
		
		map = new int[101][101];

		for (int t = 0; t < n; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int d[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (map[i][j] == 1) {
					for (int dir = 0; dir < 4; dir++) {
						int ny = i + d[dir][0];
						int nx = j + d[dir][1];
						
						if ( ny < 0 || ny > 100 || nx < 0 || nx > 100 || map[ny][nx] == 0) result++;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}