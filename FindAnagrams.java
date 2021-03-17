import java.util.*;

public class FindAnagrams {


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        String k = "bce";
//        int r = 0;
//        for ( int i = 0 ; i < k.length() ; i++ ) {
//
//            int a = k.charAt( i ) - 'a';
//            int b = p.charAt( i ) - 'a';
//            r = r ^ a ^ b;
//        }
//        int [] hash = new int[26];
//        Arrays.fill( hash,0 );
//        int [] hashComp = new int[26];
//        Arrays.fill( hashComp,0 );
//
//        System.out.println(Arrays.toString( hash ).equals(Arrays.toString( hashComp )));
//        System.out.println( r );
        findAnagrams( s,p );
       // System.out.println(isAnagram( "abc" ,"cba"));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        int [] hash = new int[26];
        int [] hashComp = new int[26];
        Arrays.fill( hash,0 );
//        Arrays.fill( hashComp,0 );
        for ( char c : p.toCharArray() ){
            hash[c-'a'] = hash[c-'a']+1;
        }
        List<Integer> ret = new ArrayList<>();
        int pLength = p.length();
        for ( int i = 0 ;i< s.length() ;i++ ){
            if ( i+ pLength > s.length() ){
                break;
            }
            String k = s.substring( i,i+pLength );
            Arrays.fill( hashComp,0 );
            for ( char c : k.toCharArray() ){
                hashComp[c-'a'] = hashComp[c-'a']+1;
            }
            System.out.println(k);

            if ( Arrays.toString( hash ).equals( Arrays.toString( hashComp ) ) ){
                ret.add( i );
            }
        }

        System.out.println(ret.toString());
        return ret;


    }


    public static boolean isAnagram(String k, String p ) {
//        HashMap<Character, Integer> hm = new HashMap<>();
//        for ( char a : k.toCharArray() ){
//            hm.put( a , hm.getOrDefault( a,0 )+1 );
//        }
//        for ( char a: p.toCharArray() ){
//            if ( hm.containsKey( a ) ){
//                hm.put( a,hm.get( a )-1 );
//            }else {
//                return false;
//            }
//        }
//        Iterator<Character> iterator = hm.keySet().iterator();
//        while (iterator.hasNext()){
//            if ( hm.get(  iterator.next()) != 0   ){
//                return false;
//            }
//        }
//        return true;
//    }
        int r = 0;
        

        for ( int i = 0 ; i < k.length() ; i++ ) {

            int a = k.charAt( i ) - 'a';
            int b = p.charAt( i ) - 'a';
            r = r ^ a ^ b;
        }
        System.out.println( r );
        return false;
    }
}
