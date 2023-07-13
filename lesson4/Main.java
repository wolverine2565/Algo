package homework4;

public class Main {
    public static void main(String[] args) {

        BinTree tree = new BinTree();
    
        tree.add(5);
        tree.add(1);
        tree.add(2);
        tree.add(7);
        tree.add(8);
        tree.add(3);
        tree.add(9);
        tree.add(76);
        tree.add(22);
        tree.add(55);
        tree.add(45);

        System.out.println(tree.search(5));
        System.out.println(tree.search(1));
        System.out.println(tree.search(2));
        System.out.println(tree.search(7));
        System.out.println(tree.search(8));
        System.out.println(tree.search(3));
        System.out.println(tree.search(9));
        System.out.println(tree.search(76));
        System.out.println(tree.search(22));
        System.out.println(tree.search(55));
        System.out.println(tree.search(45));
        
                
    }
}
