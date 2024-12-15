import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxVal = -1, y = 0, x = 0;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int val = sc.nextInt();
				if (val > maxVal) {
					maxVal = val;
					y = i;
					x = j;
				}
			}
		}
		System.out.println(maxVal);
		System.out.println(y + " " + x);
	}
}