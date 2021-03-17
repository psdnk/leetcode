import java.util.Arrays;

public class PermutationExistInString {

    public static void main(String[] args) {
        String s1  = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion( s1,s2 ));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int [] hash = new int[26];
        int [] hashComp = new int[26];
        for ( int j=0;j< s1.length();j++ ) {
            hash[ s1.charAt( j ) - 'a' ] = hash[ s1.charAt( j ) - 'a' ] + 1;
        }
        int s1Len = s1.length();

        for ( int i=0;i<s2.length();i++ ){
            if ( i + s1Len > s2.length() ){
                break;
            }
            String k  = s2.substring( i, i + s1Len );
            Arrays.fill(hashComp,0  );
            for ( int j=0;j< k.length();j++ ){
                hashComp[k.charAt( j ) - 'a'] = hashComp[k.charAt( j ) - 'a'] +1;
            }
            System.out.println(k);
            String l1 = Arrays.toString(hash);
            String l2 = Arrays.toString( hashComp );
            //System.out.println(l1 + " - " + l2);

            if ( l1.equals( l2 )){
                return true;
            }
        }
        return false;
    }
}
