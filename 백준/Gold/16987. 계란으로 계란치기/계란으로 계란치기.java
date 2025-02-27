import java.io.*;
import java.util.*;

public class Main {
	static int n, arr[][], match[][], cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		cnt = 0;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		if (n == 1) {
			System.out.println(0);
			return;
		}
			
		dfs(0, 0);
		
		sb.append(cnt);
		
		System.out.println(sb);
	}
	private static void dfs(int depth, int broken) {
		if (depth == n) {
			cnt = Math.max(cnt, broken);
			return;
		}
		
		if (arr[depth][0] <= 0) {
            dfs(depth + 1, broken);
            return;
        }
		
		 boolean isBroken = false;
		
		 for (int i = 0; i < n; i++) {
	            if (i == depth || arr[i][0] <= 0) continue;

	            arr[depth][0] -= arr[i][1];
	            arr[i][0] -= arr[depth][1];

	            int newBroken = broken + (arr[depth][0] <= 0 ? 1 : 0) + (arr[i][0] <= 0 ? 1 : 0);
	            isBroken = true;

	            dfs(depth + 1, newBroken);

	            arr[depth][0] += arr[i][1];
	            arr[i][0] += arr[depth][1];
	        }

	        if (!isBroken) {
	            dfs(depth + 1, broken);
	        }
	}
}