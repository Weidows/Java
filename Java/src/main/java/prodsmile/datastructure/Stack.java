package prodsmile.datastructure;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Stack<T> {

    LinkedList<T> list = new LinkedList<>();

    public void push(T e) {
        list.addFirst(e);
//        list.push(e);
    }

    public T pop() {
        //list.removeFirst();
        return list.pop();
    }

    public int size(){
        return list.size();
    }

    @Test
    public void test() {
        var stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
}
