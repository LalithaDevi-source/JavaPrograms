package Day7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {
    public static class Graph {
        
        int size;
        int[][] adjMatrix;
        public Graph(int size) {
            this.size = size;
            adjMatrix = new int[size][size];
        }

        public void addEdge(int first, int second) {
            adjMatrix[first][second] = 1;
            adjMatrix[second][first] = 1;
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1);
            
            Queue<Integer> queue =  new LinkedList<>();
            queue.add(startId);
            distances[startId] = 0;
            while(!queue.isEmpty()){
                int v = queue.remove();
                for(int i =0;i<size;i++){
                    if(adjMatrix[v][i] == 1 && 
                        distances[i] == -1 )
                    {
                        queue.add(i);
                        distances[i] = distances[v]+6;
                    }
                }
            }
            return distances;
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