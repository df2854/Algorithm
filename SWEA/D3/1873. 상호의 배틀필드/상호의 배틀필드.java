import java.io.*;
import java.util.*;

class Solution {
	static int tc, h, w, n, cy, cx;
	static String[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new String[h][w];
			String[] input;
			for (int i = 0; i < h; i++) {
				input = br.readLine().split("");
				for (int j = 0; j < w; j++) {
					map[i][j] = input[j];
					if (map[i][j].equals("<") || map[i][j].equals(">") || map[i][j].equals("^") || map[i][j].equals("v")) {
						cy = i;
						cx = j;
					}
				}
			}
			
			n = Integer.parseInt(br.readLine());
			input = br.readLine().split("");
			for (int i = 0; i < n; i++) {
				simul(input[i]);
			}
			
			sb = new StringBuilder();
			sb.append("#" + t + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			bw.write(sb + "");
		}
		bw.flush();
		bw.close();
	}
	private static void simul(String command) {
		if (command.equals("S")) {
			shoot(cy, cx);
		} else {
			move(command, cy, cx);
		}
	}
	
	private static void move(String command, int y, int x) {
		if (command.equals("U")) {
			if (isMove(y-1, x) && map[y-1][x].equals(".")) {
				map[y-1][x] = "^";
				map[y][x] = ".";
				cy = y - 1;
				cx = x;
			} else map[y][x] = "^";
		} else if (command.equals("D")) {
			if (isMove(y+1, x) && map[y+1][x].equals(".")) {
				map[y+1][x] = "v";
				map[y][x] = ".";
				cy = y + 1;
				cx = x;
			} else map[y][x] = "v";
		} else if (command.equals("R")) {
			if (isMove(y, x + 1) && map[y][x + 1].equals(".")) {
				map[y][x+1] = ">";
				map[y][x] = ".";
				cy = y;
				cx = x + 1;
			} else map[y][x] = ">";
		} else if (command.equals("L")) {
			if (isMove(y, x - 1) && map[y][x - 1].equals(".")) {
				map[y][x-1] = "<";
				map[y][x] = ".";
				cy = y;
				cx = x - 1;
			} else map[y][x] = "<";
		}
	}
	private static void shoot(int y, int x) {
		String current = map[y][x];
		
		if (current.equals("^")) {
			while (y >= 0) {
				if (map[y][x].equals("#")) break;
				
				if (map[y][x].equals("*")) {
					map[y][x] = ".";
					break;
				}
				y--;
			}
		} else if (current.equals("v")) {
			while (y < h) {
				if (map[y][x].equals("#")) break;
				
				if (map[y][x].equals("*")) {
					map[y][x] = ".";
					break;
				}
				y++;
			}
		} else if (current.equals(">")) {
			while (x < w) {
				if (map[y][x].equals("#")) break;
				
				if (map[y][x].equals("*")) {
					map[y][x] = ".";
					break;
				}
				x++;
			}
		} else if (current.equals("<")) {
			while (x >= 0) {
				if (map[y][x].equals("#")) break;
				
				if (map[y][x].equals("*")) {
					map[y][x] = ".";
					break;
				}
				x--;
			}
		}
	}
	private static boolean isMove (int y, int x) {
		if (y >= 0 && y < h && x >= 0 && x < w) return true;
		return false;
	}
}
