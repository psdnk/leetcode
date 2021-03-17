import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionbyHeight {

    public static void main(String[] args) {
        int [][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue (  people);
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort ( people , new Comparator<int[]> () {
            @Override
            public int compare(int[] a , int[] b) {
                if ( a[0] == b[0] ){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        } );

        int count = 0 ;
        int ans[][] = new int [people.length][2];
        for ( int i=0;i<ans.length;i++ ){
            Arrays.fill ( ans[i],-1 );
        }
        for ( int i = 0 ;i < people.length;i++ ){
            int height = people[i][0];
            int person = people[i][1];
            count = person;
            for ( int j=0;j<ans.length;j++ ){
                if ( count == 0 && ans[j][1] == -1 ){
                    ans[j][0] = height;
                    ans[j][1] = person;
                    break;
                }else if ( ans[j][0] >= height || ans[j][0] == -1 ){
                   count = count -1;
                }
            }


            //System.out.println (Arrays.toString(people[i]));
//            System.out.println (Arrays.toString(ans[i]));

        }
        for ( int i=0;i<ans.length;i++ ){
            System.out.println (Arrays.toString(ans[i]));
        }

        return ans;

    }
}
