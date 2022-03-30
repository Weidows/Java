package prodsmile.datastructure;


import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Queue<T> {
    LinkedList<T> list = new LinkedList<>();
    public void enqueue(T e){
        list.add(e);
    }
    public T dequeue(){
        return list.remove();
    }

    public int size(){
        return list.size();
    }

    @Override
    public String toString(){
        return list.toString();
    }

    @Test
    public void test(){
        var queue = new Queue<>();
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
