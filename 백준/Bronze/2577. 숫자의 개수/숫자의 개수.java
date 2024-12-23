import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        int[] result = new int[10];
        int num = a * b * c;
        String[] str = String.valueOf(num).split("");
        for (int i = 0; i < str.length; i++) {
        	result[Integer.parseInt(str[i])] += 1;
        }
        for (int i = 0; i <= 9; i++) {
        	bw.write(result[i] + "\n");
        }
        bw.close();
	}
}