package cn.edu.pku.acm;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main_1840 {

	static int method_1(int a1, int a2, int a3, int a4, int a5) {
		int x1, x2, x3, x4, x5;
		int count = 0;
		int t1, t2, t3, t4, t5;
		for (x1 = -50; x1 <= 50; x1++) {
			if (0 == x1) {
				continue;
			}
			for (x2 = -50; x2 <= 50; x2++) {
				if (0 == x2) {
					continue;
				}
				for (x3 = -50; x3 <= 50; x3++) {
					if (0 == x3) {
						continue;
					}
					for (x4 = -50; x4 <= 50; x4++) {
						if (0 == x4) {
							continue;
						}
						t4 = a1 * x1 * x1 * x1 + a2 * x2 * x2 * x2 + a3 * x3 * x3 * x3 + a4 * x4 * x4 * x4;
						if (t4 % a5 != 0) {
							continue;
						}
						for (x5 = -50; x5 <= 50; x5++) {
							if (0 == x5) {
								continue;
							}
							t5 = t4 + a5 * x5 * x5 * x5;
							if (0 == t5) {
								// System.out.println("x1:" + x1 + "x2: " + x2 +
								// " x3: " + x3 + " x4: " + x4 + " x5: " + x5);
								count++;
								// System.out.println(count);
							}
						}
					}
				}
			}
		}
		return count;
	}

	static int method_2(int a1, int a2, int a3, int a4, int a5) {
		int count = 0;
		int[] cubes = new int[101];
		for (int i = -50; i <= 50; i++) {
			cubes[i + 50] = i * i * i;
		}
		int t4, t5;
		for (int x1 = 0; x1 < 101; x1++) {
			if (50 == x1) {
				continue;
			}
			for (int x2 = 0; x2 < 101; x2++) {
				if (50 == x2) {
					continue;
				}
				for (int x3 = 0; x3 < 101; x3++) {
					if (50 == x3) {
						continue;
					}
					for (int x4 = 0; x4 < 101; x4++) {
						if (50 == x4) {
							continue;
						}
						t4 = a1 * cubes[x1] + a2 * cubes[x2] + a3 * cubes[x3] + a4 * cubes[x4];
						if (t4 % a5 != 0) {
							continue;
						}
						for (int x5 = 0; x5 < 101; x5++) {
							if (50 == x5) {
								continue;
							}
							t5 = t4 + a5 * cubes[x5];
							if (0 == t5) {
								count++;
							}
						}
					}
				}
			}
		}

		return count;
	}

	/**
	 * 本次操作共耗时235ms 还是很快的啊 靠
	 * 
	 * @param a1
	 * @param a2
	 * @param a3
	 * @param a4
	 * @param a5
	 */
	public static int calQuestions(int a1, int a2, int a3, int a4, int a5) {
		long first = System.currentTimeMillis();

		int bigsqure[] = new int[100]; // 存立方数字的
		int left[] = new int[10000]; // 存左边结果的
		int right[] = new int[1000000]; // 保存右边结果的
		int left_k = 0; // 保存左边数字下标的
		int right_k = 0; // 保存右边数字下标的
		int m = 0;
		for (int x = -50; x <= 50; x++) {
			if (x == 0)
				continue; // 为了删除掉0 不然会多出来200个解
			bigsqure[m++] = x * x * x; // 把这个立方值存起来，以后好用。
		}

		// 算出左边值
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				left[left_k] = -(bigsqure[i] * a1 + bigsqure[j] * a2);
				left_k++;
			}
		}

		// 算右边值
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					right[right_k] = bigsqure[i] * a3 + bigsqure[j] * a4 + bigsqure[k] * a5;
					right_k++;
				}
			}
		}
		// for (int i = 0; i < left.length; i++) {
		// System.out.println(left[i]);
		// }
		// 排序先
		// QuickSort3.quicksort(left, 0, left.length-1);
		Arrays.sort(left);
		// QuickSort3.quicksort(right, 0, right.length-1);
		Arrays.sort(right);

		// 判断
		int i = 0;
		int j = 0;
		int k = 0;
		int answer = 0;
		// System.out.println(left_k+","+right_k);
		while (i < left_k && j < right_k) {
			if (left[i] < right[j]) {
				i++;
			} else if (left[i] > right[j]) {
				j++;
			} else {
				k = i;
				while (left[k++] == right[j])
					answer++;
				j++;
			}
		}
		// System.out.println("有"+answer+"个这样的解。");

		long end = System.currentTimeMillis();
		// System.out.println("=================================================");
		// System.out.println("本次操作共耗时"+(end-first)+"ms");
		return answer;
	}

	/**
	 * 本次操作共耗时109ms
	 * 
	 * @param a1
	 * @param a2
	 * @param a3
	 * @param a4
	 * @param a5
	 */
	public static int hashQuestions(int a1, int a2, int a3, int a4, int a5) {
		long first = System.currentTimeMillis();

		char hash[] = new char[25000010]; // hash存储

		int bigsqure[] = new int[100]; // 存立方数字的
		int pos = 0;
		int m = 0;
		for (int x = -50; x <= 50; x++) {
			if (x == 0)
				continue; // 为了删除掉0 不然会多出来200个解
			bigsqure[m++] = x * x * x; // 把这个立方值存起来，以后好用。
		}

		// 算出左边值
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				pos = -(bigsqure[i] * a1 + bigsqure[j] * a2);

				hash[pos + 12500000]++; // 这个值为1了!

				// 这块算结束之后 在hash的这个大数组里边 凡是有左边结果的元素 值都为1了。
			}
		}

		int answer = 0;
		// 算右边值
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					pos = bigsqure[i] * a3 + bigsqure[j] * a4 + bigsqure[k] * a5;
					if (pos > 12500000 || pos < -12500000)
						continue;
					answer += hash[pos + 12500000];

					// 这个相加的道理即是，如果右边的值没有和左边重叠 那么这个值是0。
					// 如果重叠了，在左边的时候， 已经把他设为1了，那么 把所有的重叠的“1”累加起来
					// 即是结果。
				}
			}
		}

		// System.out.println("有"+answer+"个这样的解。");

		long end = System.currentTimeMillis();
		// System.out.println("=================================================");
		// System.out.println("本次操作共耗时"+(end-first)+"ms");
		return answer;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1, a2, a3, a4, a5;
		Scanner in = new Scanner(System.in);
		a1 = in.nextInt();
		a2 = in.nextInt();
		a3 = in.nextInt();
		a4 = in.nextInt();
		a5 = in.nextInt();
		int count = 0;
		Date start, end;
		// start = new Date();
		// // count = method_1(a1, a2, a3, a4, a5);
		// end = new Date();
		// // System.out.println(end.getTime() - start.getTime());
		// // System.out.println(count);
		//
		// Date start_2 = new Date();
		// count = method_2(a1, a2, a3, a4, a5);
		// end = new Date();
		// // System.out.println(end.getTime() - start_2.getTime());
		// System.out.println(count);

		count = hashQuestions(a1, a2, a3, a4, a5);
		System.out.println(count);

		// count = calQuestions(a1, a2, a3, a4, a5);
		// System.out.println(count);
	}
}
