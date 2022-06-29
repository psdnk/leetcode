import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach_1642 {

    public static void main(String[] args) {
        int [] heights = {14,3,19,3};
        int bricks = 17;
        int ladders = 0;
        System.out.println(furthestBuilding(heights,bricks,ladders));

    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0;i<heights.length-1;i++){
            int gap = heights[i+1]-heights[i];
            if (gap>0){
                minHeap.add(gap);
            }
            if (minHeap.size()>ladders){
                bricks = bricks- minHeap.poll();
            }
            if (bricks < 0) return i;
        }

        return heights.length-1;
    }

    public static int helper(int [] heights, int index, int bricks, int ladders){

                System.out.println(index + " : " + bricks + " : " + ladders);

        if (index>= heights.length) return -1;
        if (bricks==0 && ladders==0) return -1;
        if (heights[index-1]>= heights[index]) return helper(heights,index+1,bricks,ladders);
        else {
            int brick = bricks>=heights[index]-heights[index-1] ? helper(heights,index+1,bricks-(heights[index]-heights[index-1]),ladders) : index-1;
            int ladder= ladders>0 ? helper(heights,index+1,bricks,ladders-1) : index-1;
            return Math.max(brick,ladder);
        }

//        System.out.println(index);
//        System.out.println(index + " : " + bricks + " : " + ladders);
//        if ((bricks == 0 && ladders == 0) )index =  index-1;
//        if (index== heights.length) index = index-1;
//        if ((bricks>0 && ladders>0) && index<heights.length){
//            if (heights[index-1]>= heights[index]) return helper(heights,index+1,bricks,ladders);
//            else return Math.max(helper(heights,index+1,bricks-1,ladders),
//                    helper(heights,index+1,bricks,ladders-1));
//        }
//        return index;
    }
}
