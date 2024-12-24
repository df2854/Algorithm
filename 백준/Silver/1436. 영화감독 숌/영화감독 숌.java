import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int n = Integer.parseInt(br.readLine());
        int num = 666;
        int cnt = 1;
        
        while(cnt != n) {
        	num++;
        	if (String.valueOf(num).contains("666")) {
        		cnt++;
        	}
        }
        
        bw.write(num + "\n");
        bw.flush();
        bw.close();
	}
}