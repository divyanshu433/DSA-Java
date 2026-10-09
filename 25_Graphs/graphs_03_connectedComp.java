import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graphs_03_connectedComp {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList <Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length; i++){
            if(!visited[i]){
                bfsUtil(graph, visited);
            }
        }

    }

    private static void bfsUtil(ArrayList <Edge> graph[], boolean visited[]){ // O(V+E)
        Queue <Integer> q = new LinkedList<>();
        // source node
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }



    public static void dfs(ArrayList <Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length; i++){
            if(!visited[i]){
                dfsUtil(graph, i, visited);
            }
        }
    }


    public static void dfsUtil(ArrayList <Edge> graph[], int curr, boolean visited[]){
        // visit
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }
    }




    public static void main(String[] args) {
        
    }
}
