import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AmazonlargestItemAssociation {

    class PairString {
        String first, second;
        PairString(){};
        PairString(String  first,String second){
            this.first=first;
            this.second = second;
        }
    }

    List<String> largestItemAssociation(List<PairString> itemAssociation)
    {
        // WRITE YOUR CODE HERE
        HashMap<String, String> hashMap = new HashMap<>();
        for ( PairString p : itemAssociation ){
            String key = p.first;
            String value = p.second;
            hashMap.put(key, value);
        }
        List<String> ret = new ArrayList<>();;

        Set<String> keys = hashMap.keySet ();
        for ( String key : keys ){
            List<String> temp = new ArrayList<>();
            temp.add(key);
            //temp.add ( hashMap.get(key) )
            boolean iterate = true;
            while (iterate){
                String value = hashMap.get ( key );
                temp.add ( value );
                if ( hashMap.containsKey(value) ){
                    key = value;
                }else {
                    iterate = false;
                }
            }
            if ( ret.size () == temp.size () ){

                    if ( ret.get ( 0 ).compareTo ( temp.get ( 0 ) ) >0 ){
                        ret = new ArrayList<>();
                        for ( String v : temp ){
                            ret.add ( v );
                        }

                    }

            }
            if ( ret.size () < temp.size () ){
                ret = new ArrayList<>();
                for ( String v : temp ){
                    ret.add ( v );
                }
            }


        }
        return ret;


    }
}
