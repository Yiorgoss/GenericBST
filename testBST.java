import java.util.List;
import java.util.ArrayList;

class testBST {
    public static void main(String[] args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();    

        bst.insert(1);
        printTree(bst);
        bst.insert(-3);
        printTree(bst);
        bst.insert(-4);
        printTree(bst);
        bst.insert(-2);
        printTree(bst);
        bst.insert(2);
        printTree(bst);
        bst.insert(5);
        printTree(bst);
        bst.insert(6);
        printTree(bst);

        //System.out.println(bst.toString());
        //toNodeString( bst);

        //bst.delete(10);
        //bst.delete(8);

        //System.out.println(bst);
        //System.out.println( bst.contains(1));
        //System.out.println( bst.contains(2));
        //System.out.println( bst.contains(5));
    }
    public static void printTree( BinarySearchTree bst){

        Node root = bst.root;
        List<List<String>> lines = new ArrayList<List<String>>();

        List<Node> level = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (Node n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = "" + n.data+"-> "+n.height;
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
    public static void toNodeString(BinarySearchTree bst){
        Node root = bst.root;
        List<List<String>> lines = new ArrayList<List<String>>();
        List<Node> level = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        level.add(root);

        int exit = 1;
        int widest = 0;
        while(exit != 0){
            List<String> line = new ArrayList<String>();
            exit = 0; 

            for( Node n : level){
                if(n == null){
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String tmp = ""+ n.data;
                    line.add(tmp);

                    if(tmp.length() > widest){
                        widest = tmp.length();
                    }
                    next.add(n.left);
                    next.add(n.right);

                    if(n.left != null) exit++;
                    if(n.right != null) exit++;
                }
            }
            if(widest % 2 == 0) widest++;
            lines.add(line);
            
            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }
        int perpiece = lines.get(lines.size() -1).size() * (widest + 4);
        for(int i=0; i<lines.size(); i++){
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) -1;
            if(i>0){
                for(int j=0; j<line.size(); j++){
                     char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.println(c);
                //lines and spaces;
                    if(line.get(j)== null){
                        for(int k=0; k<perpiece; k++){
                            System.out.println(" ");
                        }
                    } else {
                        for(int k=0; k<hpw; k++){
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }
            //print line of values
            for( int j=0; j<line.size(); j++){
                String f = line.get(j);
                if (f == null) {
                    f = "";
                }
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                for(int k=0; k<gap1; k++){
                    System.out.println(" ");
                }
                for(int k=0; k<gap2; k++){
                    System.out.println(" ");
                }
                System.out.println();
                perpiece /= 2;
            }
        }
    }
}
