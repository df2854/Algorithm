import java.io.*;
import java.util.*;

public class Main {
	static int sum;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (arr[i] + arr[j]) == 100) {
					for(int k = 0; k < 9; k++) {
						if (arr[k] == arr[i] || arr[k] == arr[j]) continue;
						System.out.println(arr[k]);
					}
				}
			}
		}
	}
}
