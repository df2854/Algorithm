import java.io.*;
import java.util.*;

public class Main {
	static int n, m, result;
	static List<Integer> list;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();	
		comb(0, 1);
		
		System.out.println(sb);
	}
	private static void comb(int idx, int start) {
		if (idx == m) {
			for (int num : list) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= n; i++) {
			list.add(i);
			comb(idx + 1, i);
			list.remove(list.size() - 1);
		}
	}
}