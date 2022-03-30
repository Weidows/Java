package prodsmile.datastructure;

import org.junit.Test;

import java.util.HashSet;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;


public class List<T> {
    static class Node<T> {
        Node<T> next = null;
        T data;
        public Node(T data){
            this.data = data;
        }
    }
    Node<T> head = null;

    // O(1)
    public void insert(T data) {
        var node = new Node<>(data);
        node.next = head;
        head = node;

    }

    // O(n)
    public Node<T> find(Predicate<T> predicate) {
        var p = head;
        while(p != null) {
            if(predicate.test(p.data)) {
                return p;
            }
            p = p.next;
        }
        return null;

    }

    public Integer size(){
        var p = head;
        Integer c = 0;
        while(p != null) { p = p.next; c++; }
        return c;
    }

    // O(n)
    public void remove(Node<T> node){
        if(head == null) {
            return;
        }

        if(head == node) {
            head = head.next;
            return;
        }

        var slow = head;
        var fast = head.next;

        while(fast != node && fast != null) {
            slow = fast;
            fast = fast.next;
        }
        if(fast != null) {
            slow.next = fast.next;
//            fast.data = null;
        }

    }



    public void reverse(){
        // prev | current | next

        Node<T> prev = null;
        var current = head;
        Node<T> next;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }

    private Node<T> _reverse2(Node<T> head) {
        if(head == null || head.next == null) {
            return head;
        }

        var rest = _reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public void reverse2() {
        head = _reverse2(head);
    }

    public boolean hasLoop1(){
        var set = new HashSet<>();

        var p = head;
        while(p != null) {
            if(set.contains(p)) {
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }

    public boolean hasLoop2(){

        if(head == null || head.next == null) {
            return false;
        }

        var slow = head;
        var fast = head.next.next;
        while(fast != null && fast.next != null) {
            if(fast == slow) {return true;}
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;


    }


    @Test
    public void test_insert(){
        var list = new List<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        var p = list.head;
        for(Integer i = 3; p != null ; i--) {
            assertEquals(i, p.data);
            p = p.next;
        }
    }

    @Test
    public void test_find_remove(){
        var list = new List<String>();

        list.insert("C++");
        list.insert("Java");
        list.insert("C");
        list.insert("C#");
        list.insert("python");

        var node = list.find(x -> x == "Java");
        assertEquals("Java", node.data);

        var node2 = list.find(x -> x == "ruby");
        assertEquals(null, node2);

        list.remove(node);
        assertEquals(Integer.valueOf(4), list.size());
        assertEquals(null, list.find(x -> x == "Java"));
    }

    @Test
    public void test_reverse() {
        var list = new List<Integer>();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.reverse();

        var p = list.head;
        for (Integer i = 1; p != null; i++) {
            assertEquals(i, p.data);
            p = p.next;
        }
    }

    @Test
    public void test_reverse2() {
        var list = new List<Integer>();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.reverse2();

        var p = list.head;
        for (Integer i = 1; p != null; i++) {
            assertEquals(i, p.data);
            p = p.next;
        }
    }

    @Test
    public void test_loop(){
        var list = new List<Integer>();
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.insert(0);
        var node = list.find(x -> x == 3);
        node.next = list.head;

        assertEquals(true, list.hasLoop1());
        assertEquals(true, list.hasLoop2());

    }

}
