import java.util.*;

class dfs {
    private int V;

    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked")
    dfs(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
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

        dfs g = new dfs(V);

        int v;
        int w;

        for (int i = 0; i < E; ++i) {
            v = scan.nextInt();
            w = scan.nextInt();
            g.addEdge(v, w);
        }
        scan.close();
        long startTime = System.nanoTime();
        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
        g.DFS(source);
        System.out.println();
        long elapsedTime = System.nanoTime() - startTime;

        double seconds = (double) elapsedTime / 1_000_000_000.0;
        System.out.println("\nExecution Time is: " + seconds);

    }
}
