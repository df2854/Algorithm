import java.io.*;
import java.util.*;

public class Main {
	static int L, C, result;
	static String[] arr;
	static String str = "aeiou";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new String[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}

		Arrays.sort(arr);

		dfs(0, 0, 0, 0, new StringBuilder());
	}
	private static void dfs(int idx, int start, int consonantCount, int vowelCount, StringBuilder sb) {
		if (idx == L) {
			if (consonantCount >= 2 && vowelCount >= 1) {
				System.out.println(sb);
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			sb.append(arr[i]);
			if (str.contains(arr[i])) {
				dfs(idx + 1, i + 1, consonantCount, vowelCount + 1, sb);
			} else {
				dfs(idx + 1, i + 1, consonantCount + 1, vowelCount, sb);
			}
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}