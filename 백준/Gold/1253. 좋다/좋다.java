/*
 접근 방법 : 좋은 수는 어떤 수가 다른 수 두 개의 합이므로 투 포인터로
 */

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
			int target = arr[i];
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				}
				if (right == i) {
					right--;
					continue;
				}
				
				int sum = arr[left] + arr[right];

				if (sum == target) {
					result++;
					break;
				} else if (sum < target) left++;
				else right--;
			}
		}
		
		System.out.println(result);
	}
}
