public class ChampagneTower_799 {

    public static void main(String[] args) {
        System.out.println(champagneTower(3,2,  1));
    }
    public static double champagneTower(int poured, int query_row, int query_glass) {
        int n = query_row+1;
        int sum = (n)*(n+1)/2;
        if(poured==0) return 0;
        if(poured>=sum) return 1;
        else if(poured<(sum-n-1)) return 0;
        else{
            int diff = poured-(sum-n-1);
            System.out.println(diff);
            double val = (double)diff/n;
            if(query_glass == 0 || query_glass == query_row) return val/2;
            else return val;
        }
    }
}
