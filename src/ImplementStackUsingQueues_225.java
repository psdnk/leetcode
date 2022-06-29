import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {

    class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            int size = queue.size()-1;
            while (size-->0){
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.size() ==0 ? true : false;
        }
    }
}
