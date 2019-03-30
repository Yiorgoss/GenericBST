import java.lang.Math;
import java.util.ArrayList;

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
        current.height = 1 + Math.max(heightRecursive(current.left),
                              heightRecursive(current.right));

        //perform the self balance;
        //
        int balance_factor = getBalanceFactor(current);

        //4 possible cases
        if( balance_factor > 1 && data.compareTo(current.left.data) < 0){
            return rotateRight(current); 
        }
        if( balance_factor < -1 && data.compareTo(current.right.data) > 0 ) {
            return rotateLeft(current);
        }
        if(balance_factor > 1 && data.compareTo(current.left.data) > 0){
            current.left = rotateLeft(current.left);
            return rotateRight(current);
        }
        if(balance_factor < -1 && data.compareTo(current.right.data) < 0){
            current.right = rotateRight(current.right);
            return rotateLeft(current.right);
        }
        return current;
    }
    public boolean isBalanced(Node<D> current){
        //tester method
        if(current == null){
            return true;
        }
        int left_h = heightRecursive(current.left);
        int right_h = heightRecursive(current.right);

        if(Math.abs(left_h - right_h) <= 2 && isBalanced(current.left) && isBalanced(current.right)){
            return true;
        }
        return false;
    }
    public int heightRecursive(Node<D> current){
        if(current == null){
            return 0;
        }
        return current.height;
    }
    public Node<D> rotateLeft(Node<D> current){
        Node new_top = current.right;
        Node tmp = new_top.left;

        new_top.left = current;
        current.right = tmp;
    
        current.height = 1+Math.max(heightRecursive(current.left), heightRecursive(current.left));
        new_top.height = 1+Math.max(heightRecursive(new_top.left), heightRecursive(new_top.right));

        return new_top;
    }
    public Node<D> rotateRight(Node<D> current){
        Node new_top = current.left;
        Node tmp = new_top.right;

        new_top.right = current;
        current.left = tmp;

        current.height = 1+Math.max(heightRecursive(current.left), heightRecursive(current.left));
        new_top.height = 1+Math.max(heightRecursive(new_top.left), heightRecursive(new_top.right));

        System.out.println("A "+current.height+" B "+new_top.height);

        return new_top;
    }
    public int getBalanceFactor( Node<D> current){
        if(current == null){
            return 0;
        }
        return heightRecursive(current.left) - heightRecursive(current.right);
    }

    public void delete(D data){
        this.root = deleteRecursive(this.root, data);
    }
    public Node<D> deleteRecursive(Node<D> current, D data){
        if(current == null){
            return null;
        } 
        if(current.data.equals(data)){
            if(current.left == null && current.right == null){
                //no children
                return null;
            } else {
                //one child
                if(current.left == null) {
                    return current.right;
                }
                if( current.right == null){
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
            return "<"+ current.data
                +" "+ toStringRecursive(current.left) 
                +" "+ toStringRecursive(current.right) +">";
        }
    }
}







