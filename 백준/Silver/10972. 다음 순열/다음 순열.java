import java.io.*;
import java.util.*;

public class Main {
	static int n, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		if (np(arr)) {
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
		} else if (!np(arr)) {
			System.out.println(-1);
		}
	}
	
	public static boolean np(int[] tmp) {
		int i = n - 1;
		while (i > 0 && tmp[i-1] >= tmp[i]) --i;
		
		if (i == 0) return false;
		
		int j = n - 1;
		while (tmp[i-1] >= tmp[j]) --j;
		
		int temp = tmp[i-1];
		tmp[i-1] = tmp[j];
		tmp[j] = temp;
		
		int k = n -1;
		while (i < k) {
			temp = tmp[i];
			tmp[i] = tmp[k];
			tmp[k] = temp;
			i++;
			k--;
		}
		
		return true;
	}
}