import java.util.ArrayList;
import java.util.List;

class CombinationIterator {

    int position  = 0;
    List<String> result =  null;
    public CombinationIterator(String characters, int combinationLength) {
        result = new ArrayList<>();
        helper(characters,0,combinationLength,new StringBuilder (  ));

    }

    public String next() {
        return result.get ( position++ );
    }

    public boolean hasNext() {
        return position<result.size ();
    }

    public  void helper(String characters,int pos,int combinationLength,StringBuilder sb){
        if ( sb.length () == combinationLength ){
            result.add ( sb.toString () );
            return;
        }
        for ( int i = pos ;i<characters.length ();i++ ){
            sb.append ( characters.charAt ( i ) );
            helper ( characters,i+1,combinationLength,sb );
            sb.deleteCharAt ( sb.length ()-1 );
        }

    }
}