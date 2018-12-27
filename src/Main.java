import homework_3.Stack;

/**
 * @autor Kunakbaev Artem
 */
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(2);
        stack.push(4);
        stack.push(8);
        stack.push(8);
        stack.push(8);
        stack.push(8);
        stack.printStack();
    }
}

