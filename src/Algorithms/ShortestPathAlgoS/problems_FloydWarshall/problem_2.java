package Algorithms.ShortestPathAlgoS.problems_FloydWarshall;

//You are managing a network of routers that are connected to each other.
// Each router has a certain latency associated with it, representing the time taken for data to travel from one router to another.
// Write a Java program that uses the Floyd-Warshall algorithm to find the minimum latency between all pairs of routers in the network.


public class problem_2 {
    public static void main(String[] args) {
        int[][] latencies = {
                {0, 2, 4, 0, 0, 0},
                {0, 0, 1, 7, 0, 0},
                {0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 1, 5},
                {0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0}
        };

        int numRouters = latencies.length;

        int[][] shortestLatencies = findMinimumLatency(latencies, numRouters);

        // Print the minimum latencies between all pairs of routers
        System.out.println("Minimum Latencies:");
        for (int i = 0; i < numRouters; i++) {
            for (int j = 0; j < numRouters; j++) {
                System.out.print(shortestLatencies[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] findMinimumLatency(int[][] latencies, int numRouters) {
        int[][] shortestLatencies = new int[numRouters][numRouters];

        // Initialize the shortest latencies matrix with the given latencies
        for (int i = 0; i < numRouters; i++) {
            for (int j = 0; j < numRouters; j++) {
                shortestLatencies[i][j] = latencies[i][j];
            }
        }

        // Apply the Floyd-Warshall algorithm
        for (int k = 0; k < numRouters; k++) {
            for (int i = 0; i < numRouters; i++) {
                for (int j = 0; j < numRouters; j++) {
                    if (shortestLatencies[i][k] != 0 && shortestLatencies[k][j] != 0 &&
                            (shortestLatencies[i][j] == 0 || shortestLatencies[i][k] + shortestLatencies[k][j] < shortestLatencies[i][j])) {
                        shortestLatencies[i][j] = shortestLatencies[i][k] + shortestLatencies[k][j];
                    }
                }
            }
        }

        return shortestLatencies;
    }
}

