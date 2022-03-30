package prodsmile.datastructure;

import java.io.IOException;
import java.util.Scanner;

public class Expr {

    static Queue<String> prefixTransform(String expr) {

        var queue = new Queue<String>();
        var highPriorityStack = new Stack<String>();

        var prts = expr.replaceAll("[+-/*]+", "#$0#")
                .split("#");

        for(var prt : prts) {
            if(prt.matches("\\d+")) {
                queue.enqueue(prt);
            }
            else if(prt.equals("+") || prt.equals("-")) {
                while(highPriorityStack.size() > 0) {
                    var op = highPriorityStack.pop();
                    if(op.equals("*") || op.equals("/")) {
                        queue.enqueue(op);
                    } else {
                        highPriorityStack.push(op);
                        break;
                    }
                }
                highPriorityStack.push(prt);
            } else if(prt.equals("*") || prt.equals("/")) {
                highPriorityStack.push(prt);
            }
        }
        while(highPriorityStack.size() > 0) {
            queue.enqueue(highPriorityStack.pop());
        }
        System.out.println(queue.toString());
        return queue;
    }

    public static Integer eval(String expr) {

        var queue = prefixTransform(expr);
        var stack = new Stack<Integer>();
        while(queue.size() > 0) {
            var item = queue.dequeue();
            if(item.matches("\\+|-|\\*|/")) {
                switch (item) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-" :
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        stack.push(stack.pop() / stack.pop());
                        break;
                }

            } else {
                stack.push(Integer.parseInt(item));
            }
        }

        return stack.pop();
    }

    public static void main(String[] argv) throws IOException {

        var scanner = new Scanner(System.in);
        while(true) {
            System.out.print("enter>");
            var expr = scanner.nextLine();
            var value = eval(expr);
            System.out.println(value);
        }
    }

}
