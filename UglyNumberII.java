public class UglyNumberII {

    public static void main(String[] args) {
        System.out.println (nthUglyNumber ( 10 ));
    }
    public static int nthUglyNumber(int n) {
        int [] ugly = new int[n];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        ugly[0] = 1;
        for ( int i=1;i<n;i++ ){
            int nm2 = ugly[i2] * 2;
            int nm3 = ugly[i3] * 3;
            int nm5 = ugly[i5] * 5;

            int nm = Math.min ( nm2,Math.min ( nm3,nm5 ));

            if ( nm == nm2 ){
                i2++;
            }
            if ( nm == nm3 ){
                i3++;
            }
            if ( nm == nm5 ){
                i5++;
            }
            ugly[i] = nm;
        }
        return ugly[n-1];

    }
}
