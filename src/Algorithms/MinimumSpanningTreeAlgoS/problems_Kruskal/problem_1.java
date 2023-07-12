package Algorithms.MinimumSpanningTreeAlgoS.problems_Kruskal;

import java.util.*;

import java.util.*;

import java.util.*;

public class problem_1 {
    // Question: You are designing a power distribution network for a city. Given a list of power stations and the distances between them,
    // find the minimum cost to connect all power stations together with power lines.
    // Implement Kruskal's algorithm to calculate the minimum cost of connecting all power stations.

    public static class Edge {
        private int source;
        private int destination;
        private int cost;

        public Edge(int source, int destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        /**
         * Finds the parent/root of a given element using the path compression technique.
         *
         * @param x The element for which to find the parent.
         * @return The parent/root of the given element.
         */
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * Unites two sets by performing a union operation based on the ranks of the root elements.
         *
         * @param x The first element.
         * @param y The second element.
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }

    /**
     * Calculates the minimum cost power distribution using Kruskal's algorithm.
     *
     * @param edges       The list of edges representing the distances between power stations.
     * @param numStations The total number of power stations.
     * @return The minimum cost power distribution as a list of edges.
     */
    public static List<Edge> minimumCostPowerDistribution(List<Edge> edges, int numStations) {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        edges.sort(Comparator.comparingInt(e -> e.cost));
        UnionFind unionFind = new UnionFind(numStations);

        for (Edge edge : edges) {
            int sourceRoot = unionFind.find(edge.source);
            int destinationRoot = unionFind.find(edge.destination);

            if (sourceRoot != destinationRoot) {
                minimumSpanningTree.add(edge);
                unionFind.union(sourceRoot, destinationRoot);
            }
        }

        return minimumSpanningTree;
    }

    public static void main(String[] args) {
        // Sample input
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2)); // Power station 0 to power station 1 with cost 2
        edges.add(new Edge(0, 2, 3)); // Power station 0 to power station 2 with cost 3
        edges.add(new Edge(1, 2, 1)); // Power station 1 to power station 2 with cost 1
        edges.add(new Edge(1, 3, 4)); // Power station 1 to power station 3 with cost 4
        edges.add(new Edge(2, 3, 2)); // Power station 2 to power station 3 with cost 2

        int numStations = 4; // Total number of power stations

        // Calculate the minimum cost power distribution
        List<Edge> minimumSpanningTree = minimumCostPowerDistribution(edges, numStations);

        // Print the result
        System.out.println("Minimum Cost Power Distribution:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.cost);
        }
    }
}
