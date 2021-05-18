import java.util.*;

class TravellingSalesman {

    static int travllingSalesmanProblem(int graph[][], int s, int V) {
        ArrayList<Integer> vertex = new ArrayList<Integer>();

        for (int i = 0; i < V; i++)
            if (i != s)
                vertex.add(i);

        int total_min_dist = 0;
        int current_node = s;
        int min_distance;
        int node = 0;
        System.out.print("\nPath is: ");
        while (!vertex.isEmpty()) {
            min_distance = 99999999;
            System.out.print(current_node + " ");

            for (int i : vertex) {
                if (min_distance > graph[current_node][i]) {
                    node = i;
                    min_distance = graph[current_node][i];
                }
            }
            total_min_dist += min_distance;

            current_node = node;
            vertex.remove(vertex.indexOf(current_node));
        }
        System.out.print(current_node + " " + s);
        total_min_dist += graph[current_node][s];

        return total_min_dist;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the source vertex: ");
        int source = scan.nextInt();
        System.out.print("Enter the no of vertex: ");
        int V = scan.nextInt();

        System.out.print("Enter the matrix: \n");

        int graph[][] = new int[V][V];

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                graph[i][j] = scan.nextInt();
            }
        }
        scan.close();
        long startTime = System.nanoTime();
        System.out.println("\nMinimum path distance is: " + travllingSalesmanProblem(graph, source, V));
        long elapsedTime = System.nanoTime() - startTime;

        double seconds = (double) elapsedTime / 1_000_000_000.0;
        System.out.println("\nExecution Time : " + seconds);
    }
}
