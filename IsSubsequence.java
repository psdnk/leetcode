public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println (isSubsequence ( "axc","ahbgdc" ));
    }

    public static boolean isSubsequence(String s, String t) {

        int j=0;
        boolean ret = true;
        for ( int i=0;i<s.length (); ){
            char x = s.charAt ( i );
            System.out.println (x);
            if ( j < t.length () ){
                if ( t.charAt ( j ) == x ){
                    i=i+1;
                    j = j+1;
                }else {
                    j=j+1;
                }
            }else {
                ret = false;
                break;
            }

        }
        return ret;

    }
}
