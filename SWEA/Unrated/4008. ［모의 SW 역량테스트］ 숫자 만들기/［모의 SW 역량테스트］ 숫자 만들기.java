import java.io.*;
import java.util.*;

public class Solution {
	static int n, result, max, min;
	static int[] nums, operator, opArr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			operator = new int[4];
			nums = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				if (operator[i] >= 1) {
					while(operator[i] --> 0) list.add(i);
				}
			}
			opArr = new int[n-1];
			for (int i = 0; i < n-1; i++) {
				opArr[i] = list.get(i);
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			do {
				calc();
			} while(np());
			
			System.out.println("#" + t + " " + (max - min));
		}
	}
	
	public static boolean np() {
		int i = n - 2;
		while (i > 0 && opArr[i-1] >= opArr[i]) --i;
		
		if (i == 0) return false;
		
		int j = n - 2;
		while (opArr[i - 1] >= opArr[j]) --j;
		
		swap(i-1, j);
		
		int k = n - 2;
		while (i < k) swap(i++, k--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int tmp = opArr[i];
		opArr[i] = opArr[j];
		opArr[j] = tmp;
	}
	
	public static void calc() {
		int sum = nums[0];
		for (int i = 1; i < n; i++) {
			if (opArr[i-1] == 0) {
				sum += nums[i];
			} else if (opArr[i-1] == 1) {
				sum -= nums[i];
			} else if (opArr[i-1] == 2) {
				sum *= nums[i];
			} else if (opArr[i-1] == 3) {
				sum /= nums[i];
			}
		}
		
		min = Math.min(min, sum);
		max = Math.max(max, sum);
	}
}
