class testBST {
    public static void main(String[] args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();    
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(-1);
        bst.insert(10);
        bst.insert(8);
        bst.insert(4);
        bst.insert(9);
        bst.insert(11);

        System.out.println(bst.toString());

        bst.delete(10);
        bst.delete(8);

        System.out.println(bst.toString());
        System.out.println( bst.contains(1));
        System.out.println( bst.contains(2));
        System.out.println( bst.contains(5));
    }
}
