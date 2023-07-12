package Algorithms.MinimumSpanningTreeAlgoS.problems_Kruskal;

import java.util.*;


public class problem_2 {

        // Question: You are developing a telecommunications network. Given a list of cell towers and the distances between them,
        // determine the minimum cost to connect all cell towers with fiber optic cables.
        // Implement Kruskal's algorithm to calculate the minimum cost of connecting all cell towers.

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
             * Finds the root/parent of a given element using the path compression technique.
             *
             * @param x The element to find the root/parent for.
             * @return The root/parent of the given element.
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
         * Calculates the minimum cost telecommunications network using Kruskal's algorithm.
         *
         * @param edges      The list of edges representing the distances between cell towers.
         * @param numTowers  The total number of cell towers.
         * @return The minimum cost telecommunications network as a list of edges.
         */
        public static List<Edge> minimumCostTelecommunicationsNetwork(List<Edge> edges, int numTowers) {
            List<Edge> minimumSpanningTree = new ArrayList<>();
            edges.sort(Comparator.comparingInt(e -> e.cost));
            UnionFind unionFind = new UnionFind(numTowers);

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
            edges.add(new Edge(0, 1, 2)); // Cell tower 0 to cell tower 1 with cost 2
            edges.add(new Edge(0, 2, 3)); // Cell tower 0 to cell tower 2 with cost 3
            edges.add(new Edge(1, 2, 1)); // Cell tower 1 to cell tower 2 with cost 1
            edges.add(new Edge(1, 3, 4)); // Cell tower 1 to cell tower 3 with cost 4
            edges.add(new Edge(2, 3, 2)); // Cell tower 2 to cell tower 3 with cost 2

            int numTowers = 4; // Total number of cell towers

            // Calculate the minimum cost telecommunications network
            List<Edge> minimumSpanningTree = minimumCostTelecommunicationsNetwork(edges, numTowers);

            // Print the result
            System.out.println("Minimum Cost Telecommunications Network:");
            for (Edge edge : minimumSpanningTree) {
                System.out.println(edge.source + " - " + edge.destination + " : " + edge.cost);
            }
        }
    }

