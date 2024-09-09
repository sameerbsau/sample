package TwentyAlgo.DFS;

import java.util.ArrayList;
import java.util.List;

public class GraphTraversal {

    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i< v; i++){
            adj.add(new ArrayList<>());
        }

        int [][] edges= {
            { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };

        for (int[] e: edges){
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        DFS(adj,source);
    }

    private static void DFS(List<List<Integer>> adj, int source) {
        boolean visited[] = new boolean[adj.size()];
        DFSRec(adj,visited,source);
    }

    private static void DFSRec(List<List<Integer>> adj, boolean[] visited, int source) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int i : adj.get(source)){
            if(!visited[i]){
                DFSRec(adj,visited,i);
            }
        }
    }

    private static void addEdge(List<List<Integer>> adj, int i, int i1) {
        adj.get(i).add(i1);
        adj.get(i1).add(i);

    }
}
