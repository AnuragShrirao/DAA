import java.util.*;

class dijkstra {

	int minDistance(int dist[], Boolean sptSet[], int V) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	void printSolution(int dist[], int V) {
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	void dijkstraFun(int graph[][], int src, int V) {
		int dist[] = new int[V];

		Boolean sptSet[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet, V);

			sptSet[u] = true;

			for (int v = 0; v < V; v++)

				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		printSolution(dist, V);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the no of vertex: ");
		int n = scan.nextInt();
		System.out.println();

		System.out.print("Enter the matrix: ");

		int graph[][] = new int[n][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				graph[i][j] = scan.nextInt();
			}
		}
		scan.close();
		dijkstra t = new dijkstra();

		long startTime = System.nanoTime();
		t.dijkstraFun(graph, 0, n);
		long elapsedTime = System.nanoTime() - startTime;

		double seconds = (double) elapsedTime / 1_000_000_000.0;
		System.out.println("Execution Time : " + seconds);
	}
}