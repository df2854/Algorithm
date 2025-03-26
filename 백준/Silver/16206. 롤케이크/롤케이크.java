/*
 * 10의 배수인 것부터 잘라야함 -> 길이가 짧은 것부터 잘라야함
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m, count;
	static int[] arr;
	static List<Integer> ten, nonTen;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		count = 0;
		ten = new ArrayList<>();
		nonTen = new ArrayList<>();
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 10) count++;
			else if (arr[i] % 10 == 0) {
				ten.add(arr[i]);
			} else {
				nonTen.add(arr[i]);
			}
		}
		
		Collections.sort(ten);
		
		for (int num : ten) {
			int cut = (num / 10) - 1;
			if (m >= cut) {
				m -= cut;
				count += num / 10;
			} else {
				count += m;
				m = 0;
				break;
			}
		}
		
		Collections.sort(nonTen);
		
		for (int num : nonTen) {
			int cut = num / 10;
			if (m >= cut) {
				m -= cut;
				count += cut;
			} else {
				count += m;
				m = 0;
				break;
			}
		}
	
		System.out.println(count);
	}
}
