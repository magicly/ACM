package cn.edu.pku.acm;

import java.util.Scanner;

public class Main_1105 {
	private static boolean debug = false;
	private static void debugSay(String s) {
		if (debug) {
			System.out.println(s);
		}
	}
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int nn = 0;
		while (n != 0) {
			nn++;
			String tmp;
			int[] orderMap = new int[n + 1];
			int[] values = new int[(int)Math.pow(2, n)];
			for (int i = 0; i < n; i++) {
				tmp = in.next();
				orderMap[new Integer(tmp.substring(1))] = i + 1;
			}
			for (int order : orderMap) {
				debugSay(order + "");
			}
			
			tmp = in.next();
			for (int i = 0; i < tmp.length(); i++) {
				values[i] = new Integer(tmp.substring(i, i + 1));
			}
			for(int value : values) {
				debugSay(value + "");
			}

			int m = in.nextInt();
			int[] vva = new int[n + 1];
			System.out.println("S-Tree #" + nn + ":");
			for (int i = 0; i < m; i++) {
				int k = 0;
				tmp = in.next();
				debugSay("tmp: " + tmp);
				for (int j = 0; j < tmp.length(); j++) {
					vva[orderMap[j + 1]] = new Integer(tmp.substring(j, j + 1));
				}
				for (int v : vva) {
					debugSay(v + "");
				}
				for (int j = 0; j < n; j++) {
					k = (2 * k + 1) + vva[j + 1];
					debugSay("k: " + k);
				}
				k -= (int)Math.pow(2, n) - 1;
				debugSay("k: " + k);
				System.out.print(values[k]);
			}
			System.out.println("\n");
			n = in.nextInt();
		}
	}

}
