import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		int k = (int) Math.round(n * 0.15);
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		for (int i = k; i < n - k; i++) {
			sum += arr[i];
		}
		
		int size = n - 2 * k;

		int avg = (int) Math.round(1.0 * sum / size);
		
		System.out.println(avg);
	}
}
