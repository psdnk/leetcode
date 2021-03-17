public class AngleBetweenHandsofaClock {

    public static void main(String[] args) {
        System.out.println (angleClock ( 3,30 ));
    }

    public  static double angleClock(int hour, int minutes) {

        double h = ((hour + (double)minutes/60)*360)/12;

        double m = ((double)minutes * 360)/60;
        //System.out.println (h-m);
        return Math.min ( 360-(Math.abs ( h-m )),Math.abs ( h-m ) );



    }
}
