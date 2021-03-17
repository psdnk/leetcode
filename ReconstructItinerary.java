import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
//        List<List<String>> tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//        for ( int i=0;i<4;i++ ){
//
//        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,SortedSet<String>> hashMap = new HashMap<>();
        Stack<String> stack = new Stack<> ();
        List<String> ret = new ArrayList<>();
        for ( List<String> list : tickets ){
            SortedSet<String> orDefault = hashMap.getOrDefault ( list.get ( 0 ) , new TreeSet<String> () );
            orDefault.add ( list.get ( 1 ));
            hashMap.put ( list.get ( 0 ), orDefault);
        }
        stack.push ( "JFK" );
        while (!stack.isEmpty ()){
            String src = stack.peek ();
            SortedSet<String> values = hashMap.get ( src );
            if ( values.size ()==0 ){
                ret.add (stack.pop ());
            }else {
                String dest = values.first ();
                values.remove ( dest );
                hashMap.put ( src,values );
                stack.push ( dest );
            }
        }

        Collections.reverse ( ret );
        //return ret;


        Map<String ,PriorityQueue<String>> hm = new HashMap<>();
        List<String> route = new LinkedList<>();
        Stack<String> s = new Stack<> ();
        for ( List<String> list : tickets ){
            hm.computeIfAbsent ( list.get ( 0 ),k ->new PriorityQueue<String> ()).add ( list.get ( 1 )  );
        }
        s.push ( "JFK" );

        while (!s.isEmpty ()){
            String soruce = s.peek ();
            if ( hm.containsKey ( soruce ) && ! hm.get ( soruce ).isEmpty () ){
                s.push ( hm.get ( soruce ).poll () );
            }else {
                route.add(0,s.pop ());
            }
        }

        return route;
        

    }
}
