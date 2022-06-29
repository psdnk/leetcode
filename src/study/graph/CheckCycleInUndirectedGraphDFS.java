package study.graph;

import java.util.LinkedList;

public class CheckCycleInUndirectedGraphDFS {
    LinkedList<Integer> [] adjList;
    int vertices;
    boolean [] visited;
    boolean isCycle;

    public CheckCycleInUndirectedGraphDFS(int vertices){
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices+1];
        this.visited = new boolean[vertices+1];
        for (int i=1;i<vertices+1;i++)adjList[i] = new LinkedList<>();
    }

    public void addEdge(int source, int destination){
        adjList[source].addFirst(destination);
        adjList[destination].addFirst(source);
    }

    public void print(){
        for (int i=1;i<=vertices;i++) System.out.println(i + " -> " + adjList[i]);
    }

    public void dfs(int vertex, int parent){
             visited[vertex] = true;
             for (int v : adjList[vertex]){
                 if (!visited[v]){
                     visited[v] = true;
                     dfs(v , vertex);
                 }else if (v != parent){
                    isCycle = true;
                 }
             }
    }

    public boolean isCycleInGraph(){

        for (int i=1;i<=vertices;i++){
            if (!visited[i]){
                dfs(i,-1);
            }
            if (isCycle){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CheckCycleInUndirectedGraphDFS graph = new CheckCycleInUndirectedGraphDFS(11);
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
        System.out.println(graph.isCycleInGraph());
    }
}
