package prodsmile.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Queue2<T> {

    Stack<T> s1 = new Stack<>();
    Stack<T> s2 = new Stack<>();

    public void enqueue(T e) {
        s1.push(e);
    }

    public T dequeue() {
        if(s2.size() > 0) {
            return s2.pop();
        }

        while(s1.size() > 0) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    @Test
    public void test(){
        var queue = new Queue2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());

    }
}
