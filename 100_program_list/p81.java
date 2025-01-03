import java.util.Stack;

public class p81 {

    // Declare two stacks
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the stacks
    public p81() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (push element to stack1)
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation (pop element from stack2, move elements from stack1 to stack2 if needed)
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            // Move all elements from stack1 to stack2 to reverse their order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop the element from stack2 (this is the front of the queue)
        return stack2.pop();
    }

    // Peek operation (get the front element without removing it)
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            // Move all elements from stack1 to stack2 to reverse their order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Return the front element without removing it
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        p81 queue = new p81();

        // Test the queue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 10
        System.out.println("Peek element: " + queue.peek());         // Output: 20
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 20
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: false
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 30
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: true
    }
}
