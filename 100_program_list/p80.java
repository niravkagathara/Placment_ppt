import java.util.LinkedList;
import java.util.Queue;

public class p80 {
    
    // Define two queues
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    // Constructor to initialize the two queues
    public p80() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    // Push an element onto the stack
    public void push(int x) {
        // Push the element into the first queue
        queue1.offer(x);
    }
    
    // Pop the top element from the stack
    public int pop() {
        // If queue1 is empty, return -1 (indicating the stack is empty)
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        
        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        
        // The last element in queue1 is the top of the stack
        int top = queue1.poll();
        
        // Swap the references of queue1 and queue2 so that we can continue
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return top;
    }
    
    // Get the top element of the stack without popping it
    public int top() {
        // If queue1 is empty, return -1 (indicating the stack is empty)
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        
        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        
        // The last element in queue1 is the top of the stack
        int top = queue1.peek();
        
        // Move the last element to queue2 to preserve it
        queue2.offer(queue1.poll());
        
        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return top;
    }
    
    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    
    public static void main(String[] args) {
        p80 stack = new p80();
        
        // Testing the stack implementation
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element: " + stack.top()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Top element after pop: " + stack.top()); // Output: 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
    }
}
