import java.io.*;
import java.util.*;

public class Main {
	static int n, result;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		result = 0;
		
		for (int i = 0; i < n; i++) {
			int left = 0, right = n - 1;
			while (left < right) {
				if (left == i) {
					left++;
				}
				if (right == i) {
					right--;
				}
				if (left == right) break;
				if (arr[left] + arr[right] == arr[i]) {
//					System.out.println(arr[i] + " : "+ left + "  " + right);
					result++;
					break;
				} else if (arr[left] + arr[right] < arr[i]) left++;
				else right--;
			}
		}
		
		System.out.println(result);
	}
}
