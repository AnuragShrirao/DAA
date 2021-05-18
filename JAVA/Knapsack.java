import java.util.Scanner;

class Knapsack {
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
		return K[n][W];
	}

	public static void main(String args[]) {
		Scanner src = new Scanner(System.in);
		System.out.println("Enter The length of values");
		int leng = src.nextInt();
		int val[] = new int[leng];
		int wt[] = new int[leng];
		System.out.println("Enter values");
		for (int i = 0; i < leng; i++) {
			val[i] = src.nextInt();
		}
		System.out.println("Enter wt for corresponding values");
		for (int i = 0; i < leng; i++) {
			wt[i] = src.nextInt();
		}
		System.out.println("Enter capacity of knapsack ");
		int W = src.nextInt();
		src.close();
		long startTime = System.nanoTime();
		System.out.println("The knapsack is :" + knapSack(W, wt, val, leng));
		long endTime = System.nanoTime();
		double totalTime = endTime - startTime;
		System.out.println("\nExecution time : " + totalTime / 1000000 + " mili seconds ");
	}
}
