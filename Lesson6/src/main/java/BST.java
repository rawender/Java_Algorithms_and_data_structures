public class BST<T extends Comparable<T>> implements Tree<T> {

    private int size;
    private Node<T> root;

    public BST() {
        size = 0;
        root = null;
    }

    @Override
    public void add(T element) {
        if(size == 0){
            root = new Node<>(element);
        }
        else {
            add(root, element);
        }
        size++;
    }

    private void add(Node<T> node, T element) {
        if(element.compareTo(node.value) < 0) {
            if(node.left == null){
                node.left  = new Node<>(element);
                node.left.parent = node;
            }
            else{
                add(node.left, element);
            }
        } else if(element.compareTo(node.value) > 0) {
            if(node.right == null){
                node.right = new Node<>(element);
                node.right.parent = node;
            }
            else{
                add(node.right, element);
            }
        }
    }

    @Override
    public void remove(T element) {
        if(size != 0){
            remove(root, element);
        }
    }

    private void remove(Node <T> node, T element) {
        if(element.compareTo(node.value) < 0) {
            if(node.left != null) {
                remove(node.left, element);
            }
        } else if(element.compareTo(node.value) > 0) {
            if(node.right != null){
                remove(node.right, element);
            }
        } else if (element.compareTo(node.value) == 0) {
            remove(node.parent, node, node.right, node.left);
        }
    }

    private void remove(Node <T> nodeParent, Node <T> node, Node <T> nodeRight, Node <T> nodeLeft) {

        if (nodeRight != null && nodeLeft != null) {
            if (nodeParent != null) {
                if (node.value.compareTo(nodeParent.value) < 0) {
                    nodeParent.left = nodeRight;
                    nodeRight.parent = nodeParent;
                    move(nodeRight, nodeLeft);
                } else {
                    nodeParent.right = nodeRight;
                    nodeRight.parent = nodeParent;
                    move(nodeRight, nodeLeft);
                }
            } else {
                root = nodeRight;
                move(nodeRight, nodeLeft);
            }
        } else if (nodeLeft != null) {
            if (nodeParent != null) {
                if (node.value.compareTo(nodeParent.value) < 0) {
                    nodeParent.left = nodeLeft;
                    nodeLeft.parent = nodeParent;
                } else {
                    nodeParent.right = nodeLeft;
                    nodeLeft.parent = nodeParent;
                }
            } else {
                root = nodeLeft;
            }
        } else if (nodeRight != null) {
            if (nodeParent != null) {
                if (node.value.compareTo(nodeParent.value) < 0) {
                    nodeParent.left = nodeRight;
                    nodeRight.parent = nodeParent;
                } else {
                    nodeParent.right = nodeRight;
                    nodeRight.parent = nodeParent;
                }
            } else {
                root = nodeRight;
            }
        } else {
            if (nodeParent != null) {
                if (node.value.compareTo(nodeParent.value) < 0) {
                    nodeParent.left = null;
                } else {
                    nodeParent.right = null;
                }

            } else {
                root = null;
            }
        }
    }

    private void move(Node <T> nodeRight, Node <T> nodeLeft) {
        if(nodeRight.left == null){
            nodeRight.left = nodeLeft;
            nodeRight.left.parent = nodeRight;
        }
        else{
            move(nodeRight.left, nodeLeft);
        }
    }

    @Override
    public boolean find(T element) {
        if(size == 0){
            return false;
        }
        else {
            return find(root, element);
        }
    }

    private boolean find(Node <T> node, T element) {
        if(element.compareTo(node.value) < 0) {
            if(node.left == null) {
                return false;
            }
            else{
                return find(node.left, element);
            }
        } else if(element.compareTo(node.value) > 0) {
            if(node.right == null) {
                return false;
            }
            else{
                return find(node.right, element);
            }
        } else return element.compareTo(node.value) == 0;
    }

    private static StringBuilder str;

    @Override
    public String preOrder() {
        str = new StringBuilder();
        preOrder(root);
        str.insert(0, '[');
        str.delete(str.length()-2, str.length());
        str.append(']');
        return str.toString();
    }

    private void preOrder(Node<T> node) {
        if(node == null) return;
        str.append(node.value).append(',').append(' ');
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String inOrder() {
        str = new StringBuilder();
        inOrder(root);
        str.insert(0, '[');
        str.delete(str.length()-2, str.length());
        str.append(']');
        return str.toString();
    }

    private void inOrder(Node<T> node) {
        if(node == null) return;
        inOrder(node.left);
        str.append(node.value).append(',').append(' ');
        inOrder(node.right);
    }

    @Override
    public String postOrder() {
        str = new StringBuilder();
        postOrder(root);
        str.insert(0, '[');
        str.delete(str.length()-2, str.length());
        str.append(']');
        return str.toString();
    }

    private void postOrder(Node<T> node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        str.append(node.value).append(',').append(' ');
    }

    @Override
    public int size() {
        return size;
    }
}
