package prodsmile.datastructure;

public class LinkedList<T> {

    static class Node<T> {
        Node<T> next = null;
        Node<T> prev = null;
        T data;
    }

    Node<T> head = null;
    Node<T> tail = null;
}
