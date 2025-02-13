import java.io.*;
import java.util.*;

public class Solution {
	static int d, w, k, result;
	static int[][] map;
	static int[] comb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[d][w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = Integer.MAX_VALUE;
			if (test()) {
				System.out.println("#" + t + " " + 0);
			} else {
				subset();
				System.out.println("#" + t + " " + result);
			}
		}
	}
	
	public static boolean test() {
		int cnt = 0;
		for (int i = 0; i < w; i++) {
			int left = 0;
			int right = k - 1;
			
			while (right < d) {
				Set<Integer> set = new HashSet<>();
				for (int j = left; j <= right; j++) {
					set.add(map[j][i]);
				}
				if (set.size() == 1) {
					cnt++;
					break;
				}
				left++;
				right++;
			}
			
			if (cnt - 1 != i) return false;
		}
		
		return true;
	}
	
	public static void subset() {
		for (int mask = 1; mask < (1<<d); mask++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < d; j++) {
				if ((mask & (1 << j)) != 0) {
					subset.add(j);
				}
			}
			dfs(subset, 0, 0);
		}
	}
	
	public static void dfs(List<Integer> list, int index, int cnt) {
		if (cnt >= result) return;
		
		if (index == list.size()) {
			if (test()) {
				result = Math.min(result, cnt);
			}
			return;
		}
		
		int idx = list.get(index);
		
		int[] tmp = map[idx].clone();
		
		Arrays.fill(map[idx], 0);
		dfs(list, index + 1, cnt + 1);
		
		Arrays.fill(map[idx], 1);
		dfs(list, index + 1, cnt + 1);
		
		map[idx] = tmp;
	}
}
