/*
접근 방법 : n보다 크고 2n보다 작거나 같은 소수 개수 구하기 -> n <= 123,456, 테스트 케이스가 여러개 -> 에라토스테네스의 체를 이용 
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean[] isPrime;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			isPrime = new boolean[2*n + 1];
			Arrays.fill(isPrime, true);
			isPrime[0] = false;
			isPrime[1] = false;
			
			for (int i = 2; i <= Math.sqrt(2*n); i++) {
				if(isPrime[i]) {
					for (int j = i * i; j <= 2*n; j += i) {
						isPrime[j] = false;
					}
				}
			}
			int count = 0;
			for (int i = n+1; i <= 2 * n; i++) {
				if (isPrime[i]) count++;
			}
			
			System.out.println(count);
		}
	}
}
