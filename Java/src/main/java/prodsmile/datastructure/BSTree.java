package prodsmile.datastructure;

import org.junit.Test;

public class BSTree<T extends Comparable<T>> {

    BSTNode<T> root = null;

    static class BSTNode<T> {
        BSTNode<T> left = null;
        BSTNode<T> right = null;
        T data;

        public BSTNode(T data) {
            this.data = data;
        }
    }

    private void add(BSTNode<T> node, BSTNode<T> element) {

        if(element.data.compareTo(node.data) <= 0) {
            if(node.left == null) {
                node.left = element;
                return;
            }
            add(node.left, element);
        } else {
            if(node.right == null) {
                node.right = element;
                return;
            }
            add(node.right, element);
        }

    }

    public void add(T element) {
        var node = new BSTNode<>(element);
        if(root == null) {
            root = node;
            return;
        }

        add(root, node);

    }

    <T> void preOrder(BSTNode<T> node) {

        if(node == null) {
            return;
        }

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);

    }

    <T> void postOrder(BSTNode<T> node){
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);

    }

    <T> void inOrder(BSTNode<T> node){
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);

    }

    // Breadth First Search
    public static <T> void bfs(BSTNode<T> node){


        var queue = new Queue<BSTNode<T>>();
        queue.enqueue(node);

        while(queue.size() > 0) {
            var item = queue.dequeue();
            System.out.println(item.data);

            if(item.left != null)
                queue.enqueue(item.left);
            if(item.right != null)
                queue.enqueue(item.right);
        }
    }

    public static <T> void reverse(BSTNode<T> node) {
        if(node == null) {
            return;
        }

        var t = node.left;
        node.left = node.right;
        node.right = t;

        reverse(node.left);
        reverse(node.right);

    }

    @Test
    public void test(){
        System.out.println("abcdefghijklmn".hashCode());
        var o = new Object();
        o.hashCode();
        var tree = new BSTree<Integer>();

        tree.add(10);
        tree.add(7);
        tree.add(5);
        tree.add(8);
        tree.add(15);
        tree.add(30);
        tree.add(21);

        var printer = new TreePrinter();
        printer.print(tree.root);


        bfs(tree.root);
        //preOrder(tree.root);
        //postOrder(tree.root);
//        inOrder(tree.root);
    }

    @Test
    public void test_reverse(){
        var tree = new BSTree<Integer>();

        tree.add(10);
        tree.add(7);
        tree.add(5);
        tree.add(8);
        tree.add(15);
        tree.add(30);
        tree.add(21);

        var printer = new TreePrinter();
        printer.print(tree.root);

        tree.reverse(tree.root);
        printer.print(tree.root);
    }

}

