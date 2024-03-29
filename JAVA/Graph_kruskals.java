
import java.util.*;

class Graph {
	class Edge implements Comparable<Edge> {
		int src, dest, weight;

		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	};

	class subset {
		int parent, rank;
	};

	int V, E;
	Edge edge[];

	Graph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	int find(subset subsets[], int i) {
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	void KruskalMST() {
		Edge result[] = new Edge[V];
		int e = 0;
		int i = 0;
		for (i = 0; i < V; ++i)
			result[i] = new Edge();
		Arrays.sort(edge);

		subset subsets[] = new subset[V];
		for (i = 0; i < V; ++i)
			subsets[i] = new subset();

		for (int v = 0; v < V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0;
		while (e < V - 1) {
			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}

		}

		System.out.println("Following are the edges in " + "the constructed MST");
		int minimumCost = 0;
		for (i = 0; i < e; ++i) {
			System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree by Kruskal's algorithm is " + minimumCost);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Vertices");
		int V = sc.nextInt();
		System.out.println("Enter number of Edges");
		int E = sc.nextInt();
		Graph graph = new Graph(V, E);
		int i = 0;
		System.out.println("Enter source vertex, Destinaton vertex and weight of " + E + " Edges\n");
		for (i = 0; i < E; i++) {
			graph.edge[i].src = sc.nextInt();
			graph.edge[i].dest = sc.nextInt();
			graph.edge[i].weight = sc.nextInt();
		}

		long start = System.nanoTime();
		graph.KruskalMST();
		long end = System.nanoTime();
		double execution = end - start;
		System.out.println("\nExecution time: " + execution / 1000000 + " milliseconds");
	}
}