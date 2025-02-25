import java.io.*;
import java.util.*;

public class Main {
	static int s, p;
	static int[][] taste;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		String[] str = br.readLine().split("");
		
		int[] arr = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 0);
		map.put("C", 0);
		map.put("G", 0);
		map.put("T", 0);
		
		int ans = 0;
		
		for (int i = 0; i < p; i++) {
			map.put(str[i], map.get(str[i]) + 1);
		}
		
		if (map.get("A") >= arr[0] && map.get("C") >= arr[1] && map.get("G") >= arr[2] && map.get("T") >= arr[3]) ans++;
		
		for (int i = p; i < s; i++) {
			map.put(str[i-p], map.get(str[i-p]) - 1);
			map.put(str[i], map.get(str[i]) + 1);
			if (map.get("A") >= arr[0] && map.get("C") >= arr[1] && map.get("G") >= arr[2] && map.get("T") >= arr[3]) ans++;
		}
		
		System.out.println(ans);
	}
}
