import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int x, y, w, h;
        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        w = Integer.parseInt(input[2]);
        h = Integer.parseInt(input[3]);
        
        int result = (w - x) < (h - y) ? (w - x) : (h - y);
        result = result > x ? x : result;
        result = result > y ? y : result;
        bw.write(result + "\n");
        bw.close();
	}
}