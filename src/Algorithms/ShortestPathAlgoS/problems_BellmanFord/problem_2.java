package Algorithms.ShortestPathAlgoS.problems_BellmanFord;

import java.util.Arrays;

public class problem_2 {
    // You are planning a road trip across multiple cities. Given a list of cities and the distances between them, determine if there is a negative cycle in the road network.
    // Implement the 'hasNegativeCycle' function to check if there is a negative cycle in the road network using the Bellman-Ford algorithm.
    // Assume that the cities are represented as nodes in a graph, and the distances between them are represented as weighted edges.

    public static boolean hasNegativeCycle(int[][] distances) {
        int numCities = distances.length;
        int[] distance = new int[numCities];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // Relax edges repeatedly
        for (int i = 1; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                for (int k = 0; k < numCities; k++) {
                    if (distances[j][k] != 0 && distance[j] != Integer.MAX_VALUE && distance[j] + distances[j][k] < distance[k]) {
                        distance[k] = distance[j] + distances[j][k];
                    }
                }
            }
        }

        // Check for negative cycles
        for (int j = 0; j < numCities; j++) {
            for (int k = 0; k < numCities; k++) {
                if (distances[j][k] != 0 && distance[j] != Integer.MAX_VALUE && distance[j] + distances[j][k] < distance[k]) {
                    return true; // Negative cycle found
                }
            }
        }

        return false; // No negative cycle found
    }

    public static int minimumDistance(int[][] distances, int source, int destination) {
        int numLocations = distances.length;
        int[] distance = new int[numLocations];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax edges repeatedly
        for (int i = 1; i < numLocations - 1; i++) {
            for (int j = 0; j < numLocations; j++) {
                for (int k = 0; k < numLocations; k++) {
                    if (distances[j][k] != 0 && distance[j] != Integer.MAX_VALUE && distance[j] + distances[j][k] < distance[k]) {
                        distance[k] = distance[j] + distances[j][k];
                    }
                }
            }
        }

        return distance[destination];
    }

    public static void main(String[] args) {
        int[][] distances = {
                {0, 1, 0},
                {0, 0, -2},
                {4, 0, 0}
        };

        int source = 0 ;
        int destination = 2;

        int minimumDistance = minimumDistance(distances, source, destination);
        System.out.println("Minimum distance from source to destination: " + minimumDistance);

        boolean hasNegativeCycle = hasNegativeCycle(distances);
        System.out.println("Does the road network have a negative cycle? " + hasNegativeCycle);
    }
}
