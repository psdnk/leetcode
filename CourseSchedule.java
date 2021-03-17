import java.util.ArrayList;
import java.util.LinkedList;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        LinkedList[] adjList =new LinkedList[numCourses+1];
        for ( int i=0;i<=numCourses;i++ ){
            adjList[i]=new LinkedList<Integer>();
        }
        for ( int i=0;i<prerequisites.length;i++ ){
            int src = prerequisites[i][0];
            int dest = prerequisites[i][1];
            adjList[src].add( dest );
            // adjList[dest].add( src );
        }
        boolean [] recursiveArr = new boolean[numCourses+1];
        boolean [] visted = new boolean[numCourses+1];

        for ( int i = 1 ;i<=numCourses;i++ ){
            if(isCycleUtil(i,visted,recursiveArr,adjList)){
                return true;
            }
        }
        return false;



    }

    public boolean isCycleUtil(int vertex , boolean[] visted , boolean[] recursiveArr , LinkedList[] adjList) {
        visted[vertex] = true;
        recursiveArr[vertex] = true;
        LinkedList edges = adjList[ vertex ];
        for ( int i=0;i<edges.size();i++ ){
            int e = (int)edges.get( i );
            if ( !visted[e] && isCycleUtil( e,visted,recursiveArr,adjList ) ){
                return true;
            }else if ( recursiveArr[e] ){
                return true;
            }
        }
//        visted[vertex] = false;
        recursiveArr[vertex] =false;
        return false;
    }
}
