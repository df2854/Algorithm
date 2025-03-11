import java.io.*;
import java.util.*;

public class Main {
	static int t, n, max, result;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
			
			max = arr[0][1];
			result = 1;
			
			for (int i = 1; i < n; i++) {
				if (arr[i][1] < max) {
					max = arr[i][1];
					result++;
				}
			}
			
			System.out.println(result);
		}
	}
}