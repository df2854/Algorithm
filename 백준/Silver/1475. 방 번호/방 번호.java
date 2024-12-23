import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int roomNum = Integer.parseInt(br.readLine());
        int[] result = new int[10];
        String[] str = String.valueOf(roomNum).split("");
        for (int i = 0; i < str.length; i++) {
        	result[Integer.parseInt(str[i])] += 1;
        }
        
        int sum = result[6] + result[9];
        result[6] = (sum + 1) / 2;
        result[9] = result[6];
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
        	if (max < result[i]) {
        		max = result[i];
        	}
        }
        
        bw.write(max + "\n");
        bw.flush();
        bw.close();
	}
}