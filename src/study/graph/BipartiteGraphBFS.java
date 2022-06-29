package study.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
    LinkedList<Integer> adj [];
    int vertices;
    Queue<Integer> queue;
    int [] color;
    boolean isBipartite = false;

    public BipartiteGraphBFS(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices+1];
        for (int i=1;i<=vertices;i++)adj[i] = new LinkedList<>();
        queue = new LinkedList<>();
        color = new int[vertices+1];
    }

    public void addEdge(int source, int destination){
        adj[source].addFirst(destination);
        adj[destination].addFirst(source);
    }

    public void print(){
        for (int i=1;i<=vertices;i++) System.out.println(i + " -> " + adj[i]);
    }

    public boolean isBipartite(){
        for (int i=1;i<=vertices;i++){
            bfs(i);
            System.out.println(i + " : " + isBipartite);
            if (isBipartite) return true;
        }
        return isBipartite;
    }

    public void bfs(int vertex){
        queue.add(vertex);
        color[vertex] = 1;
        while (!queue.isEmpty()){
            int v  = queue.poll();
            for (int vv : adj[v]){
                if (color[vv] !=0 && color[vv] == color[v] ) {
                    isBipartite = true;
                    return;
                }else {
                    color[vv] = -1 * color[v];
                }
            }
        }
    }

    public static void main(String[] args) {
        BipartiteGraphBFS graph = new BipartiteGraphBFS(11);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);

        graph.addEdge(3, 5);
        graph.addEdge(5, 10);
        graph.addEdge(5, 6);
        graph.addEdge(10, 9);
        graph.addEdge(6, 7);
        graph.addEdge(9, 8);
        graph.addEdge(7, 8);
        graph.addEdge(8, 11);
        graph.print();
        System.out.println(graph.isBipartite());
    }
}
