import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		String[][] map = new String[r][c];
		int[][] bombTime = new int[r][c];
		String[] input;
		for (int i = 0; i < r; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				map[i][j] = input[j];
				if (map[i][j].equals("O")) {
					bombTime[i][j] = 3;
				}
			}
		}
		
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};

		for (int t = 2; t <= n; t++) {
			if (t % 2 == 0) {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (map[i][j].equals(".")) {
							map[i][j] = "O";
							bombTime[i][j] = t + 3;
						}
					}
				}
			} else {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (bombTime[i][j] == t) {
							map[i][j] = ".";
							for (int d = 0; d < 4; d++) {
								int ny = i + dy[d];
								int nx = j + dx[d];
								if (ny < 0 || nx < 0|| ny >= r || nx >= c) continue;
								if (bombTime[ny][nx] != t) {
									map[ny][nx] = ".";
									bombTime[ny][nx] = 0;
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
