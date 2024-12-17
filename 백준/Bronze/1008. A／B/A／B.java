import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String[] input = br.readLine().split(" ");
        double a = Double.valueOf(input[0]);
        int b = Integer.parseInt(input[1]);
        System.out.println(a / b);
	}
}