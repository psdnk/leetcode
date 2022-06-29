package study.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCycleInUndirectedGraphBFS {
    private int vertices;
    private LinkedList<Integer> adjList [];
    private Queue<Node> queue;
    private boolean [] visited;

    class Node {
        private int node;
        private int parent;
        public Node(int node , int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public CheckCycleInUndirectedGraphBFS(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices+1];
        for (int i=1;i<=vertices;i++) adjList[i] = new LinkedList<>();

        queue = new LinkedList<>();
        visited = new boolean[vertices+1];
    }

    public void addEdge(int source,int destination){
        adjList[source].addFirst(destination);
        adjList[destination].addFirst(source);
    }

    public void  printAdjList(){
        for (int i=1;i<=vertices;i++) {
            System.out.println(i + " -> " + adjList[i]);
        }
    }

    public boolean isCycle(){
        for (int i=1;i<=vertices;i++){
            if (!visited[i]) {
                if (isCycleUtil(i)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCycleUtil(int node){
        queue.add(new Node(node,-1));
        visited[node] = true;

        while (!queue.isEmpty()){
            int n  = queue.peek().node;
            int par = queue.peek().parent;
            queue.remove();

            for (Integer item : adjList[n]){
                if (!visited[item]){
                    queue.add(new Node(item,n));
                    visited[item] = true;
                }else if (par != item) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckCycleInUndirectedGraphBFS graph = new CheckCycleInUndirectedGraphBFS(11);
        graph.addEdge(1,2);
        graph.addEdge(2,4);

        graph.addEdge(3,5);
        graph.addEdge(5,10);
        graph.addEdge(5,6);
        graph.addEdge(10,9);
        graph.addEdge(6,7);
        graph.addEdge(9,8);
        graph.addEdge(7,8);
        graph.addEdge(8,11);

        graph.printAdjList();

        System.out.println(graph.isCycle());

    }
}
