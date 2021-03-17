import javafx.util.Pair;
import java.util.Stack;

public class StockSpanner {
    public int capacity = 150000;
    public int currentSize;
    public int [] mH;


    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next( 100 ));
        s.display();
        System.out.println(s.next( 80 ));
        s.display();
        System.out.println(s.next( 60 ));
        s.display();
        System.out.println(s.next( 70 ));
        s.display();
        System.out.println(s.next( 60 ));
        s.display();
        System.out.println(s.next( 75 ));
        s.display();
        System.out.println(s.next( 85 ));
        s.display();
    }
    public StockSpanner() {
        currentSize = 0;
        mH = new int[capacity +1];
    }

    public void display(){
//        System.out.print("Print : ");
//        for ( int i=1;i<=currentSize;i++ ){
//            System.out.print(mH[i] + " ");
//        }
//        System.out.println();
    }
    public int bubbleUp(int pos){
        int parentIdx = pos/2;
        int currentIdx = pos;
        while (currentIdx > 0 && mH[parentIdx] >= mH[currentIdx]){
            swap( parentIdx,currentIdx );
            currentIdx = parentIdx;
            parentIdx = parentIdx/2;
        }
        return currentIdx;

    }
    public void swap(int pos1,int pos2){
        int temp = mH[pos1];
        mH[pos1] = mH[pos2];
        mH[pos2] = temp;
    }

    public int nextV1(int price) {
        currentSize++;
        int currentIdx = currentSize;
        mH[currentIdx] = price;
        int pos =  bubbleUp( currentIdx );
        return pos;
    }

    //Maintain stack in decreasing order
    Stack<Pair<Integer,Integer>> stack = new Stack<Pair<Integer, Integer>>();
    int index = -1;
    public int next(int price){
        index = index +1;
        while (stack.size() > 0 && stack.peek().getValue() <= price){
            stack.pop();
        }
        if ( stack.size() == 0 ){
            stack.push(new Pair<>( index,price ) );
            return index+1;
        }

        Pair<Integer, Integer> lastPair = null;
        if ( stack.size() > 0 ){
            lastPair = stack.peek();
        }
        stack.push(new Pair<>( index,price ) );
        return lastPair != null  ? index - lastPair.getKey() : index;
    }
}
