
import java.util.*;

class bfs {
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")

	bfs(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		boolean visited[] = new boolean[V];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the no of edges: ");
		int E = scan.nextInt();
		System.out.print("Enter the source vertex: ");
		int source = scan.nextInt();
		System.out.print("Enter the no of vertex: ");
		int V = scan.nextInt();

		System.out.print("Enter the matrix: \n");

		bfs g = new bfs(V);

		int v;
		int w;

		for (int i = 0; i < E; ++i) {
			v = scan.nextInt();
			w = scan.nextInt();
			g.addEdge(v, w);
		}
		scan.close();
		long startTime = System.nanoTime();
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.BFS(source);
		System.out.println();
		long elapsedTime = System.nanoTime() - startTime;

		double seconds = (double) elapsedTime / 1_000_000_000.0;
		System.out.println("\nExecution Time is: " + seconds);
	}
}