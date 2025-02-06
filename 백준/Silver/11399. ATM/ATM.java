import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int result = 0;

        for (int i = 0; i < n; i++) {
            int temp = arr[0];
            for (int j = 1; j <= i; j++) {
                temp += arr[j];
            }
            result += temp;
        }

        System.out.println(result);
    }
}
