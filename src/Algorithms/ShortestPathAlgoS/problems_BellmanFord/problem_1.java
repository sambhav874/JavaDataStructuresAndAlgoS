package Algorithms.ShortestPathAlgoS.problems_BellmanFord;

import java.util.Arrays;

public class problem_1 {
    // You are designing a package delivery system. Given a list of locations and the distances between them, find the minimum distance for a package to travel from the source location to the destination location.
    // Implement the 'minimumDistance' function to calculate the minimum distance from the source location to the destination location using the Bellman-Ford algorithm.
    // Assume that the locations are represented as nodes in a graph, and the distances between them are represented as weighted edges.

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
                {0, 2, 4, 0},
                {0, 0, 1, 7},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        //0 -> 1 (weight 2)
        //0 -> 2 (weight 4)
        //1 -> 2 (weight 1)
        //1 -> 3 (weight 7)


        int source = 0;
        int destination = 2;

        int minimumDistance = minimumDistance(distances, source, destination);
        System.out.println("Minimum distance from source to destination: " + minimumDistance);
    }
}
