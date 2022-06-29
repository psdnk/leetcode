import java.util.LinkedList;
import java.util.Queue;

public class RedundantConnection_684 {

    class Node {
        private int node;
        private int parent;
        public Node(int node , int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int []ret = new int[2];
        boolean [] visited = new boolean[edges.length+1];
        for (int i=0;i<edges.length;i++){
            if (!visited[i+1]){
                if (isCycle(edges,i,visited)){
                    ret[0] = edges[i][0];
                    ret[1] = edges[i][1];
                }
            }
        }
        return ret;
    }


    public boolean isCycle(int [][] edges, int i, boolean[] visited){
        Queue<Node> queue =  new LinkedList<>();
        queue.add(new Node(i+1,-1));
        visited[i+1] = true;
        while (!queue.isEmpty()){
            int node = queue.peek().node;
            int parent = queue.peek().parent;
            queue.remove();

//            int []

        }
        return false;
    }
}
