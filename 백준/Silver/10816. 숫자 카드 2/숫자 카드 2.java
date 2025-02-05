import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] card = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(input[i]);
		}

		int m = Integer.parseInt(br.readLine());
		int[] target = new int[n];
		input = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(input[i]);
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(card[i])) {
				map.put(card[i], map.get(card[i]) + 1);
			} else {
				map.put(card[i], 1);
			}
		}

		for (int i = 0; i < m; i++) {
			if (map.containsKey(target[i])) {
				sb.append(map.get(target[i])).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}