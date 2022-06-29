import java.util.*;

public class JumpGameIV {
    public static void main(String[] args) {
//        int [] arr = {100,-23,-23,404,100,23,23,23,3,404};
        int [] arr = {0, 100, 2, 3, 4, 101, 100, 7, 8, 9, 101, 11};
//        int [] arr = {68,-94,-44,-18,-1,18,-87,29,-6,-87,-27,37,-57,7,18,68,-59,29,7,53,-27,-59,18,-1,18,-18,-59,-1,-18,-84,-20,7,7,-87,-18,-84,-20,-27};

//        int [] arr = {7,7,2,1,7,7,7,3,4,1};
        System.out.println(minJumpsv2(arr));
    }
//    public static int minJumpsv2(int[] arr) {
////        HashMap<Integer,Integer> hm = new HashMap<>();
//        HashMap<Integer, List<Integer>> hm = new HashMap<>();
//        boolean [] visited = new boolean[arr.length];
//        int [] dp = new int[arr.length];
//        Arrays.fill(dp,-1);
//        Arrays.fill(visited,false);
//        for (int i=0;i<arr.length;i++){
//            List<Integer> q = hm.getOrDefault(arr[i], new ArrayList<Integer>());
//            q.add(i);
//            hm.put(arr[i],q);
//        }
//        return helperv2(arr,0,hm,visited,dp);
//    }
//
//    public static int helper(int [] arr, int i,HashMap<Integer,Integer> hm,boolean [] visited){
//        if (i<0 || i>=arr.length || visited[i]) return Integer.MAX_VALUE;
//        if (i== arr.length-1){
//            return 0;
//        }
//        visited[i] = true;
//        int p1 = helper(arr,i+1,hm,visited);
//        int p2 = helper(arr,i-1,hm,visited);
//        int p3 = hm.containsKey(arr[i]) ? helper(arr,hm.get(arr[i]),hm,visited) : Integer.MAX_VALUE;
//        visited[i] = false;
//        System.out.println(i + " : " + p1 + " : " + p2 + " : " + p3);
//        int min = Math.min(p1, Math.min(p2, p3));
//        return  min == Integer.MAX_VALUE ? 0 : min+1;
//    }
//
//    public static int helperv2(int [] arr, int i,HashMap<Integer,List<Integer>> hm,boolean [] visited,int[] dp){
//        if (i<0 || i>=arr.length || visited[i]) return Integer.MAX_VALUE;
//        if (i== arr.length-1){
//            return 0;
//        }
//        if (dp[i] != -1){
////            System.out.println(i + " : " + dp[i]);
//            System.out.println(Arrays.toString(dp));
//            return dp[i];
//        }
//        visited[i] = true;
//        int p1 = helperv2(arr,i+1,hm,visited,dp);
//        int p2 = helperv2(arr,i-1,hm,visited,dp);
//        int p3 = Integer.MAX_VALUE;
//        if (hm.containsKey(arr[i])){
//            List<Integer> list = hm.get(arr[i]);
//            for (int index : list){
//                p3 = Math.min(p3,helperv2(arr,index,hm,visited,dp));
//            }
//        }
//        visited[i] = false;
//        System.out.println(i + " : " + p1 + " : " + p2 + " : " + p3);
//        int min = Math.min(p1, Math.min(p2, p3));
//        min = min==Integer.MAX_VALUE ? 0 : min+1;
//        dp[i] = min;
//        System.out.println(Arrays.toString(dp));
//        return min;
//
//    }
//
//    public static int minJumps(int[] arr){
//        int len = arr.length;
//        if (len==1) return 0;
//        HashMap<Integer,List<Integer>> hm = new HashMap<>();
//        for (int i=0;i<len;i++){
//            hm.computeIfAbsent(arr[i],v -> new ArrayList<>()).add(i);
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(0);
//        int steps = 0;
//        while (!queue.isEmpty()){
//            steps++;
//            int size = queue.size();
//            for (int i=0;i<size;i++){
//                int index = queue.poll();
//                if (index-1 >= 0 && hm.containsKey(arr[index-1]))queue.offer(index-1);
//                if (index+1 < len && hm.containsKey(arr[index+1])){
//                    if (index+1 == len-1) return steps;
//                    queue.offer(index+1);
//                }
//                if (hm.containsKey(arr[index])){
//                    for (int k : hm.get(arr[index])){
//                        if (k != index){
//                            if (k == len-1) return steps;
//                            queue.offer(k);
//                        }
//                    }
//                }
//                hm.remove(arr[index]);
//            }
//        }
//        return steps;
//    }


    public static int minJumpsv2(int[] arr) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        boolean [] visited = new boolean[arr.length];
        int [] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        Arrays.fill(visited,false);
        for (int i=0;i<arr.length;i++) hm.computeIfAbsent(arr[i],v -> new ArrayList<>()).add(i);
        return helperv2(arr,0,hm,visited,dp);
//        return helperv3(arr,0,hm,visited);
    }

    public static int helperv2(int [] arr, int i,HashMap<Integer,List<Integer>> hm,boolean [] visited,int[] dp){
        if (i<0 || i>=arr.length || visited[i]) return Integer.MAX_VALUE;
        if (i== arr.length-1)return 0;
        if (dp[i] != -1)return dp[i];
        visited[i] = true;
        int p1 = helperv2(arr,i+1,hm,visited,dp);
        int p2 = helperv2(arr,i-1,hm,visited,dp);
        int p3 = Integer.MAX_VALUE;
        if (hm.containsKey(arr[i])){
            List<Integer> list = hm.get(arr[i]);
            for (int index : list) p3 = Math.min(p3,helperv2(arr,index,hm,visited,dp));
        }
        visited[i] = false;
        int min = Math.min(p1, Math.min(p2, p3));
        dp[i] = min==Integer.MAX_VALUE ? 0 : min+1;
        return dp[i];
    }
    public static int helperv3(int [] arr, int i,HashMap<Integer,List<Integer>> hm,boolean [] visited){
        if (i<0 || i>=arr.length || visited[i]) return Integer.MAX_VALUE;
        if (i== arr.length-1)return 0;
        visited[i] = true;
        int p1 = helperv3(arr,i+1,hm,visited);
        int p2 = helperv3(arr,i-1,hm,visited);
        int p3 = Integer.MAX_VALUE;
        if (hm.containsKey(arr[i])){
            List<Integer> list = hm.get(arr[i]);
            for (int index : list) p3 = Math.min(p3,helperv3(arr,index,hm,visited));
        }
        visited[i] = false;
        int min = Math.min(p1, Math.min(p2, p3));
        return min==Integer.MAX_VALUE ? 0 : min+1;
    }
}
