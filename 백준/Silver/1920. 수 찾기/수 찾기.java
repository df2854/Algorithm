import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr, array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] input1 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input1[i]);
		}
		
		m = Integer.parseInt(br.readLine());
		array = new int[m];
		String[] input2 = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			array[i] = Integer.parseInt(input2[i]);
		}
		
		Arrays.sort(arr);
		
		int left = 0, right = n - 1;
		
		for (int i = 0; i < m; i++) {
			bw.write(binarySearch(array[i], left, right) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int binarySearch(int key, int left, int right) {
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (key == arr[mid]) {
				return 1;
			} else if (key < arr[mid]) {
				right = mid - 1;
			} else if (key > arr[mid]) {
				left = mid + 1;
			}
		}
		
		return 0;
	}
}