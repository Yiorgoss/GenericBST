class BinarySearchTree<D extends Comparable<D>>{

    Node<D> root;
    public BinarySearchTree(){
        this.root = null;
    }

    public boolean contains(D data){
        return containsRecursive(this.root, data);
    }
    public boolean containsRecursive(Node<D> current, D data){

        if(current == null){
            return false;
        } else {
            if(current.data.compareTo(data) > 0){
                return containsRecursive(current.left, data);
            } else if(current.data.compareTo(data) < 0) {
                return containsRecursive(current.right, data); 
            } else {
                return true;
            }
        }
    }
    public void insert(D data){
        this.root = insertRecursive(this.root, data);
    }
    public Node<D> insertRecursive(Node<D> current, D data){
        if(current == null){
            return new Node<D>(data);
        } else {
            if(current.data.compareTo(data) > 0){
                current.left = insertRecursive(current.left, data);
            } else if( current.data.compareTo(data) < 0){
                current.right = insertRecursive(current.right, data);
            } else {
                //data already exits
                return current;
            }
        }
        return current;
    }
    public void delete(D data){
        this.root = deleteRecursive(this.root, data);
    }
    public Node<D> deleteRecursive(Node<D> current, D data){
        if(current == null){
            return null;
        } 
        if(current.data.equals(data)){
            System.out.println("!!!!!!");
            if(current.left == null && current.right == null){
                //no children
                return null;
            } else {
                //one child
                if(current.left == null) {
                    return current.right;
                }
                if( current.right == null){
                    System.out.println("!!!!!!!!!!");
                    return current.left;
                }
                //two children
                //find smallest from right node
                D smallest = findSmallestNode(current.right);
                current.data = smallest;
                current.right = deleteRecursive(current.right, smallest);
                return current;
            }
        }
        if(current.data.compareTo(data)>0){
            deleteRecursive(current.left, data);
            return current;
        }
        deleteRecursive(current.right, data);
        return current;
    }
    public D findSmallestNode(Node<D> current){
        if(current.left == null){
            return current.data;
        }
        return findSmallestNode(current.left);
    }
    public String toString(){
        return "<"+ toStringRecursive( this.root) +">";
    }
    public String toStringRecursive(Node<D> current){
        if(current == null){
            return " ";
        } else {
            return "<"+ toStringRecursive(current.left) 
                +" "+ current.data 
                +" "+ toStringRecursive(current.right) +">";
        }
    }
}







