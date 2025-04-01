import java.io.*;
import java.util.*;

public class Main {
	static int n, d, k, c, count, result;
	static int[] arr, eated;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		eated = new int[d+1];
		count = 0;
		
		for (int i = 0; i < k; i++) {
			if (eated[arr[i]] == 0) {
				count++;
			}
			eated[arr[i]]++;
		}
		
		result = count;
		
		for (int i = 0; i < n; i++) {
			if (result <= count) {
				if (eated[c] == 0) {
					result = count + 1;
				} else {
					result = count;
				}
			}
			
			eated[arr[i]]--;
			if (eated[arr[i]] == 0) {
				count--;
			}
			
			if (eated[arr[(i + k) % n]] == 0) {
				count++;
			}
			eated[arr[(i + k) % n]]++;
		}
		
		System.out.println(result);
	}
}
