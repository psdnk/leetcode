import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CourseSchedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> preqMap = new HashMap<>();
        HashSet<Integer> visitedCourse = new HashSet<>();
        for (int [] preq : prerequisites){
            preqMap.computeIfAbsent(preq[0],k-> new LinkedList<Integer>()).addFirst(preq[1]);
        }

        for (int i=0;i<numCourses;i++){
            if (!visitedCourse.contains(i))
                if (!dfs(i,preqMap,visitedCourse)) return false;
        }

        return true;

    }

    private boolean dfs(int i, HashMap<Integer, LinkedList<Integer>> preqMap, HashSet<Integer> visitedCourse) {

        if (visitedCourse.contains(i)) return false;
        if (preqMap.get(i).size()==0) return true;
        visitedCourse.add(i);
        for (int v : preqMap.get(i)){
            if (!dfs(v,preqMap,visitedCourse)) return false;
        }
        visitedCourse.remove(i);
        preqMap.put(i, new LinkedList<>());
        return true;
    }
}
