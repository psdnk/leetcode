package study.graph;


import java.util.*;

public class BreadthFirstSearch {
    int vertices;
    LinkedList<Integer> adjList [];
    boolean [] visited;
    Queue<Integer> queue;
    List<Integer> ret;

    public BreadthFirstSearch(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i=0;i<vertices;i++) adjList[i] = new LinkedList<>();
        visited = new boolean[vertices];
        queue = new LinkedList<>();
        ret = new ArrayList<>();
    }

    public void addEdge(int source, int destination){
        adjList[source].addFirst(destination);
        adjList[destination].addFirst(source);
    }
    public void BFS(int node){
        if (!visited[node]){
            queue.add(node);
            visited[node] = true;
        }
        while (!queue.isEmpty()){
            int val = queue.poll();
            ret.add(val);
            for (int i : adjList[val]){
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        BreadthFirstSearch g = new BreadthFirstSearch(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        for (int i=0;i<7;i++)g.BFS(i);
        System.out.println(g.ret.toString());
    }


}
