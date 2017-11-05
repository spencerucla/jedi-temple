// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        private boolean[][] mAdjacencyMatrix;
        private int mNodesCount;

        public Graph(int size) {
            mAdjacencyMatrix = new boolean[size][size];
            mNodesCount = size;
        }

        public void addEdge(int first, int second) { // 0 indexed
            mAdjacencyMatrix[first][second] = true;
            mAdjacencyMatrix[second][first] = true;
        }

        public int[] shortestReach(int startId) { // 0 indexed
            List<Integer> shortestPaths = new ArrayList<Integer>(mNodesCount);
            for (int i = 0; i < mNodesCount; i++) {
                shortestPaths.add((i == startId ? 0 : -1));
            }

            Queue<Integer> toSearch = new LinkedList<Integer>();
            toSearch.add(startId);
            toSearch.add(-1);
            int dist = 0;

            while (!toSearch.isEmpty()) {
                int cur = toSearch.remove();
                if (cur == -1) {
                    dist += 6;
                    continue;
                }
                for (int i = 0; i < mNodesCount; i++) {
                    if (mAdjacencyMatrix[cur][i] && shortestPaths.get(i) == -1) {
                        shortestPaths.set(i, dist+6);
                        toSearch.add(i);
                    }
                }
                toSearch.add(-1);
            }

            int[] ret = new int[mNodesCount];
            for (int i = 0; i < mNodesCount; i++) {
                ret[i] = shortestPaths.get(i);
            }

            return ret;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}

