package prodsmile.datastructure;


public class TreePrinter {

    <T> int heightOf(BSTree.BSTNode<T> node) {
        if(node == null) {
            return 0;
        }
        return Math.max(
                heightOf(node.left),
                heightOf(node.right)
        ) + 1;
    }


    public <T> void print(BSTree.BSTNode<T> root) {
        int h = heightOf(root);
        int W = 2*(int)Math.pow(2, h);
        var lines = new StringBuilder[h*2];
        for(int i = 0; i < h*2; i++) {
            lines[i] = new StringBuilder(String.format("%" + W + "s", ""));
        }

        printNode(lines, W, root, 0, 0);
        for(var line : lines) {
            System.out.println(line.toString());
        }

    }

    private <T> void printNode(StringBuilder[] lines, int W,  BSTree.BSTNode<T> node, int h, int base) {
        var nums = Math.pow(2, h);
        var pos = base + (int)(W / (nums *  2));

        var str = node.data.toString();
        for(int i = 0; i < str.length(); i++) {
            lines[h*2].setCharAt(pos + i, str.charAt(i));
        }

        if(node.left != null) {
            lines[h*2+1].setCharAt(pos-1, '/');
            printNode(lines, W, node.left, h+1, base);
        }

        if(node.right != null) {
            lines[h*2 + 1].setCharAt(pos + str.length() + 1, '\\');
            printNode(lines, W, node.right, h+1, pos);
        }


    }

}
