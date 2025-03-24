import java.io.*;
import java.util.*;

public class Main {
	static int n, m, minCount, maxSong;
	static long[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String song = st.nextToken();
			for (int j = 0; j < song.length(); j++) {
				if (song.charAt(j) == 'Y') {
					arr[i] |= (1L << (m-j-1));
				}
			}
		}
		
		minCount = Integer.MAX_VALUE;
		maxSong = 0;
		
		dfs(0, 0, 0);
		
		if (minCount == 0) {
			System.out.println(-1);
		} else {
			System.out.println(minCount);
		}
	}
	private static void dfs(int idx, int cnt, long songBit) {
		if (idx == n) {
			int songCount = Long.bitCount(songBit);
			
			if (songCount > maxSong) {
				maxSong = songCount;
				minCount = cnt;
			} else if (songCount == maxSong) {
				minCount = Math.min(minCount, cnt);
			}
			return;
		}
		
		dfs(idx + 1, cnt + 1, songBit | arr[idx]);
		dfs(idx + 1, cnt, songBit);
	}
}
