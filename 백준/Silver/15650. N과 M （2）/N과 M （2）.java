import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new int[m];
		
		comb(0, 1);
	}
	private static void comb(int idx, int start) {
		if (idx == m) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= n; i++) {
			result[idx] = i;
			comb(idx + 1, i + 1);
		}
	}
}
