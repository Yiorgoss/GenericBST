class Node<D extends Comparable<D>>{
    D data;
    Node<D> left;
    Node<D> right;

    Node(D data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    Node(D data, Node<D> left, Node<D> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public int compareTo(D data){
        return this.data.compareTo(data);
    }
    public boolean eqquals(D data){
        System.out.println("ABC");
        return this.data.equals(data);
    }
}
