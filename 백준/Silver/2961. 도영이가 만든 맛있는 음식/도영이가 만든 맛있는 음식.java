import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] taste;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		taste = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int sourness = Integer.parseInt(st.nextToken());
			int bitter = Integer.parseInt(st.nextToken());
			
			taste[i][0] = sourness;
			taste[i][1] = bitter;
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int mask = 1; mask < (1 << n); mask++) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if ((mask & (1 << i)) != 0) {
					list.add(i);
				}
			}

			int sourness = 1;
			int bitter = 0;
			for (int num : list) {
				sourness *= taste[num][0];
				bitter += taste[num][1];
			}
			int diff = bitter - sourness;
			result = Math.min(result, Math.abs(diff));
		}
		
		System.out.println(result);
	}
}
