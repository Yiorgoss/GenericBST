class Node<D extends Comparable<D>>{
    D data;
    int height;
    Node<D> left;
    Node<D> right;

    Node(D data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
    Node(D data, Node<D> left, Node<D> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
