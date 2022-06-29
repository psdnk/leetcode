package study.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
    LinkedList<Integer> adjList [];
    boolean [] visited;
    List<Integer> ret;
    int vertices;

    public DepthFirstSearch(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i=0;i<vertices;i++) adjList [i] = new LinkedList<Integer>();
        visited = new boolean[vertices];
        ret = new ArrayList<>();
    }

    public void addEdge(int source, int destination){
        adjList[source].addFirst(destination);
        adjList[destination].addFirst(source);
    }
    public void dfs(int node){
        if (!visited[node]){
            visited[node] = true;
            ret.add(node);
            for (int i : adjList[node]){
                dfs(i);
            }
        }
    }


    public static void main(String[] args) {

        DepthFirstSearch g = new DepthFirstSearch(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        for (int i=0;i<7;i++)g.dfs(i);
        System.out.println(g.ret.toString());
    }
}
