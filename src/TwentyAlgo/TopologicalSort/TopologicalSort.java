package TwentyAlgo.TopologicalSort;

import java.util.*;
//https://youtu.be/tZjVTTABXV0?si=bagP60dn_UQsUi5l
public class TopologicalSort {
    public static void main(String[] args) {
        // Number of vertices
        int V = 6;

        // Create adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        // Initialize adjacency lists for all vertices
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        // Example graph:
        // 5 -> 2
        // 5 -> 0
        // 4 -> 0
        // 4 -> 1
        // 2 -> 3
        // 3 -> 1

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        int[] result = topoSort(V, adj);
        System.out.println(Arrays.toString(result));
    }

    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int indegree[] = new int[V]; //0
        for(int u=0;u<adj.size();u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        //3

        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }

        if(res.size() != V){
            return new int[V];
        }

        int ans[] = new int[V];
        for(int i=0;i<V;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
