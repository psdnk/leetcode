package october;

import java.util.ArrayList;

public class AsteroidCollision {

    public static void main(String[] args) {
//        int []  asteriods =  {10,2,-5};
        int []  asteriods =  {5,10,-5};
        asteroidCollision (  asteriods);
    }
    public static int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length-1;

        ArrayList<Integer> ret = new ArrayList<>();
        for ( int i= len;i>=1;i-- ){
            int first = asteroids[i];
            int second = asteroids[i-1];
            if ( first < 0 ){
                if ( Math.abs ( first ) > Math.abs ( second ) ){
                    asteroids[i-1] = first;
//                    ret.add ( 0,first );
                }else {
                    asteroids[i-1] = second;
                    ret.add ( 0,second );
                }
            }else {
                ret.add ( 0, first );
            }
        }
        System.out.println (ret.toString () );
        return new int[5];
    }
}
