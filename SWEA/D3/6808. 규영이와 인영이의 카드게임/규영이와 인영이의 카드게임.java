import java.util.*;
import java.io.*;

class Solution {
	static int tc, win, lose;
	static int[] gyu, in;
	static boolean[] visited;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			gyu = new int[9];
			in = new int[9];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[9];
			list = new ArrayList<>();
			
			for (int n = 1; n <= 18; n++) {
				list.add(n);
			}
			
			for (int i = 0; i < 9; i++) {
				list.remove(Integer.valueOf(gyu[i]));
			}
			
			win = 0;
			lose = 0;
			
			dfs(0);
			
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}
	private static void dfs(int idx) {
		if (idx == 9) {
			check(in);
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visited[i]) continue;
			
			in[idx] = list.get(i);
			visited[i] = true;
			
			dfs(idx + 1);
			
			visited[i] = false;
		}
	}
	private static void check(int[] arr) {
		int gyuScore = 0;
		int inScore = 0;
		for (int i = 0; i < 9; i++) {
			if (arr[i] > gyu[i]) inScore += arr[i] + gyu[i];
			else if (arr[i] < gyu[i]) gyuScore += arr[i] + gyu[i];
		}
		
		if (gyuScore > inScore) {
			win++;
		} else if (gyuScore < inScore) {
			lose++;
		}
		
		return;
	}
}
