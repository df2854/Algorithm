import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		int x = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			if (sum == x) {
				ans++;
				left++;
				right--;
			} else if (sum < x) {
				left++;
			} else {
				right--;
			}
		}
		
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
	}
}