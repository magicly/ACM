package cn.edu.pku.acm;

import java.util.Scanner;

public class Main_1207 {
	private static int cycle(int n) {
		int count = 1;
		while (n != 1) {
			if (n % 2 == 1) {
				n = 3 * n + 1;
				count++;
			} else if (n % 2 == 0) {
				n /= 2;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i, j;
		while (in.hasNextInt()) {
			i = in.nextInt();
			j = in.nextInt();
			int max = 0;
			for (int k = i; k < j; k++) {
				int t = cycle(k);
				if (t > max) {
					max = t;
				}
			}
			System.out.println(i + " " + j + " " + max);
		}
	}
}
