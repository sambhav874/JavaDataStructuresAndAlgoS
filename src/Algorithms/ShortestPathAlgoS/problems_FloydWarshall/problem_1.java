package Algorithms.ShortestPathAlgoS.problems_FloydWarshall;

//You are given a map of cities connected by roads.
// Each road has a certain travel time associated with it.
// Write a Java program that uses the Floyd-Warshall algorithm to find the shortest travel time between all pairs of cities.

import Algorithms.ShortestPathAlgoS.AdjacencyMatrixGraph;

public class problem_1 {
    public static void main(String[] args) {
        int[][] travelTimes = {
                {0, 2, 4, 0, 0, 0},
                {0, 0, 1, 7, 0, 0},
                {0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 1, 5},
                {0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0}
        };

        int numCities = travelTimes.length;

        int[][] shortestTimes = findShortestTravelTime(travelTimes, numCities);

        // Print the shortest travel times between all pairs of cities
        System.out.println("Shortest Travel Times:");
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                System.out.print(shortestTimes[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] findShortestTravelTime(int[][] travelTimes, int numCities) {
        int[][] shortestTimes = new int[numCities][numCities];

        // Initialize the shortest times matrix with the given travel times
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                shortestTimes[i][j] = travelTimes[i][j];
            }
        }

        // Apply the Floyd-Warshall algorithm
        for (int k = 0; k < numCities; k++) {
            for (int i = 0; i < numCities; i++) {
                for (int j = 0; j < numCities; j++) {
                    if (shortestTimes[i][k] != 0 && shortestTimes[k][j] != 0 &&
                            (shortestTimes[i][j] == 0 || shortestTimes[i][k] + shortestTimes[k][j] < shortestTimes[i][j])) {
                        shortestTimes[i][j] = shortestTimes[i][k] + shortestTimes[k][j];
                    }
                }
            }
        }

        return shortestTimes;
    }
}
