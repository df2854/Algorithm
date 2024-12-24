import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt( st.nextToken());
        int m = Integer.parseInt( st.nextToken());
        String[] input = br.readLine().split(" ");
        int[] numArr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < n-2; i++) {
        	for (int j = i+1; j < n-1; j++) {
        		for (int k = j+1; k < n; k++) {
        			int sum = numArr[i] + numArr[j] + numArr[k];
        			if (0 <= m - sum && min > m - sum) {
        				min = m - sum;
        				result = sum;
        			}
        		}
        	}
        }
        
        bw.write(result + "\n");
        bw.close();
	}
}