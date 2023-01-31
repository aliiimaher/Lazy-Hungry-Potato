// Stack

public class Stack {
    // store elements of stack
    private Restaurant restaurants[];
    // represent top of stack
    private int top;
    // total capacity of the stack
    private final int capacity;

    // Creating a stack
    Stack(int size) {
        // initialize the array
        // initialize the stack variables
        restaurants = new Restaurant[size];
        capacity = size;
        top = -1;
    }

    // push elements to the top of stack
    public void push(Restaurant x) {
        if (isFull()) {
            System.out.println("Stack OverFlow");

            // terminates the program
            System.exit(1);
        }
        // testing
        // insert element on top of stack
        // System.out.println("Inserting " + x.getRestaurantName());
        restaurants[++top] = x;
    }

    // pop elements from top of stack
    public Restaurant pop() {

        // if stack is empty
        // no element to pop
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            // terminates the program
            System.exit(1);
        }

        // pop element from top of stack
        return restaurants[top--];
    }

    // return size of the stack
    public int getSize() {
        return top + 1;
    }

    // check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // check if the stack is full
    public Boolean isFull() {
        return top == capacity - 1;
    }

    // display elements of stack
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(restaurants[i].getRestaurantName() +
                    " " + restaurants[i].getRestaurantDistance());
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);

        Restaurant restaurant1 = new Restaurant("ali", 13);
        Restaurant restaurant2 = new Restaurant("hsn", 25);
        Restaurant restaurant3 = new Restaurant("abs", 18);

        stack.push(restaurant1);
        stack.push(restaurant2);
        stack.push(restaurant3);

        System.out.print("Stack: ");
        stack.printStack();

        // remove element from stack
        stack.pop();
        System.out.println("\nAfter popping out");
        stack.printStack();
    }
}
